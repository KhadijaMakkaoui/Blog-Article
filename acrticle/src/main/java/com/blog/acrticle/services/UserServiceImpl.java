package com.blog.acrticle.services;

import com.blog.acrticle.dtos.ApiResponseDto;
import com.blog.acrticle.dtos.UserRegistrationDTO;
import com.blog.acrticle.exceptions.UserAlreadyExistsException;
import com.blog.acrticle.exceptions.UserNotFoundException;
import com.blog.acrticle.exceptions.UserServiceLogicException;
import com.blog.acrticle.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<ApiResponseDto<?>> registerUser(UserRegistrationDTO newUserDetails) throws UserAlreadyExistsException, UserServiceLogicException {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponseDto<?>> getAllUsers() throws UserNotFoundException, UserServiceLogicException {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponseDto<?>> deleteUser(int id) throws UserNotFoundException, UserServiceLogicException {
        return null;
    }
}
