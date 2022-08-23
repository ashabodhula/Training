package com.hnt.controller;

import java.util.HashMap;
import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hnt.entity.User;
import com.hnt.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // to spring beans
@RequestMapping ("/user")
public class UserController {
	@Autowired

	UserService userService;

	@GetMapping
     Iterable<User> getUser(){
    	 return userService.getUser();
     }
	
	
	@PostMapping("age/{age}/height/{height}")// it is basepath
	void saveUser(@Valid @RequestBody User user, @PathVariable ("age") int age , @PathVariable("height") float height) {
		userService.save(user);
		//Log.debug(user.getName()); getting error with log for timebeing commented it 
		System.out.println(height);
		System.out.println(age);
		
		
	}
	
	@PostMapping
	void saveUser1(@Valid @RequestBody User user) {
		userService.save(user);
		//Log.debug(user.getNmae());
		
		System.out.println("second");
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	Map <String , String> handleException(MethodArgumentNotValidException ex){
		Map<String , String> errors = new HashMap();
		ex.getBindingResult().getAllErrors().forEach((error )->{
			String fieldName=((FieldError) error).getField();
			String message =((FieldError)error).getDefaultMessage();
					errors.put(fieldName, message);
		});
		return errors;
	}
	
}
