package com.appsdeveloperblog.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appsdeveloperblog.app.ws.shared.Utils;
import com.appsdeveloperblog.app.ws.ui.model.response.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserREST;
import com.appsdeveloperblog.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService {

	Map<String, UserREST> users;
	Utils utils;
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}
	
	@Override
	public UserREST createUser(UserDetailsRequestModel userDetails) {
		UserREST user = new UserREST();
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
		user.setUserId(userDetails.getUserId());
		
		//String userId = UUID.randomUUID().toString();
		String userId = utils.generateUserId();
				
		if(users == null) users = new HashMap<>();
		users.put(userDetails.getUserId(), user);
		
		return user;
	}
}
