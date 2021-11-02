package com.santana.java.back.end.productapi.repository;

import com.santana.java.back.end.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p.nome, p.preco, p.productIdentifier, p.descricao " +
            "from Product p " +
            "join p.category c " +
            "where c.id = :category_id ")
    public List<Product> getProductByCategory(@Param("category_id") long categoryId);

    public Product findByProductIdentifier(String productIdentifier);
}
