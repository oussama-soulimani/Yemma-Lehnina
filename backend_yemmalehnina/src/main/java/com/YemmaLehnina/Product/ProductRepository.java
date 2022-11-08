package com.YemmaLehnina.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductByName(String name);

    @Query("SELECT p FROM Product p WHERE p.category = ?1")
    List<Product> findProductByCategory(String category);
}
