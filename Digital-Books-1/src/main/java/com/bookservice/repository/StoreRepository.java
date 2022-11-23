package com.bookservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookservice.model.BookStore;

public interface StoreRepository extends CrudRepository<BookStore, Integer> {

	Iterable<BookStore> findByBookBookId(int bookId);

}
