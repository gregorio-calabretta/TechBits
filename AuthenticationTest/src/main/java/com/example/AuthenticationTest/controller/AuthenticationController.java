package com.example.AuthenticationTest.controller;

import com.example.AuthenticationTest.dtos.LoginResponse;
import com.example.AuthenticationTest.dtos.LoginUserDto;
import com.example.AuthenticationTest.dtos.RegisterUserDto;
import com.example.AuthenticationTest.dtos.UserDtoResponse;
import com.example.AuthenticationTest.mapper.Mapper;
import com.example.AuthenticationTest.model.User;
import com.example.AuthenticationTest.service.AuthenticationService;
import com.example.AuthenticationTest.utils.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {


    private final AuthenticationService authenticationService;
    private final Mapper mapper;

    public AuthenticationController(AuthenticationService authenticationService, Mapper mapper) {
        this.authenticationService = authenticationService;
        this.mapper = mapper;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDtoResponse> register(@RequestBody RegisterUserDto registerUserDto) {
        UserDtoResponse registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = JwtUtils.generateToken(authenticatedUser);

        LoginResponse loginResponse =  LoginResponse.builder().token(jwtToken).expiresIn(JwtUtils.getExpirationTime()).build();

        return ResponseEntity.ok(loginResponse);
    }

}