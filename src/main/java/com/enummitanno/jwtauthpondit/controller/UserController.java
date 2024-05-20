package com.enummitanno.jwtauthpondit.controller;

import com.enummitanno.jwtauthpondit.model.User;
import com.enummitanno.jwtauthpondit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Add your controller methods here

    @GetMapping({"/", ""})
    public ResponseEntity<?> index() {
        List<User> userList = userService.findAllUser();
        return ResponseEntity.ok(new Object() {
            public final String status = "success";
            public final List<User> users = userList;
        });
    }

    @GetMapping({"/{id}", "{id}"})
    public ResponseEntity<?> show(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(new Object() {
            public final String status = "success";
        });
    }

    @PostMapping({"/create", "create"})
    public ResponseEntity<?> show() {

        return ResponseEntity.ok(new Object() {
            public final String status = "success";
        });
    }

    @PostMapping({"/update/{id}", "update/{id}"})
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(new Object() {
            public final String status = "success";
        });
    }

    @PostMapping({"/delete/{id}", "delete/{id}"})
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(new Object() {
            public final String status = "success";
        });
    }

}
