package com.bookservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookservice.model.Author;
import com.bookservice.repository.AuthorRepository;



@Service
public class AuthorService  {

	@Autowired
	AuthorRepository repo;


	public String signUp(Author author) {
		if (getAuthorEmail(author.geteMail()) ){
			return "email exists";
		} else {

			repo.save(author);
			return "signup success";

		}
	}

	
	public boolean getAuthorEmail(String email) {
		// TODO Auto-generated method stub
		int e = repo.getAuthorByEmail(email);
		if (e >= 1) {
			return true;
		} else {
			return false;
		}
	}


	public String signIn(String email, String userPassword) {
		// TODO Auto-generated method stub
		return (repo.getAuthorByCred(email, userPassword) > 0 ? "Login Successful!" : "Login Failed!");
	}

	
	public String save(Author author) {
		return (repo.save(author) != null ? "User Sign-up Successfull !"
				: "Something went wrong while saving your data! Please try again...");

	}

	public Optional<Author> getDetailsByAuthorId(Integer id) {
		return repo.findById(id);
	}

	public Optional<Author> getAuthorDetailsByEmail(String email) {

		return repo.findByEmail(email);
	}

}
