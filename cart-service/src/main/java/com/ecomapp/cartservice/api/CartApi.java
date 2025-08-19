package com.ecomapp.cartservice.api;

import com.ecomapp.cartservice.model.CartItem;
import com.ecomapp.cartservice.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<CartItem> getAllItems(){
        return cartService.getAllItems();
    }


    @PostMapping("/order")
    public List<CartItem> placeOrder(){
       return cartService.placeOrder();
    }

}
