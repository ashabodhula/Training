package com.hnt.controller;

import java.util.HashMap;
import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hnt.entity.User;
import com.hnt.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin()
@RestController // to spring beans
@RequestMapping("/user")
public class UserController {
	@Autowired // DI
	UserService userService; 

	@GetMapping
	Iterable<User> getUser() {
		return userService.getUser();
	}

	@PostMapping("/age/{age}/height/{height}") // base path
	@ResponseStatus(code = HttpStatus.CREATED)
	ResponseEntity saveUser(@Valid @RequestBody User user, @PathVariable("age") int age, @PathVariable("height") float height) {
		userService.save(user);
		System.out.println(height);
		System.out.println(age);
		
		MultiValueMap headers = new LinkedMultiValueMap<String, String>();
		headers.add("headerfromserver", "success");
		ResponseEntity responseEntity = new ResponseEntity(headers , HttpStatus.CREATED);
		return responseEntity;
	}

	@PostMapping
	Integer saveUser1(@Valid @RequestBody User user) {
		userService.save(user);  
		System.out.println("second");
		return user.getId();
	}
	/*
	@ExceptionHandler(MethodArgumentNotValidException.class)
	Map<String, String> handleException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = ((FieldError) error).getDefaultMessage();
			errors.put(fieldName, message);
		});
		return errors;
	}*/

}
