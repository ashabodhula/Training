package com.bookservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookservice.model.Author;
import com.bookservice.service.AuthorService;

@RestController
@RequestMapping("/digitalbooks")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class AuthorController {

	@Autowired
	AuthorService authorService;

	@PostMapping("/author/signup")
	public String signUp(@RequestBody Author author) {
		return authorService.signUp(author);
	}

	@PostMapping("author/signin/{email}/{password}")
	public String signInWithEmail(@PathVariable String email, @PathVariable String password) {

		return authorService.signIn(email, password);

	}

	@PostMapping("/{id}")
	Optional<Author> getDetailsByAuthorId(@PathVariable Integer id) {
		return authorService.getDetailsByAuthorId(id);
	}

	@RequestMapping("/getByEmail/{email}")
	Optional<Author> getUserDetailsByEmail(@PathVariable String email) {

		return authorService.getAuthorDetailsByEmail(email);
	}

	@PostMapping("/save")
	String saveAuthor(@RequestBody Author author) {
		return authorService.save(author);
	}

}
