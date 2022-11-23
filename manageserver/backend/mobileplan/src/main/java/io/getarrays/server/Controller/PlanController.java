package io.getarrays.server.Controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.*;
import io.getarrays.server.enumeration.Status;
import io.getarrays.server.model.Plan;
import io.getarrays.server.model.Response;
import io.getarrays.server.service.implementation.*;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor  //di

public class PlanController {
	
	private final planserviceimpl planserviceimpl;
	 
	@GetMapping("/list")
	public ResponseEntity<Response> getPlans(){
		return ResponseEntity.ok(
				Response.builder()
				.timestamp(LocalDateTime.now()).data(Map.of("server",planserviceimpl.list(30)))
				.message("plans retrived")
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
			    .build()
				);
				
	}

	
	@GetMapping("/ping/{ipAddress}")
	public ResponseEntity<Response> pingServers(@PathVariable ("ipAddress") String ipAddress) throws IOException{
		
		Plan plan = planserviceimpl.ping(ipAddress);
		
		
		return ResponseEntity.ok(
				Response.builder()
				.timestamp(LocalDateTime.now()).data(Map.of("server",plan))
				.message(plan.getStatus()==Status.PLAN_ACTIVE? "Ping Success":"Ping failed")
				.status(HttpStatus.OK)
				.statusCode(HttpStatus.OK.value())
			    .build()
				);
				
	}
	
	@PostMapping("/save")
	public ResponseEntity<Response> savePlan(@RequestBody @Valid Plan plan){
		
		return ResponseEntity.ok(
				Response.builder()
				.timestamp(LocalDateTime.now()).data(Map.of("server",planserviceimpl.Create(plan)))
				.message("plan created")
				.status(HttpStatus.CREATED)
				.statusCode(HttpStatus.CREATED.value())
			    .build()
				);
				
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getPlan(@PathVariable("id") Long id){
		
		return ResponseEntity.ok(
				Response.builder()
				.timestamp(LocalDateTime.now())
				.data(Map.of("server",planserviceimpl.get(id)))
				.message("plans retrived by planid")
				.status(HttpStatus.CREATED)
				.statusCode(HttpStatus.CREATED.value())
			    .build()
				);
				
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deletePlan(@PathVariable("id") Long id){
		
		return ResponseEntity.ok(
				Response.builder()
				.timestamp(LocalDateTime.now())
				.data(Map.of("deleted",planserviceimpl.delete(id)))
				.message("plan deleted")
				.status(HttpStatus.CREATED)
				.statusCode(HttpStatus.CREATED.value())
			    .build()
				);
				
	}
	
	@GetMapping(path="/image/{fileName}",produces= MediaType.IMAGE_PNG_VALUE)
	public byte[] getPlanImage(@PathVariable("fileName") String fileName) throws IOException{
		
		return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Downloads/images/"+fileName));
				
	}
}
