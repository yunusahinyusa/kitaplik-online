package com.kitaplik.library.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class LibraryDto{
    String id;
    List<BookDto> userBookList;

    public LibraryDto(String id, List<BookDto> userBookList) {
        this.id = id;
        this.userBookList = userBookList;
    }
}
