package com.kitaplik.library.service.service;

import com.kitaplik.library.service.dto.LibraryDto;
import com.kitaplik.library.service.exception.LibraryNotFoundException;
import com.kitaplik.library.service.model.Library;
import com.kitaplik.library.service.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public LibraryDto getAllBooksInLibraryById(Long id){
        Library library = libraryRepository.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id : " + id));
        LibraryDto libraryDto = new LibraryDto(library.getId(),new ArrayList<>());
        return libraryDto;
    }

    public LibraryDto createLibrary(){
        Library newLibrary = libraryRepository.save(new Library());
        return new LibraryDto(newLibrary.getId(),new ArrayList<>());
    }
}
