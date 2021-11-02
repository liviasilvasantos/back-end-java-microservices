package com.santana.java.back.end.shoppingapi.service;

import com.santana.java.back.end.client.model.dto.ProductDTO;
import com.santana.java.back.end.shoppingapi.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    @Value("${PRODUCT_API_URL:http://localhost:8081/product/}")
    private String productApiUrl;

    public ProductDTO getProductByIdentifier(String productIdentifier){
        try{
            RestTemplate restTemplate = new RestTemplate();
            String url = productApiUrl + productIdentifier;
            ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url,ProductDTO.class);
            return response.getBody();
        } catch(HttpClientErrorException.NotFound ex){
            throw new ProductNotFoundException();
        }


    }
}
