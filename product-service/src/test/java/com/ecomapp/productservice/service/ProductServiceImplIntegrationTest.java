package com.ecomapp.productservice.service;

import com.ecomapp.productservice.exception.ItemNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ProductServiceImplIntegrationTest {

    @Autowired
    ProductServiceImpl productService;

    @Test
    void getProductById() {
        long id = 1;
        assertDoesNotThrow(()->productService.getProductById(1));
    }

    @Test
    void getProductByIdWhenProductNotPresent() {
        long id = 1;
        assertThrows(ItemNotFoundException.class,()->productService.getProductById(100));
    }

}