package com.example.AuthenticationTest.service;

import com.example.AuthenticationTest.dtos.UserDtoRequest;
import com.example.AuthenticationTest.dtos.UserDtoResponse;
import com.example.AuthenticationTest.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
     List<UserDtoResponse> findAllUsers();
     UserDtoResponse updateUser(Long id, UserDtoRequest userDtoRequest) throws UserNotFoundException;
     void deleteUser(Long id);
     UserDtoResponse findUserByEmail(String email) throws UserNotFoundException;
}
