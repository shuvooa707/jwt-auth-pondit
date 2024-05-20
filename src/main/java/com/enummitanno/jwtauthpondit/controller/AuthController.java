package com.enummitanno.jwtauthpondit.controller;

import com.enummitanno.jwtauthpondit.request.LoginRequest;
import com.enummitanno.jwtauthpondit.request.RegisterRequest;
import com.enummitanno.jwtauthpondit.response.LoginResponse;
import com.enummitanno.jwtauthpondit.service.CustomUserDetailsService;
import com.enummitanno.jwtauthpondit.service.JwtService;
import com.enummitanno.jwtauthpondit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    UserService userService;
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    JwtService jwtService;


    @GetMapping({"/loginPage", "loginPage"})
    public RequestBody loginPage(){

    }

    @PostMapping({ "/login", "login" })
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // load user by username
        customUserDetailsService.loadUserByUsername(loginRequest.getUsername());
        String token = jwtService.generateToken(loginRequest.getUsername());
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setStatus("success");
        loginResponse.setToken(token);

        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping({ "/register", "register" })
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        userService.createUser(registerRequest);
        return ResponseEntity.ok("success");
    }
}
