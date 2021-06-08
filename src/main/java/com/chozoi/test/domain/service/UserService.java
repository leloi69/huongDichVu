package com.chozoi.test.domain.service;

import com.chozoi.test.app.dtos.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import com.chozoi.test.domain.entities.User;

@Service
@Transactional
@Slf4j
public class UserService extends BaseService{
    public ResponseEntity<?> findByUser(String name){
        List<User> user = userRepository.findByName(name);
        //cach 1
        List<UserDTO> dtos = convertListUserToDTOs(user);
        return ResponseEntity.ok(dtos);
        //cach 2
//        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<?> addUser(UserDTO userDTO){
        if (Objects.nonNull(userDTO)) {
            User user = User.builder()
                    .name(userDTO.getName())
                    .password(userDTO.getPassword())
                    .build();
            userRepository.save(user);
            return new ResponseEntity<>("Tạo thành công", HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.SEE_OTHER.getReasonPhrase(), HttpStatus.SEE_OTHER);
    }

    public ResponseEntity<?> updateUser(UserDTO userDTO, int id){
        User udpated = getUserById(id);
        if (Objects.nonNull(udpated)) {
            udpated.setName(userDTO.getName());
            udpated.setPassword(userDTO.getPassword());

            userRepository.saveAndFlush(udpated);
            return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.SEE_OTHER.getReasonPhrase(), HttpStatus.SEE_OTHER);
    }

    public ResponseEntity<?> deleteUser(int userId){
        User user = userRepository.findById(userId).orElse(null);
        if (Objects.nonNull(user)){
            userRepository.delete(user);
            return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> getAllUser(){
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    private User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }
}
