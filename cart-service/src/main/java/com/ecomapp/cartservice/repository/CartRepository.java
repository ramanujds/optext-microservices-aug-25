package com.ecomapp.cartservice.repository;

import com.ecomapp.cartservice.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, Long> {
}
