package com.ecomapp.cartservice.api;

import com.ecomapp.cartservice.model.CartItem;
import com.ecomapp.cartservice.service.CartService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartApi {

    private CartService cartService;

    public CartApi(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/product/{id}/quantity/{quantity}")
    public CartItem addItem(@PathVariable long id, @PathVariable int quantity){
        return cartService.addItem(id,quantity);
    }


}
