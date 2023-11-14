package com.kitaplik.bookservice.service;

import com.kitaplik.bookservice.dto.bookDto.BookConverter;
import com.kitaplik.bookservice.dto.bookDto.BookDto;
import com.kitaplik.bookservice.dto.bookDto.BookIdDto;
import com.kitaplik.bookservice.exception.BookNotFoundException;
import com.kitaplik.bookservice.model.Book;
import com.kitaplik.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    private final BookRepository bookRepository;

    private final BookConverter bookConverter;


    public BookService(BookRepository bookRepository, BookConverter bookConverter) {
        this.bookRepository = bookRepository;
        this.bookConverter = bookConverter;
    }

    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = bookConverter.listOfBookDto(books);
        return bookDtos;
    }

    public BookIdDto findByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn)
                .map(book -> new BookIdDto(book.getId(), book.getIsbn()))
                .orElseThrow(() -> new BookNotFoundException("Book could not found by isbn: " + isbn));
    }

    public BookDto findBookDetailsById(String id) {
        return bookRepository.findById(id)
                .map(book -> new BookDto(book.getId(),book.getTitle(), book.getBookYear(), book.getAuthor(), book.getPressName(), book.getIsbn()))
                .orElseThrow(() -> new BookNotFoundException("Book could not found by id" + id));
    }

    public void saveBook(BookDto bookDto){
        UUID uuid = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();
        Book book1 = new Book(bookDto.getTitle(),bookDto.getBookYear(),bookDto.getAuthor(),bookDto.getPressName(),uuid2.toString());
        bookRepository.save(book1);
    }

}
