package com.example.AuthenticationTest.service;

import com.example.AuthenticationTest.dtos.UserDtoRequest;
import com.example.AuthenticationTest.dtos.UserDtoResponse;
import com.example.AuthenticationTest.exception.UserNotFoundException;
import com.example.AuthenticationTest.mapper.Mapper;
import com.example.AuthenticationTest.model.User;
import com.example.AuthenticationTest.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{
        private final UserRepo userRepo;
        private final Mapper<User, UserDtoResponse> mapper;
        public UserServiceImpl(UserRepo userRepo, Mapper<User, UserDtoResponse> mapper) {
            this.userRepo = userRepo;
            this.mapper = mapper;
        }

        @Override
        public List<UserDtoResponse> findAllUsers(){
            List<User> userList = userRepo.findAll();
            return mapper.mapAll(userList);
        }
        @Override
        public UserDtoResponse updateUser(Long id, UserDtoRequest userDtoRequest) throws UserNotFoundException {
            User userInDB = userRepo.findById(id)
                    .orElseThrow(() -> new UserNotFoundException("User with id %s not found".formatted(id)));
            User user = User.builder()
                    .id(userInDB.getId())
                    .username(userDtoRequest.getUsername())
                    .email(userDtoRequest.getEmail())
                    .password(userDtoRequest.getPassword())
                    .build();
            userRepo.save(user);
            return mapper.map(user);
        }
        @Override

        @Transactional
        public void deleteUser(Long id){
            userRepo.deleteUserById(id);
        }

    @Override
    public UserDtoResponse findUserByEmail(String email) throws UserNotFoundException {
        User userInDB =  userRepo.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User with email:" + email + "not found"));
        return mapper.map(userInDB);    }


}

    
