package com.ecomapp.productservice.api;

import com.ecomapp.productservice.model.Product;
import com.ecomapp.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product){
       return productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAlProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id){
        return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/search")
    public List<Product> searchByName(@RequestParam("name") String name){
        return productService.searchByName(name);
    }


}
