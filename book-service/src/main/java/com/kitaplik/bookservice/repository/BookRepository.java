package com.kitaplik.bookservice.repository;

import com.kitaplik.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findBookByIsbn(String isbn);
}
