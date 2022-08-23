package com.hnt;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {

	public static final String URL="http://localhost:8080/user";
	public static void main(String [] args)
	{
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
		System.out.println(response.getStatusCodeValue());
		System.out.println(response.getBody());
		
	}
}

