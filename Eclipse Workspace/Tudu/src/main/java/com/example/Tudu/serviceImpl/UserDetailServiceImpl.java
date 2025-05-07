package com.example.Tudu.serviceImpl;

import com.example.Tudu.entities.User;
import com.example.Tudu.entities.UserPrincipal;
import com.example.Tudu.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    UserRepository userRepository;

    @Autowired
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userRepository.findByUsername(username);
        if(user != null){
            return new UserPrincipal(user);
        }
        throw new UsernameNotFoundException("Invalid Username");
    }
}
