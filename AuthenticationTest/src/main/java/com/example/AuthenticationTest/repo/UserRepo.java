package com.example.AuthenticationTest.repo;

import com.example.AuthenticationTest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

        void deleteUserById(Long id);
        Optional<User> findByEmail(String email);

        Optional<User> findById(Long id);

        Optional<User> findByUsername(String username);
}


