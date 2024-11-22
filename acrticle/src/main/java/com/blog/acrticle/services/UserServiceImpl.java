package com.blog.acrticle.services;

import com.blog.acrticle.dtos.ApiResponseDto;
import com.blog.acrticle.dtos.ApiResponseStatus;
import com.blog.acrticle.dtos.UserRegistrationDTO;
import com.blog.acrticle.exceptions.UserAlreadyExistsException;
import com.blog.acrticle.exceptions.UserNotFoundException;
import com.blog.acrticle.exceptions.UserServiceLogicException;
import com.blog.acrticle.models.User;
import com.blog.acrticle.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<ApiResponseDto<?>> registerUser(UserRegistrationDTO newUserDetails) throws UserAlreadyExistsException, UserServiceLogicException {
        try {
            if (userRepository.findByEmail(newUserDetails.getEmail())!=null) {
                throw new UserAlreadyExistsException("Registration failed: User already exists with email " + newUserDetails.getEmail());
            }
            if (userRepository.findByUserName(newUserDetails.getUserName())!=null) {
                throw new UserAlreadyExistsException("Registration failed: User already exists with username " + newUserDetails.getUserName());
            }
            User newUser=new User() ;
            newUser.setEmail(newUserDetails.getEmail());
            newUser.setUsername(newUserDetails.getUserName());
            newUser.setPhone(newUserDetails.getPhone());
            newUser.setRegDateAndTime(LocalDateTime.now());
            userRepository.save(newUser);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponseDto<>(ApiResponseStatus.SUCCESS.name(),
                            "New user account has been successfully created!"));
        }catch (UserAlreadyExistsException e){
            throw new UserAlreadyExistsException(e.getMessage());
        }catch (Exception e){
            log.error("Failed to create new user account: " + e.getMessage());
            throw new UserServiceLogicException();
        }
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
