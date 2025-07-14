package com.example.Tudu.serviceImpl;

import com.example.Tudu.dto.LoginRequest;
import com.example.Tudu.dto.RegisterRequest;
import com.example.Tudu.entities.User;
import com.example.Tudu.repositories.UserRepository;
import com.example.Tudu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTServiceImpl jwtService;
    private final BCryptPasswordEncoder  encoder = new BCryptPasswordEncoder(12);

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager, JWTServiceImpl jwtService) {
        this.userRepository = userRepository;
        this.authenticationManager=authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public User saveUser(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(encoder.encode(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
        user.setRole("USER"); // default role, set if needed

        return userRepository.save(user);
    }


    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(User optionalUser,User userDetails) {
        optionalUser.setEmail(userDetails.getEmail());
        optionalUser.setUsername(userDetails.getUsername());
        return userRepository.save(optionalUser);
    }


    @Override
    public List<User> getAllUserDetails() {
        return userRepository.findAll();
    }

    @Override
    public void DeleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public String verify(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        User user = userRepository.findByUsername(username);
        if (user == null) {
            return "USER NOT FOUND";
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        if (authentication.isAuthenticated()) {
            String token = jwtService.generateToken(
                    user.getUsername(),
                    user.getId(),
                    user.getEmail(),
                    user.getRole(),
                    1000 * 60 * 60
            );
            return token;
        }

        return "INVALID CREDENTIALS";
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
