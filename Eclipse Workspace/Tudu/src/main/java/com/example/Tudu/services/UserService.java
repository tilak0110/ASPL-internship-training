package com.example.Tudu.services;


import com.example.Tudu.dto.LoginRequest;
import com.example.Tudu.dto.RegisterRequest;
import com.example.Tudu.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(RegisterRequest registerRequest);


    Optional<User> findById(long id);

    User updateUser(User user,User userDetails);

    List<User> getAllUserDetails();

    void DeleteUserById(long id);

    String verify(LoginRequest loginRequest);

    User getUserByUsername(String username);
}
