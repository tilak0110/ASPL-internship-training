package com.example.userservice.service;

import com.example.userservice.entities.User;
import com.example.userservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User(1L, "John Doe", "john@example.com", null);
    }

    @Test
    void getAllUsers_ShouldReturnListOfUsers() {
        when(userRepository.findAll()).thenReturn(List.of(user));

        List<User> users = userService.getAllUsers();

        assertFalse(users.isEmpty());
        assertEquals(1, users.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void getUserById_ShouldReturnUser_WhenExists() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> foundUser = userService.getUserById(1L);

        assertTrue(foundUser.isPresent());
        assertEquals(user, foundUser.get());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void getUserById_ShouldReturnEmpty_WhenNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<User> foundUser = userService.getUserById(1L);

        assertFalse(foundUser.isPresent());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void checkById_ShouldReturnTrue_WhenUserExists() {
        // Use doReturn().when() for stubbing
        doReturn(true).when(userRepository).existsById(1L);

        boolean exists = userService.checkById(1L);

        assertTrue(exists);
        verify(userRepository, times(1)).existsById(1L);
    }

    @Test
    void checkById_ShouldReturnFalse_WhenUserDoesNotExist() {
        // Use doReturn().when() for stubbing
        doReturn(false).when(userRepository).existsById(1L);

        boolean exists = userService.checkById(1L);

        assertFalse(exists);
        verify(userRepository, times(1)).existsById(1L);
    }

    @Test
    void addUser_ShouldSaveUserSuccessfully() {
        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.addUser(user);

        assertNotNull(savedUser);
        assertEquals(user.getId(), savedUser.getId());
        assertEquals(user.getName(), savedUser.getName());
        assertEquals(user.getEmail(), savedUser.getEmail());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void addUser_ShouldThrowException_WhenSaveFails() {
        when(userRepository.save(user)).thenThrow(new RuntimeException("Save failed"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> userService.addUser(user));
        assertEquals("Failed to add user", exception.getMessage());
        verify(userRepository, times(1)).save(user);
    }
}