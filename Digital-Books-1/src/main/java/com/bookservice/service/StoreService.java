package com.bookservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookservice.model.BookStore;
import com.bookservice.repository.StoreRepository;

@Service
public class StoreService {
	@Autowired
	StoreRepository storerepo;

	public Iterable<BookStore> getAllStoreItems() {
		// TODO Auto-generated method stub
		return storerepo.findAll();

	}

	public void addBookStore(BookStore bookstore) {
		// TODO Auto-generated method stub
		storerepo.save(bookstore);
	}

	public void updateBookStore(BookStore bookstore) {
		// TODO Auto-generated method stub
		storerepo.save(bookstore);

	}

	public Iterable<BookStore> getstoreByBookId(int bookId) {
		// TODO Auto-generated method stub
		return storerepo.findByBookBookId(bookId);
	}

}
