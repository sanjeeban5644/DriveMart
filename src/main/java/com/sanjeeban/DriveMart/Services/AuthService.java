package com.sanjeeban.DriveMart.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.sanjeeban.DriveMart.Entity.User;
import com.sanjeeban.DriveMart.ModelDTO.LoginRequest;
import com.sanjeeban.DriveMart.ModelDTO.LoginResponse;
import com.sanjeeban.DriveMart.Repository.UserRepository;

@Component
public class AuthService {
	
	 @Autowired
	 private UserRepository userRepository;
	
	
	public LoginResponse loginService(@RequestBody LoginRequest request){
		
		LoginResponse response = new LoginResponse();
		
		if(request.getUsername() == null || request.getPassword()==null) {
			response.setResponseCode("400");
			response.setResponseMsg("Please Enter values");
			response.setRole("NA");
			return response;
		}
		
		User user = userRepository.findByUsername(request.getUsername());
		
		if(user==null) {
			response.setResponseCode("404");
			response.setResponseMsg("Invalid User");
			response.setRole("NA");
			return response;
		}
		
		response.setResponseCode("200");
		response.setResponseMsg("Access Granted");
		response.setRole(user.getRole());
		return response;
	}
	
	
	
	
}
