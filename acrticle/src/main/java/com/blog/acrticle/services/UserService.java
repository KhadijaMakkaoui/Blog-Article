package com.blog.acrticle.services;

import com.blog.acrticle.dtos.ApiResponseDto;
import com.blog.acrticle.dtos.UserRegistrationDTO;
import com.blog.acrticle.exceptions.UserAlreadyExistsException;
import com.blog.acrticle.exceptions.UserNotFoundException;
import com.blog.acrticle.exceptions.UserServiceLogicException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseEntity<ApiResponseDto<?>> registerUser(UserRegistrationDTO newUserDetails)
        throws UserAlreadyExistsException, UserServiceLogicException;
    ResponseEntity<ApiResponseDto<?>> getAllUsers()
        throws UserNotFoundException, UserServiceLogicException;

    ResponseEntity<ApiResponseDto<?>> deleteUser(int id)
        throws UserNotFoundException, UserServiceLogicException;

    ResponseEntity<ApiResponseDto<?>> updateUser(UserRegistrationDTO newUserDetails, int id)
            throws UserNotFoundException, UserServiceLogicException;


}
