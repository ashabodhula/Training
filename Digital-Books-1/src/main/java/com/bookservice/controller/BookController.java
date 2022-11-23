package com.bookservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookservice.model.Book;
import com.bookservice.service.BookService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController {

	@Autowired

	BookService bookservice;

	@GetMapping("/books")
	Iterable<Book> getAllBooks() {
		return bookservice.getAllBooks();
	}

	@PostMapping("/add/book")
	String addBook(@RequestBody Book book) {
		bookservice.addBook(book);
		return (book.getTitle()) + " was added successfully.";
	}

	@GetMapping("/bookById/{bookId}")
	Optional<Book> getBookById(@PathVariable int bookId) {
		return bookservice.getBookById(bookId);
	}

	@PostMapping("/update/book")
	String updateBook(@RequestBody Book book) {
		bookservice.updateBook(book);
		return book.getTitle() + " was updated.";
	}

	@GetMapping("/remove/book/{bookId}")
	String removeBook(@PathVariable int bookId) {
		bookservice.removeBook(bookId);
		return "Book with ID " + bookId + " was removed.";
	}

	@GetMapping("/book/getById/{bookId}")
 Optional<Book> searchById(@PathVariable int bookId) {
		return bookservice.searchById(bookId);
	}

}
