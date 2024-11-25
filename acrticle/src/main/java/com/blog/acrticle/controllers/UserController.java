package com.blog.acrticle.controllers;

import com.blog.acrticle.dtos.ApiResponseDto;
import com.blog.acrticle.dtos.UserRegistrationDTO;
import com.blog.acrticle.exceptions.UserAlreadyExistsException;
import com.blog.acrticle.exceptions.UserNotFoundException;
import com.blog.acrticle.exceptions.UserServiceLogicException;
import com.blog.acrticle.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping("/new")
    public ResponseEntity<ApiResponseDto<?>> registerUser(@Valid @RequestBody UserRegistrationDTO userDetails) throws UserAlreadyExistsException, UserServiceLogicException {
        return userService.registerUser(userDetails);
    }

    @GetMapping("/get/all")
    public ResponseEntity<ApiResponseDto<?>> getAllUsers() throws UserServiceLogicException, UserNotFoundException {
        return userService.getAllUsers();
    }
}
