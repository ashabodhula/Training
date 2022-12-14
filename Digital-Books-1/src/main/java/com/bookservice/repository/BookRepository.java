package com.bookservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookservice.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

	
}
