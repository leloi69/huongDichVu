package com.chozoi.test.app.controller;

import com.chozoi.test.app.dtos.UserDTO;
import com.chozoi.test.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(params = "name")        //http://localhost:8088/api/v1/users?name=loipro
    @CrossOrigin(origins = "*")
    ResponseEntity<?> findByUserByName(@RequestParam("name") String name){
        return userService.findByUser(name);
    }

    @PostMapping
    @CrossOrigin(origins = "*")             //http://localhost:8088/api/v1/users
    ResponseEntity<?> addUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @PutMapping(path = "/{id}")         //http://localhost:8088/api/v1/users/10
    ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO,
                                 @PathVariable("id") int id){
        return userService.updateUser(userDTO, id);
    }

    @GetMapping                        //http://localhost:8088/api/v1/users
    ResponseEntity<?> getAllUser(){
        return userService.getAllUser();
    }

    @DeleteMapping(path = "/{id}")          //http://localhost:8088/api/v1/users/10
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") int id){
        return userService.deleteUser(id);
    }
}
