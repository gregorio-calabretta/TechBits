package com.example.AuthenticationTest.mapper;

import com.example.AuthenticationTest.dtos.UserDtoResponse;
import com.example.AuthenticationTest.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDtoResponse> {

    public UserDtoResponse map(User user) {
        return new UserDtoResponse(user.getId(),user.getUsername(), user.getEmail());
    }
}
