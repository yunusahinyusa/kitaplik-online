package com.kitaplik.library.service.service;

import com.kitaplik.library.service.client.BookServiceClient;
import com.kitaplik.library.service.dto.AddBookRequest;
import com.kitaplik.library.service.dto.BookDto;
import com.kitaplik.library.service.dto.BookIdDto;
import com.kitaplik.library.service.dto.LibraryDto;
import com.kitaplik.library.service.exception.LibraryNotFoundException;
import com.kitaplik.library.service.model.Library;
import com.kitaplik.library.service.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }

    public LibraryDto getAllBooksInLibraryById(String id) {
       Library library = libraryRepository.findById(id)
               .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + id));

        LibraryDto libraryDto = new LibraryDto(library.getId(),
                library.getUserBook()
                        .stream()
                        .map(book -> bookServiceClient.getBookById(book).getBody())
                        .collect(Collectors.toList()));
        return libraryDto;
    }

    public LibraryDto createLibrary(){
        Library newLibrary = libraryRepository.save(new Library());
        return new LibraryDto(newLibrary.getId(),new ArrayList<>());
    }

    public void addBookToLibrary(AddBookRequest request){
        Library library = libraryRepository.findById(request.getId())
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + request.getId()));

        BookIdDto bookDto2 = bookServiceClient.getBookByIsbnNumber(request.getIsbn());
//        String bookId = bookServiceClient.getBookById(bookDto2.getId()).getBody().getBookId();
//        String bookId = bookServiceClient.getBookById(request.getIsbn()).getBody().getBookId();


        library.getUserBook()
                .add(bookDto2.getId());

        libraryRepository.save(library);
    }
}
