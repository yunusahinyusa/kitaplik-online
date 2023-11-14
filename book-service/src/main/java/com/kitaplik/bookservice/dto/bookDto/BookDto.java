package com.kitaplik.bookservice.dto.bookDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    private String id;
    private String title;
    private Integer bookYear;
    private String author;
    private String pressName;
    private String isbn;

}
