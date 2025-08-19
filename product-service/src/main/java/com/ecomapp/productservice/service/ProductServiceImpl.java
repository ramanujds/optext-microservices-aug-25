package com.ecomapp.productservice.service;

import com.ecomapp.productservice.exception.DuplicateItemException;
import com.ecomapp.productservice.exception.ItemNotFoundException;
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

        if (productRepo.existsById(product.getId())){
            throw new DuplicateItemException("Product with id "+product.getId()+ " Already Present");
        }
        return productRepo.save(product);
    }

    public List<Product> getAlProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(long id) {

        return productRepo.findById(id).orElseThrow(() -> new ItemNotFoundException("Item with id "+id+ " Not found"));
    }

    public void deleteProduct(long id) {

        if (!productRepo.existsById(id)){
            throw new ItemNotFoundException("Item with id "+id+ " Not found");
        }
        productRepo.deleteById(id);

    }

    public List<Product> searchByName(String name) {
        return productRepo.findByNameContainingIgnoreCase(name);
    }
}
