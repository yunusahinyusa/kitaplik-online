package com.kitaplik.library.service.exception;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String s){
        super(s);
    }
}
