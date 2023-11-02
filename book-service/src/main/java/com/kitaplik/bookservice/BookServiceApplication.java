package com.kitaplik.bookservice;

import com.kitaplik.bookservice.model.Book;
import com.kitaplik.bookservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BookServiceApplication implements CommandLineRunner {
	private final BookRepository bookRepository;

	public BookServiceApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Book book1 = new Book("1","Suç ve Ceza",1978,"Dostoyevski","12","123445");
//		Book book2 = new Book("2","Yüzüklerin Efendisi",1960,"JRR Tolkiem","13","1234412312");
//		Book book3 = new Book("3","Suç ve Ceza",1978,"Dostoyevski","12","123445");
//
//		List<Book> bookList = bookRepository.saveAll(Arrays.asList(book1,book2,book3));
//
//		System.out.println(bookList);
	}
}
