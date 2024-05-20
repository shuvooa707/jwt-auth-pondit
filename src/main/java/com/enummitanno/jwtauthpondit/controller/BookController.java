package com.enummitanno.jwtauthpondit.controller;

import com.enummitanno.jwtauthpondit.model.Book;
import com.enummitanno.jwtauthpondit.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/Book")
public class BookController {

    @Autowired
    BookService bookService;

    // Add your controller methods here

    @GetMapping({"/", ""})
    public ResponseEntity<?> index() {

        List<Book> bookList = bookService.allBooks();

        return ResponseEntity.ok(new Object() {
            public final String status = "success";
            public final List<Book> books = bookList;
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
