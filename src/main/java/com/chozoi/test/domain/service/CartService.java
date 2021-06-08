package com.chozoi.test.domain.service;

import com.chozoi.test.app.dtos.CartDTO;
import com.chozoi.test.app.dtos.TastyDTO;
import com.chozoi.test.domain.entities.Cart;
import com.chozoi.test.domain.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
//@Transactional
@Slf4j
public class CartService extends BaseService{

    private User initUser(int userId){
        User user = new User();
        user.setId(userId);
        return user;
    }

    public ResponseEntity<?> addCart(CartDTO cartDTO) throws ParseException {
        if (Objects.nonNull(cartDTO)) {
            Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(cartDTO.getDate());
            System.out.println(date);
            Cart cart = Cart.builder()
                    .cost(cartDTO.getCost())
                    .user(initUser(cartDTO.getUser_id()))
                    .createdAt(date)
                    .phone(cartDTO.getPhone())
                    .address(cartDTO.getAddress())
                    .build();
            cartRepository.save(cart);
            return new ResponseEntity<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.SEE_OTHER.getReasonPhrase(), HttpStatus.SEE_OTHER);
    }

    public ResponseEntity<?> getAllCart(){
        List<Cart> cart = cartRepository.findAll();
        List<CartDTO> dtos = convertListCartToDTOs(cart);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteCart(int cartId){
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (Objects.nonNull(cart)){
            cartRepository.delete(cart);
            return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
    }
}
