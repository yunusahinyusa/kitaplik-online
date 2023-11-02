package com.kitaplik.bookservice.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "book_year")
    private Integer bookYear;

    @Column(name = "author")
    private String author;

    @Column(name = "press_name")
    private String pressName;

    @Column(name = "isbn")
    private String isbn;

    public Book(String title, Integer bookYear, String author, String pressName, String isbn) {
        this.title = title;
        this.bookYear = bookYear;
        this.author = author;
        this.pressName = pressName;
        this.isbn = isbn;
    }
}
