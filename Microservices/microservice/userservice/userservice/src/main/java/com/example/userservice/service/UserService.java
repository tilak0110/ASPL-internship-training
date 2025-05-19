package com.example.userservice.service;

import com.example.userservice.entities.User;
import com.example.userservice.repository.UserRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    public List<User> getAllUsers() {
        logger.info("Fetching all users...");
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            logger.warning("No users found.");
        } else {
            logger.info("Fetched " + users.size() + " users.");
        }

        return users.isEmpty() ? Collections.emptyList() : users;
    }


    @CircuitBreaker(name = "userService", fallbackMethod = "fallbackGetUserById")
    @Retry(name = "userService", fallbackMethod = "fallbackGetUserById")
    public Optional<User> getUserById(Long id) {
        logger.info("Fetching user with ID: " + id);
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            logger.info("User found: " + user.get());
        } else {
            logger.warning("User with ID " + id + " not found.");
        }

        return user;
    }

    public Optional<User> fallbackGetUserById(Long id, Throwable ex) {
        logger.warning("CircuitBreaker fallback triggered for getUserById with ID: " + id + ". Error: " + ex.getMessage());
        return Optional.empty();  // Return an empty Optional, indicating no user found
    }

    @CircuitBreaker(name = "userService", fallbackMethod = "fallbackExistsById")
    @Retry(name = "userService", fallbackMethod = "fallbackExistsById")
    public boolean checkById(Long id) {
        logger.info("Checking if user exists with ID: " + id);
        boolean exists = userRepository.existsById(id);

        if (exists) {
            logger.info("User with ID " + id + " exists.");
        } else {
            logger.warning("User with ID " + id + " does not exist.");
        }

        return exists;
    }

    public boolean fallbackExistsById(Long id, Throwable ex) {
        logger.warning("CircuitBreaker fallback triggered for existsById with ID: " + id + ". Error: " + ex.getMessage());
        return false;  // Return false, indicating user does not exist in case of failure
    }

    @CircuitBreaker(name = "userService", fallbackMethod = "fallbackAddUser")
    @Retry(name = "userService", fallbackMethod = "fallbackAddUser")
    public User addUser(User user) {
        logger.info("Attempting to add new user: " + user);
        try {
            User savedUser = userRepository.save(user);
            logger.info("User added successfully with ID: " + savedUser.getId());
            return savedUser;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while adding user: ", e);
            throw new RuntimeException("Failed to add user");
        }
    }


    public User fallbackAddUser(User user, Exception ex) {
        logger.warning("Fallback triggered for adding user: " + user + ". Error: " + ex.getMessage());
        return new User(0000l,"DUMMY","DUMMY@email.com",null);
    }
}
