package com.chozoi.test.app.controller;

import com.chozoi.test.app.dtos.CartDTO;
import com.chozoi.test.app.dtos.UserDTO;
import com.chozoi.test.domain.service.CartService;
import com.chozoi.test.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    @CrossOrigin(origins = "*")             //http://localhost:8088/api/v1/cart
    ResponseEntity<?> addCart(@RequestBody CartDTO cartDTO) throws ParseException {
        return cartService.addCart(cartDTO);
    }

    @GetMapping
    @CrossOrigin(origins = "*")             //http://localhost:8088/api/v1/cart
    ResponseEntity<?> getAllCart(){
        return cartService.getAllCart();
    }

    @DeleteMapping(path = "/{id}")          //http://localhost:8088/api/v1/cart/1
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> deleteCartById(@PathVariable("id") int id){
        return cartService.deleteCart(id);
    }
}
