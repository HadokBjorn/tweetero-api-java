package com.tweetero.api.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.dtos.UsersDTO;
import com.tweetero.api.models.UsersModel;
import com.tweetero.api.services.UsersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {
    final UsersService usersService;
    UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UsersDTO body){
        Optional<UsersModel> user = usersService.create(body);

        if(!user.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
