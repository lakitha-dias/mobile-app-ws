package com.appsdeveloperblog.app.ws.userservice;

import com.appsdeveloperblog.app.ws.ui.model.response.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserREST;

public interface UserService {
	UserREST createUser(UserDetailsRequestModel userDetails);
}
