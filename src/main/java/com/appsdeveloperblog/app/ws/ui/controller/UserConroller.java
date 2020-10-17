package com.appsdeveloperblog.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.exceptions.UserServiceException;
import com.appsdeveloperblog.app.ws.ui.model.response.UpdateUserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserREST;
import com.appsdeveloperblog.app.ws.userservice.UserService;

@RequestMapping("/users")
@RestController
public class UserConroller {
	
	Map<String, UserREST> users;
	
	@Autowired
	UserService userService;
	
	@GetMapping()
	public String getUsers(@RequestParam(value="page", required=false) int page, @RequestParam(value="limit", defaultValue="1", required=false) int limit) {
		return "getUsers was invoked page = "+page+" limit : "+limit;
	}
	
	
	@GetMapping(path="/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserREST> getUser(@PathVariable String userId) {
		

		/*
		 * if(true) throw new UserServiceException("A user service exception thrown.");
		 */

		
		if(users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
							,produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserREST> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		
		// Dependency injection enables us to mock and test services separately
		UserREST returnValue = userService.createUser(userDetails);
		
		return new ResponseEntity<UserREST>(returnValue,HttpStatus.OK);
	}
	
	@PutMapping(path="/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserREST updateUser(@PathVariable String userId,@Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
		UserREST user = users.get(userId);
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		
		users.put(userId, user);
		return user;
	}
	
	
	@DeleteMapping(path="/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		users.remove(userId);
		return ResponseEntity.noContent().build();
	}
}
