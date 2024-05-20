package com.enummitanno.jwtauthpondit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.enummitanno.jwtauthpondit.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
