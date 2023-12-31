package com.kitaplik.library.service.controller;

import com.kitaplik.library.service.dto.AddBookRequest;
import com.kitaplik.library.service.dto.LibraryDto;
import com.kitaplik.library.service.service.LibraryService;
import feign.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/library")
public class LibraryController {

    private final LibraryService libraryService;


    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable String id){
        return ResponseEntity.ok(libraryService.getAllBooksInLibraryById(id));
    }

    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary(){
        return ResponseEntity.ok(libraryService.createLibrary());
    }

//    @PostMapping
//    public ResponseEntity<?> createLibrary(@RequestBody LibraryDto libraryDto){
//       libraryService.saveLibrary(libraryDto);
//    }


    @PutMapping
    public ResponseEntity<Void> addBookToLibrary(@RequestBody AddBookRequest request){
        libraryService.addBookToLibrary(request);
        return ResponseEntity.ok().build();
    }


}
