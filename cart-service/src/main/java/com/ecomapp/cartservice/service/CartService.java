package com.ecomapp.cartservice.service;

import com.ecomapp.cartservice.client.ProductServiceClient;
import com.ecomapp.cartservice.dto.ProductDTO;
import com.ecomapp.cartservice.model.CartItem;
import com.ecomapp.cartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CartService {

    private final String topic="order-events";

    private CartRepository cartRepo;


    private ProductServiceClient productClient;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final String PRODUCT_URL = "http://localhost:8100/api/products";

    public CartService(CartRepository cartRepo, ProductServiceClient productClient, KafkaTemplate<String, String> kafkaTemplate) {
        this.cartRepo = cartRepo;
        this.productClient = productClient;
        this.kafkaTemplate = kafkaTemplate;
    }

    public CartItem addItem(long id, int quantity){

       ProductDTO product = productClient.getProductById(id);

       double totalPrice = quantity * product.price();

       CartItem item = new CartItem(product.id(),product.name(),quantity,product.price(),totalPrice);

       return cartRepo.save(item);

    }

    public List<CartItem> getAllItems(){
        return cartRepo.findAll();
    }

    public List<CartItem> placeOrder(){

        kafkaTemplate.send(topic,"Oder Placed");
        var items = cartRepo.findAll();
        cartRepo.deleteAll();
        return items;

    }

}
