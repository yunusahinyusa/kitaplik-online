package com.kitaplik.library.service.exception;

public class LibraryNotFoundException extends RuntimeException {
    public LibraryNotFoundException(String s){
        super(s);
    }
}
