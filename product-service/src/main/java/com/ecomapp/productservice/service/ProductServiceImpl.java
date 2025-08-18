package com.ecomapp.productservice.service;

import com.ecomapp.productservice.model.Product;
import com.ecomapp.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepo;

    public ProductServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getAlProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(long id) {
        return productRepo.findById(id).get();
    }

    public void deleteProduct(long id) {

        productRepo.deleteById(id);

    }
}
