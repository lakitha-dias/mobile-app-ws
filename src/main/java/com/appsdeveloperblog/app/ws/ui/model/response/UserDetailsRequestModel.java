package com.appsdeveloperblog.app.ws.ui.model.response;

import javax.validation.constraints.NotNull;

public class UserDetailsRequestModel {
	
	@NotNull(message="Frst name cant be null")
	private String firstName;
	@NotNull(message="LastName name cant be null")
	private String lastName;
	@NotNull(message="email name cant be null")
	private String email;
	@NotNull(message="email name cant be null")
	private String userId;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
