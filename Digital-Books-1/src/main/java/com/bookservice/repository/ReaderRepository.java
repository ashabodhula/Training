package com.bookservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookservice.model.Reader;

@Repository

public interface ReaderRepository extends CrudRepository<Reader, Integer>{
	@Query(value="select count(*) from reader where email = ?1 ", nativeQuery=true)
	int getReaderByEmail(String email);
	
	@Query(value="select count(*) from reader where email= ?1 and password= ?2", nativeQuery=true)
	int getReaderByCred(String email, String password);

	Optional<Reader> findById(Integer id);

	Optional<Reader> findByEmail(String email);

}
