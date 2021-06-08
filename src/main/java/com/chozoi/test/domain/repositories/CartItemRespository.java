package com.chozoi.test.domain.repositories;

import com.chozoi.test.domain.entities.Cart;
import com.chozoi.test.domain.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRespository extends JpaRepository<CartItem, Integer> {
}
