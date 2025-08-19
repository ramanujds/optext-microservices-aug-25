package com.ecomapp.productservice.api;

import com.ecomapp.productservice.model.Product;
import com.ecomapp.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Test
    void addProduct() {
    }

    @Test
    void getProduct() throws Exception {

        // Given
        long id = 1;
        Product product = new Product();
        product.setId(id);
        product.setName("iPhone 16");
        product.setDescription("Apple iPhone 16");
        product.setPrice(699);

        // When-Then
        Mockito.when(productService.getProductById(id))
                .thenReturn(product);

        mockMvc.perform(get("/api/products/"+id))
                        .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json("""
                        {
                        "id": 1,
                        "name": "iPhone 16",
                        "description": "Apple iPhone 16",
                        "price": 699
                        }
                        """));

        // Verify
        Mockito.verify(productService,Mockito.times(1))
                .getProductById(id);

    }
}