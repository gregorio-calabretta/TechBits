package com.example.AuthenticationTest.controller;

import com.example.AuthenticationTest.dtos.UserDtoRequest;
import com.example.AuthenticationTest.dtos.UserDtoResponse;
import com.example.AuthenticationTest.exception.UserNotFoundException;
import com.example.AuthenticationTest.service.UserService;
import com.example.AuthenticationTest.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
        private final UserService userService;

        public UserController(UserServiceImpl userService) {
            this.userService = userService;
        }

        @GetMapping
        public ResponseEntity<List<UserDtoResponse>> getAllUsers(){
            List<UserDtoResponse> usersDto = userService.findAllUsers();
            return ResponseEntity.status(HttpStatus.OK).body(usersDto);
        }

        @GetMapping("/{email}")
        public ResponseEntity<UserDtoResponse> getUserByEmail(@PathVariable String email) throws  UserNotFoundException {
            UserDtoResponse userDto = userService.findUserByEmail(email);
            return ResponseEntity.status(HttpStatus.OK).body(userDto);
        }

        @PutMapping("/{id}")
        public ResponseEntity<UserDtoResponse> updateUser(@PathVariable("id") Long id, @RequestBody UserDtoRequest userDtoRequest) throws UserNotFoundException {
            UserDtoResponse updateUser = userService.updateUser(id, userDtoRequest);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateUser);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteUser(@PathVariable("id")Long id){
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

}

