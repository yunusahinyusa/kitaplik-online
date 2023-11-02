package com.kitaplik.library.service.dto;

import java.util.List;


public class LibraryDto{
    Long id;
    List<BookDto> userBookList;

    public LibraryDto(Long id, List<BookDto> userBookList) {
        this.id = id;
        this.userBookList = userBookList;
    }
}
