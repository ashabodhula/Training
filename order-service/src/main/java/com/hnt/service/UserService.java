package com.hnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.UserRepository;
import com.hnt.entity.User;

@Service
public class UserService {
@Autowired
UserRepository repository;
	public void save(User user) {
		// TODO Auto-generated method stub
		repository.save(user);
		
	}
	public Iterable<User> getUser() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	

	

	
}
