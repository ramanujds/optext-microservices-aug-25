package com.ecomapp.cartservice.client;

import com.ecomapp.cartservice.dto.ProductDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductServiceClient {

    @GetMapping("/api/products/{id}")
    @CircuitBreaker(name = "product-client", fallbackMethod = "getProductByIdFallback")
    public ProductDTO getProductById(@PathVariable long id);

    default ProductDTO getProductByIdFallback(@PathVariable long id, Exception ex){
        System.err.println("Fallback Method Invoked");
        System.out.println(ex.getMessage());
        return new ProductDTO(id,"Unknown Product",0);
    }


}
