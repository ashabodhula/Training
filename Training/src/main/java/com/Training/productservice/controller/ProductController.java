package com.Training.productservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Training.productservice.dto.ProductRequest;

@RestController
@RequestMapping("/product")
public class ProductController {

	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductRequest productRequest){
		
		
		
	}
}
