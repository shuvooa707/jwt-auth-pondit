package com.enummitanno.jwtauthpondit.service;

import com.enummitanno.jwtauthpondit.model.User;
import com.enummitanno.jwtauthpondit.repository.UserRepository;
import com.enummitanno.jwtauthpondit.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(RegisterRequest registerRequest) {
        User newUser = new User();
        newUser.setUsername(registerRequest.getUsername());
        newUser.setPassword(  passwordEncoder.encode(registerRequest.getPassword()) );
        newUser.setName(registerRequest.getName());

        userRepository.save(newUser);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    // Add your service methods here

}
