package com.digitalbooks.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.digitalbooks.model.Book;

public interface BookRepository extends MongoRepository<Book ,String>{
	

}
