package com.santana.java.back.end.shoppingapi.service;

import com.santana.java.back.end.client.model.dto.ItemDTO;
import com.santana.java.back.end.client.model.dto.ProductDTO;
import com.santana.java.back.end.client.model.dto.ShopDTO;
import com.santana.java.back.end.client.model.dto.UserDTO;
import com.santana.java.back.end.shoppingapi.dto.DTOConverter;
import com.santana.java.back.end.shoppingapi.dto.ShopReportDTO;
import com.santana.java.back.end.shoppingapi.model.Shop;
import com.santana.java.back.end.shoppingapi.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    public List<ShopDTO> getAll(){
        List<Shop> shops = shopRepository.findAll();
        return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser(String userIdentifier){
        List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifier);
        return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
    }

    public List<ShopDTO> getByDate(ShopDTO shopDTO){
        List<Shop> shops = shopRepository.findAllByShopDateGreaterThan(shopDTO.getShopDate());
        return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
    }

    public ShopDTO findById(long productId){
        Optional<Shop> shop = shopRepository.findById(productId);
        if(shop.isPresent()){
            return DTOConverter.convert(shop.get());
        }
        return null;
    }

    public ShopDTO save(ShopDTO shopDTO, String key){
        UserDTO userDTO =userService.getUserByCpf(shopDTO.getUserIdentifier(), key);

        validateProducts(shopDTO.getItems());

        shopDTO.setTotal(shopDTO.getItems().stream().map(x -> x.getPrice()).reduce((float)0,Float::sum));
        Shop shop = Shop.convert(shopDTO);
        shop.setShopDate(new Date());
        shop = shopRepository.save(shop);
        return DTOConverter.convert(shop);
    }

    private boolean validateProducts(List<ItemDTO> items) {
        for(ItemDTO item : items){
            ProductDTO productDTO = productService.getProductByIdentifier(item.getProductIdentifier());
            if(productDTO == null){
                return false;
            }
            item.setPrice(productDTO.getPreco());
        }
        return true;
    }

    public List<ShopDTO> getShopsByFilter(Date dataInicio, Date dataFim, Float valorMinimo){
        List<Shop> shops = shopRepository.getShopByFilters(dataInicio, dataFim, valorMinimo);
        return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
    }

    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim) {
        return shopRepository.getReportByDate(dataInicio, dataFim);
    }
}
