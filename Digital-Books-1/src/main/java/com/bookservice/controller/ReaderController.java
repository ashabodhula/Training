package com.bookservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookservice.model.Reader;
import com.bookservice.service.ReaderService;

@RestController
@RequestMapping("/digitalbooks")
@CrossOrigin(origins = "*")
public class ReaderController {

	@Autowired
	ReaderService readerservice;

	
	
	@PostMapping("reader/signup")
	public String signUp(@RequestBody Reader reader) {
		return readerservice.signUp(reader);
	}

	@RequestMapping("reader/signin/{email}/{password}")
	public String signInWithEmail(@PathVariable String email, @PathVariable String password) {

		return readerservice.signIn(email, password);

	}

	@RequestMapping("/{id}")
	Optional<Reader> getDetailsByReaderId(@PathVariable Integer id) {
		return readerservice.getDetailsByReaderId(id);

	}

	@RequestMapping("/getByEmail/{email}")
	Optional<Reader> getReaderDetailsByEmail(@PathVariable String email) {

		return readerservice.getReaderDetailsByEmail(email);
	}

	@PostMapping("/save")
	String saveReader(@RequestBody Reader reader) {
		return readerservice.saveReader(reader);
	}
}
