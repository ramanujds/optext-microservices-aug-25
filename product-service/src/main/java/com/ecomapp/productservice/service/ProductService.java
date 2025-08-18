package com.ecomapp.productservice.service;

import com.ecomapp.productservice.model.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAlProducts();

    Product getProductById(long id);

    void deleteProduct(long id);

}
