package com.enummitanno.jwtauthpondit.security;

import com.enummitanno.jwtauthpondit.model.User;
import com.enummitanno.jwtauthpondit.repository.UserRepository;
import com.enummitanno.jwtauthpondit.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            authHeader = authHeader.substring(7);
            String username = jwtService.extractUsername(authHeader);
            Optional<User> user = userRepository.findByUsername(username);
            if ( user.isPresent() ) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.get(), null, null);
                SecurityContextHolder
                  .getContext()
                  .setAuthentication(usernamePasswordAuthenticationToken);
            }
        }





        filterChain.doFilter(request, response);
    }
}
