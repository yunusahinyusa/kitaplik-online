package com.kitaplik.bookservice.dto.bookDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookIdDto {
    private String id;
    private String isbn;
}
