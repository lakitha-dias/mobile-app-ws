package com.appsdeveloperblog.app.ws.ui.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.ui.model.response.UserREST;

@RequestMapping("/users")
@RestController
public class UserConroller {
	
	@GetMapping()
	public String getUsers(@RequestParam(value="page", required=false) int page, @RequestParam(value="limit", defaultValue="1", required=false) int limit) {
		return "getUsers was invoked page = "+page+" limit : "+limit;
	}
	
	
	@GetMapping(path="/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserREST getUser(@PathVariable String userId) {
		
		UserREST user = new UserREST();
		user.setFirstName("Lakitha");
		user.setLastName("Dias");
		user.setEmail("lakitha.dias@gmail.com");
		user.setUserId("lakitha.dias");
		
		return user;
	}
	
	@PostMapping
	public String createUser() {
		return "createUser was invoked";
	}
	
	@PutMapping
	public String putUser() {
		return "putUser was invoked";
	}
	
	
	@DeleteMapping
	public String deleteUser() {
		return "deleteUser was invoked";
	}
}
