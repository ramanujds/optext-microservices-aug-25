package com.ecomapp.cartservice.service;

import com.ecomapp.cartservice.dto.ProductDTO;
import com.ecomapp.cartservice.model.CartItem;
import com.ecomapp.cartservice.repository.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CartService {

    private CartRepository cartRepo;

    private RestTemplate restTemplate;

    private final String PRODUCT_URL = "http://localhost:8100/api/products";

    public CartService(CartRepository cartRepo, RestTemplate restTemplate) {
        this.cartRepo = cartRepo;
        this.restTemplate = restTemplate;
    }

    public CartItem addItem(long id, int quantity){

       ProductDTO product = restTemplate.getForObject(PRODUCT_URL+"/"+id, ProductDTO.class);

       double totalPrice = quantity * product.price();

       CartItem item = new CartItem(product.id(),product.name(),quantity,product.price(),totalPrice);

       return cartRepo.save(item);

    }

}
