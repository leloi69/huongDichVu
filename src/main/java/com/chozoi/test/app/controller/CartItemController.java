package com.chozoi.test.app.controller;

import com.chozoi.test.app.dtos.CartDTO;
import com.chozoi.test.app.dtos.CartItemDTO;
import com.chozoi.test.domain.entities.CartItem;
import com.chozoi.test.domain.service.CartItemService;
import com.chozoi.test.domain.service.TastyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/cartItem")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    @CrossOrigin(origins = "*")             //http://localhost:8088/api/v1/cartItem
    ResponseEntity<?> addCart(@RequestBody CartItemDTO cartItemDTO) throws ParseException {
        return cartItemService.addCartItem(cartItemDTO);
    }

    @DeleteMapping(path = "/{id}")          //http://localhost:8088/api/v1/cartItem/1
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> deleteCartById(@PathVariable("id") int id){
        return cartItemService.deleteCartItem(id);
    }
}
