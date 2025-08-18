package com.ecomapp.cartservice.client;

import com.ecomapp.cartservice.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "http://localhost:8100")
public interface ProductServiceClient {

    @GetMapping("/api/products/{id}")
    public ProductDTO getProductById(@PathVariable long id);


}
