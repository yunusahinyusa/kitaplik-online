package com.kitaplik.bookservice.dto.bookDto;


import com.kitaplik.bookservice.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookConverter {

    public BookDto convertToDto(Book book){
        return new BookDto(
                book.getTitle(),
                book.getBookYear(),
                book.getAuthor(),
                book.getPressName()
        );
    }

    public List<BookDto> listOfBookDto (List<Book> bookList){
        return bookList.stream()
                .map(this::convertToDto)
                .toList();
    }

}
