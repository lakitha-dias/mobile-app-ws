package com.appsdeveloperblog.app.ws.ui.model.response;

import javax.validation.constraints.NotNull;

public class UpdateUserDetailsRequestModel {
	
	@NotNull(message="Frst name cant be null")
	private String firstName;
	@NotNull(message="LastName name cant be null")
	private String lastName;

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
	
}
