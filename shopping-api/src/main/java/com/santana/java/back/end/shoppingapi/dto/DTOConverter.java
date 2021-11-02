package com.santana.java.back.end.shoppingapi.dto;

import com.santana.java.back.end.client.model.dto.ItemDTO;
import com.santana.java.back.end.client.model.dto.ShopDTO;
import com.santana.java.back.end.shoppingapi.model.Item;
import com.santana.java.back.end.shoppingapi.model.Shop;

public class DTOConverter {

    public static ItemDTO convert(Item item){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setPrice(item.getPrice());
        itemDTO.setProductIdentifier(item.getProductIdentifier());
        return itemDTO;
    }

    public static ShopDTO convert(Shop shop){
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setTotal(shop.getTotal());
        return shopDTO;
    }
}
