package com.chozoi.test.domain.service;

import com.chozoi.test.ModelMapper;
import com.chozoi.test.app.dtos.*;
import com.chozoi.test.domain.entities.*;
import com.chozoi.test.domain.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BaseService {

    @Autowired protected UserRepository userRepository;             //khai báo biến dùng class

    @Autowired protected TastyRepository tastyRepository;

    @Autowired protected CartRespository cartRepository;

    @Autowired protected CartItemRespository cartItemRespository;

    @Autowired ModelMapper modelMapper;

//    private CustomerDTO login(int id, String password){
//        Customer customer = customerRepository.findByIdAndPassword(id, password);
//        return convertCustomerToDTO(customer);
//    }

//    protected CustomerDTO convertCustomerToDTO(Customer customer){
//        return modelMapper.customerToResponse(customer);
//    }


    protected UserDTO convertUserToDTO(User user){
        return modelMapper.UserToResponse(user);
    }

    protected List<UserDTO> convertListUserToDTOs(List<User> models){
        return models.stream().map(this::convertUserToDTO).collect(Collectors.toList());
    }

    protected TastyDTO convertTastyToDTO(Tasty tasty){
        return modelMapper.TastyToResponse(tasty);
    }

    protected List<TastyDTO> convertListTastyToDTOs(List<Tasty> models){
        return models.stream().map(this::convertTastyToDTO).collect(Collectors.toList());
    }

    protected CartDTO convertCartToDTO(Cart cart){
        return modelMapper.CartToResponse(cart);
    }

    protected List<CartDTO> convertListCartToDTOs(List<Cart> models){
        return models.stream().map(this::convertCartToDTO).collect(Collectors.toList());
    }
}
