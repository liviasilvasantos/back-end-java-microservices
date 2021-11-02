package com.santana.java.back.end.productapi.dto;

import com.santana.java.back.end.client.model.dto.CategoryDTO;
import com.santana.java.back.end.client.model.dto.ProductDTO;
import com.santana.java.back.end.productapi.model.Category;
import com.santana.java.back.end.productapi.model.Product;

public class DTOConverter {

    public static CategoryDTO convert(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setNome(category.getNome());
        return categoryDTO;
    }

    public static ProductDTO convert(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(product.getNome());
        productDTO.setPreco(product.getPreco());
        productDTO.setProductIdentifier(product.getProductIdentifier());
        productDTO.setDescricao(product.getDescricao());
        if(product.getCategory() != null){
            productDTO.setCategory(DTOConverter.convert(product.getCategory()));
        }
        return productDTO;
    }
}
