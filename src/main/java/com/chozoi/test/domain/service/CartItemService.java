package com.chozoi.test.domain.service;

import com.chozoi.test.app.dtos.CartItemDTO;
import com.chozoi.test.app.dtos.TastyDTO;
import com.chozoi.test.domain.entities.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@Transactional
@Slf4j
public class CartItemService extends BaseService{

    private Cart initCart(int cartId){
        Cart cart = new Cart();
        cart.setId(cartId);
        return cart;
    }

    private Tasty initTasty(int tastyId){
        Tasty tasty = new Tasty();
        tasty.setId(tastyId);
        return tasty;
    }

    public ResponseEntity<?> addCartItem(CartItemDTO cartItemDTO){
        if (Objects.nonNull(cartItemDTO)) {
            CartItem cartItem = CartItem.builder()
                    .cart(initCart(cartItemDTO.getCart_id()))
                    .tasty(initTasty(cartItemDTO.getTasty_id()))
                    .quantities(cartItemDTO.getQuantities())
                    .unit_price(cartItemDTO.getUnit_price())
                    .build();
            cartItemRespository.save(cartItem);
            return new ResponseEntity<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.SEE_OTHER.getReasonPhrase(), HttpStatus.SEE_OTHER);
    }

    public ResponseEntity<?> deleteCartItem(int cartItemId){
        CartItem cartItem = cartItemRespository.findById(cartItemId).orElse(null);
        if (Objects.nonNull(cartItem)){
            cartItemRespository.delete(cartItem);
            return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
    }
}
