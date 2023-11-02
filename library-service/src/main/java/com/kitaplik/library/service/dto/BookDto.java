package com.kitaplik.library.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    private String title;
    private Integer year;
    private String author;
    private String pressName;
//    private String isbn;

}