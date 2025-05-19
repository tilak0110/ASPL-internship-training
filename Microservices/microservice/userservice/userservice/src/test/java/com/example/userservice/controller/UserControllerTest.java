package com.example.userservice.controller;

import com.example.userservice.entities.User;
import com.example.userservice.service.UserService;
import org.joda.time.Instant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private User user;

    @BeforeEach
    void setUp() {

        user = new User(1L, "John Doe", "john@example.com", new Timestamp(System.currentTimeMillis()));
    }

    @Test
    void checkUserExists_ShouldReturnTrue_WhenUserExists() {

        when(userService.checkById(1L)).thenReturn(true);


        ResponseEntity<Boolean> response = userController.checkUserExists(1L);


        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody());
        verify(userService, times(1)).checkById(1L);
    }

    @Test
    void checkUserExists_ShouldReturnFalse_WhenUserDoesNotExist() {

        when(userService.checkById(1L)).thenReturn(false);


        ResponseEntity<Boolean> response = userController.checkUserExists(1L);


        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody());
        verify(userService, times(1)).checkById(1L);
    }

    @Test
    void getAllUsers_ShouldReturnListOfUsers() {

        when(userService.getAllUsers()).thenReturn(List.of(user));


        ResponseEntity<List<User>> response = userController.getAllUsers();


        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
        assertEquals(1, response.getBody().size());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void getAllUsers_ShouldReturnNoContent_WhenNoUsersExist() {

        when(userService.getAllUsers()).thenReturn(Collections.emptyList());


        ResponseEntity<List<User>> response = userController.getAllUsers();


        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void getUserById_ShouldReturnUser_WhenUserExists() {

        when(userService.getUserById(1L)).thenReturn(Optional.of(user));


        ResponseEntity<User> response = userController.getUserById(1L);


        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(user, response.getBody());
        verify(userService, times(1)).getUserById(1L);
    }

    @Test
    void getUserById_ShouldReturnNotFound_WhenUserDoesNotExist() {

        when(userService.getUserById(1L)).thenReturn(Optional.empty());


        ResponseEntity<User> response = userController.getUserById(1L);


        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(userService, times(1)).getUserById(1L);
    }

    @Test
    void addUser_ShouldReturnCreated_WhenUserIsSavedSuccessfully() {

        when(userService.addUser(user)).thenReturn(user);


        ResponseEntity<User> response = userController.addUser(user);


        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(user, response.getBody());
        verify(userService, times(1)).addUser(user);
    }

    @Test
    void addUser_ShouldReturnUnprocessableEntity_WhenUserIsNotSaved() {

        User dummyUser = new User(0000L, "DUMMY", "DUMMY@email.com", null);
        when(userService.addUser(user)).thenReturn(dummyUser);


        ResponseEntity<User> response = userController.addUser(user);


        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(dummyUser, response.getBody());
        verify(userService, times(1)).addUser(user);
    }

//    @Test
//    void addUser_ShouldReturnInternalServerError_WhenExceptionOccurs() {
//
//        when(userService.addUser(user)).thenThrow(new RuntimeException("Save failed"));
//
//
//        ResponseEntity<User> response = userController.addUser(user);
//
//
//    }
}