package com.kitaplik.library.service.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddBookRequest {
    String id;
    String isbn;
}
