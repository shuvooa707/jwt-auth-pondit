package com.enummitanno.jwtauthpondit.service;

import com.enummitanno.jwtauthpondit.model.Book;
import com.enummitanno.jwtauthpondit.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    // Add your service methods here

}
