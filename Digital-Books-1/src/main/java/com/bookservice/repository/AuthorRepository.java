package com.bookservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookservice.model.Author;


@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
	@Query(value="select count(*) from author where email = ?1 ", nativeQuery=true)
	int getAuthorByEmail(String email);
	
	@Query(value="select count(*) from author where email= ?1 and password= ?2", nativeQuery=true)
	int getAuthorByCred(String email, String password);

	Optional<Author> findById(Integer id);

	Optional<Author> findByEmail(String email);
}
