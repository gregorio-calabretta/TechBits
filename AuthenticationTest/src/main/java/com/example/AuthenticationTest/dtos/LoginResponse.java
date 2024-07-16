package com.example.AuthenticationTest.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LoginResponse {
    private String token;
    private long expiresIn;//si puo togliere
}
