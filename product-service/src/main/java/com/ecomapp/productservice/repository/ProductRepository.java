package com.ecomapp.productservice.repository;

import com.ecomapp.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
