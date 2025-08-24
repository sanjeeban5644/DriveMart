package com.sanjeeban.DriveMart.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanjeeban.DriveMart.Entity.User;
import com.sanjeeban.DriveMart.ModelDTO.LoginRequest;
import com.sanjeeban.DriveMart.ModelDTO.LoginResponse;
import com.sanjeeban.DriveMart.Repository.UserRepository;
import com.sanjeeban.DriveMart.Services.AuthService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class AuthController {

   
    
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request, HttpSession session) {
    	
    	LoginResponse response = new LoginResponse();
    	response =  authService.loginService(request);
    	
        session.setAttribute("role", response.getRole());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<LoginResponse> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok(new LoginResponse("00", "Logged out successfully",null));
    }
}
