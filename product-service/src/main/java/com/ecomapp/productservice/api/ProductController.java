package com.ecomapp.productservice.api;

import com.ecomapp.productservice.model.Product;
import com.ecomapp.productservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {


    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public Product addProduct(@RequestBody Product product){
       return productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAlProducts();
    }


}
