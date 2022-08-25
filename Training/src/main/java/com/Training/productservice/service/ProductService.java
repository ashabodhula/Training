package com.Training.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Training.productservice.dto.ProductRequest;
import com.Training.productservice.model.Product;
import com.Training.productservice.repository.ProductRepository;


@Service


public class ProductService {	
	@Autowired
	ProductRepository productRepository;
	public void createProduct(ProductRequest productRequest) {
		
		//productRepository.save(productRequest);
		
		/*	Product product = Product.builder()
		.title(productRequest.getTitle())
		.author(productRequest.getAuthor())
		.price(productRequest.getPrice())
		.catergory(productRequest.getCategory())
		.build();
*/
		
	}

}
