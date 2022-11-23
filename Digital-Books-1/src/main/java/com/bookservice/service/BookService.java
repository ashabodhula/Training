package com.bookservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookservice.model.Book;
import com.bookservice.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookrepo;

	public Iterable<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookrepo.findAll();

	}

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		bookrepo.save(book);

	}

	public Optional<Book> getBookById(int bookId) {
		// TODO Auto-generated method stub
		return bookrepo.findById(bookId);
	}

	public void updateBook(Book book) {
		// TODO Auto-generated method stub

		bookrepo.save(book);
	}

	public void removeBook(int bookId) {
		// TODO Auto-generated method stub
		bookrepo.deleteById(bookId);

	}

	public Optional<Book> searchById(int bookId) {
		// TODO Auto-generated method stub

		return bookrepo.findById(bookId);
	}

}
