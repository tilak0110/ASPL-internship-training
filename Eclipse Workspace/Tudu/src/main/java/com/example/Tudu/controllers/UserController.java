package com.example.Tudu.controllers;


import com.example.Tudu.dto.LoginRequest;
import com.example.Tudu.dto.RegisterRequest;
import com.example.Tudu.entities.User;
import com.example.Tudu.exceptions.UserNotFoundException;
import com.example.Tudu.serviceImpl.JWTServiceImpl;
import com.example.Tudu.serviceImpl.UserServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
@Tag(name = "User Controller", description = "Manages user registration, login and admin actions")
public class UserController {

    private final UserServiceImpl userService;
    private final JWTServiceImpl jwtService;

    @Autowired
    public UserController(UserServiceImpl userService, JWTServiceImpl jwtService1){
        this.userService = userService;
        this.jwtService = jwtService1;

    }

    @Operation(summary = "Get all users (Admin only)")
    @GetMapping("/admin/getall")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUserDetails());
    }

    @Operation(summary = "Login a user")
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest);
        return userService.verify(loginRequest);
    }

    @Operation(summary = "Register a new user")
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        System.out.println(registerRequest);
        User savedUser = userService.saveUser(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }


    @Operation(summary = "Get user by ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") long id) {
        Optional<User> user = userService.findById(id);
        if(user.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            throw new UserNotFoundException("User with ID : "+ id+" Not found");
        }
    }

    @Operation(summary = "Get own Details")
    @GetMapping
    public ResponseEntity<?> getOwnDetails(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        User user= null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            String username = jwtService.extractUsername(token);

            if (username != null) {
                user = userService.getUserByUsername(username);
            }
        }
        if(user!=null){
           return ResponseEntity.status(HttpStatus.OK).body(user);
        }else {
            throw new UserNotFoundException("User Not found");
        }

    }

    @Operation(summary = "Update user information")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User userDetails){
        Optional<User> optionalUser = userService.findById(id);
        if(optionalUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No User with id : "+id + " Found");
        }
        User updatedUser = userService.updateUser(optionalUser.get(), userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @Operation(summary = "Delete a user by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
        Optional<User> optionalUser = userService.findById(id);
        if(optionalUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No User with id : "+id + " Found");
        }
        userService.DeleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User deleted with id : "+id);
    }

    @Operation(summary = "Get CSRF token")
    @GetMapping("/token")
    public String getToken(HttpServletRequest request) {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        System.out.println("CSRF Token: " + csrfToken.getToken());
        return "tokenPage"; // return view
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}