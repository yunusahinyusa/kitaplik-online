package com.kitaplik.library.service.client;

import com.kitaplik.library.service.dto.BookDto;
import com.kitaplik.library.service.dto.BookIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-service", path = "/v1/book")
public interface BookServiceClient {

    @GetMapping("/isbn/{isbn}")
    ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable String isbn);

    @GetMapping("/book/{id}")
    ResponseEntity<BookDto> getBookById(@PathVariable String id);

    @GetMapping("/booksave/{isbn}")
    BookIdDto getBookByIsbnNumber(@PathVariable String isbn);

}
