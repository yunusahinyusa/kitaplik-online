package com.kitaplik.bookservice.controller;

import com.kitaplik.bookservice.dto.bookDto.BookDto;
import com.kitaplik.bookservice.dto.bookDto.BookIdDto;
import com.kitaplik.bookservice.model.Book;
import com.kitaplik.bookservice.service.BookService;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
@Validated
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveBook(@RequestBody BookDto bookDto){
        bookService.saveBook(bookDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBook(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable @NotEmpty String isbn){
        return ResponseEntity.ok(bookService.findByIsbn(isbn));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable @NotEmpty String id){
        return ResponseEntity.ok(bookService.findBookDetailsById(id));
    }

    @GetMapping("/booksave/{isbn}")
    public BookIdDto getBookByIsbnNumber(@PathVariable String isbn){
        return bookService.findByIsbn(isbn);
    }



}
