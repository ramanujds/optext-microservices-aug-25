package com.ecomapp.productservice.service;

import com.ecomapp.productservice.exception.ItemNotFoundException;
import com.ecomapp.productservice.model.Product;
import com.ecomapp.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepo;

    @InjectMocks
    private ProductServiceImpl productService;


    @Test
    void getProductById() {
        // Given
        long id = 1;
        Product product = new Product();
        product.setId(id);
        product.setName("iPhone 16");
        product.setDescription("Apple iPhone 16");
        product.setPrice(699);

        // When-Then
        Mockito.when(productRepo.findById(id))
                .thenReturn(Optional.of(product));

      //  assertEquals(product,productService.getProductById(id));

        assertNotNull(productService.getProductById(id));

        // Verify
        Mockito.verify(productRepo,Mockito.times(1))
                .findById(id);

    }

    @Test
    void getProductByIdWhenProductNotPresent() {
        long id = 1;
        Mockito.when(productRepo.findById(id))
                .thenReturn(Optional.empty());

        assertThrows(ItemNotFoundException.class,()->productService.getProductById(id));
        Mockito.verify(productRepo,Mockito.times(1))
                .findById(id);

        }

}