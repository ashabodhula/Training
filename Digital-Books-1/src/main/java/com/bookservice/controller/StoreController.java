package com.bookservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookservice.model.BookStore;
import com.bookservice.service.StoreService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StoreController {

	@Autowired
	StoreService service;

	@GetMapping("/menu")
	Iterable<BookStore> getAllUsers() {
		return service.getAllStoreItems();
	}

	@PostMapping("/add/bookstore")
	String addMenu(@RequestBody BookStore bookstore) {
		service.addBookStore(bookstore);
		return "New  item was added.";
	}

	@PutMapping("/update/store/{Id}")
	String updateBookStore(@RequestBody BookStore bookstore) {
		service.updateBookStore(bookstore);
		return " Book store was updated";
	}

//reader can serach books with bookid in the store
	@PostMapping("/reader/byBookId/{bookId}")
	Iterable<BookStore> getstoreByBookId(@PathVariable int bookId) {
		return service.getstoreByBookId(bookId);
	}

}
