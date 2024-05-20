package com.enummitanno.jwtauthpondit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.enummitanno.jwtauthpondit.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
