package com.example.AuthenticationTest.service;

import com.example.AuthenticationTest.dtos.LoginUserDto;
import com.example.AuthenticationTest.dtos.RegisterUserDto;
import com.example.AuthenticationTest.dtos.UserDtoResponse;
import com.example.AuthenticationTest.mapper.UserMapper;
import com.example.AuthenticationTest.model.User;
import com.example.AuthenticationTest.repo.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepo userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final UserMapper mapper;

    public AuthenticationService(
            UserRepo userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder, UserMapper mapper
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    public UserDtoResponse signup(RegisterUserDto input) {
        User user =  User.builder()
                .username(input.getUsername())
                .email(input.getEmail())
                .password(passwordEncoder.encode(input.getPassword()))
                .build();
         userRepository.save(user);
         return mapper.map(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

       return userRepository.findByUsername(input.getUsername())
                .orElseThrow();
    }
}
