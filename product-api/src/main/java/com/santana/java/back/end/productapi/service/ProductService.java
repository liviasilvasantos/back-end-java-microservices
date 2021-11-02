package com.santana.java.back.end.productapi.service;

import com.santana.java.back.end.client.model.dto.ProductDTO;
import com.santana.java.back.end.productapi.dto.DTOConverter;
import com.santana.java.back.end.productapi.exception.CategoryNotFoundException;
import com.santana.java.back.end.productapi.exception.ProductNotFoundException;
import com.santana.java.back.end.productapi.model.Product;
import com.santana.java.back.end.productapi.repository.CategoryRepository;
import com.santana.java.back.end.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<ProductDTO> getAll(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(DTOConverter::convert).collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByCategoryId(Long categoryId){
        List<Product> products = productRepository.getProductByCategory(categoryId);
        return products.stream().map(DTOConverter::convert).collect(Collectors.toList());
    }

    public ProductDTO findByProductIdentifier(String productIdentifier){
        Product product = productRepository.findByProductIdentifier(productIdentifier);
        if(product != null){
            return DTOConverter.convert(product);
        }
        throw new ProductNotFoundException();
    }

    public ProductDTO save(ProductDTO productDTO){
        Boolean existsCategory = categoryRepository.existsById(productDTO.getCategory().getId());
        if(!existsCategory){
            throw new CategoryNotFoundException();
        }

        Product product = productRepository.save(Product.convert(productDTO));
        return DTOConverter.convert(product);
    }

    public void delete(long productId){
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()){
            productRepository.delete(product.get());
        }
        throw new ProductNotFoundException();
    }
}
