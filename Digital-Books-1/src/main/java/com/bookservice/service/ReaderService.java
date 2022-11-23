package com.bookservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookservice.model.Reader;
import com.bookservice.repository.ReaderRepository;

@Service

public class ReaderService {

	@Autowired
	ReaderRepository repo;

	public Optional<Reader> getReaderDetailsByEmail(String email) {

		return repo.findByEmail(email);
	}

	public String signUp(Reader reader) {
		// TODO Auto-generated method stub

		if (getReaderEmail(reader.geteMail())) {
			return "email exists";
		} else {

			repo.save(reader);

			return "signup Success";
		}

	}

	public boolean getReaderEmail(String email) {
		// TODO Auto-generated method stub
		int e = repo.getReaderByEmail(email);
		if (e >= 1) {
			return true;
		} else {
			return false;
		}
	}

	public String signIn(String email, String password) {
		// TODO Auto-generated method stub
		return (repo.getReaderByCred(email, password) > 0 ? "Login Successful!" : "Login Failed!");
	}

	public String saveReader(Reader reader) {
		// TODO Auto-generated method stub
		return (repo.save(reader) != null ? "User Sign-up Successfull !"
				: "Something went wrong while saving your data! Please try again...");
	}

	public Optional<Reader> getDetailsByReaderId(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

}
