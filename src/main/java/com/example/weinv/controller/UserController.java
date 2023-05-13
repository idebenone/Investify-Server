package com.example.weinv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.weinv.dto.AuthRequest;
import com.example.weinv.entity.Otp;
import com.example.weinv.entity.User;
import com.example.weinv.service.JwtService;
import com.example.weinv.service.UserService;

import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private JwtService jwtService;
		
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("test")
	public String test() {
		return "hello from backend";
	}
	
	@PostMapping("auth/initiate")
	public void initReg(@RequestBody String email) { // send email
		userServ.initiate_registration(email);
	}
	
	@PostMapping("auth/verify")
	public boolean verfyReg(@RequestBody Otp otp) { // send otp
		return userServ.verify_registration(otp.getOtp());
	}
	
	@PostMapping(value="auth/setpass",produces="application/json") //send password and email
	@ResponseBody
	public ResponseEntity<?> setPass(@RequestBody AuthRequest authRequest) {
		boolean res	= userServ.setUpPassword(authRequest.getEmail(),authRequest.getPassword());
		Map<String, Object> response = new HashMap<>();
		if(res) {
		 	Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
		 	if(authentication.isAuthenticated()) {
		 		String token = jwtService.genToken(authRequest.getEmail());		
		 		response.put("token", token);
		 		return ResponseEntity.ok(response);
		 	}else {
		 		throw new UsernameNotFoundException("Invalid User Request");
		 	}
		}
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value="/auth/login", produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest) {
	 	Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
	 	if(authentication.isAuthenticated()) {
	 		String token = jwtService.genToken(authRequest.getEmail());
	 		Map<String, Object> response = new HashMap<>();
	 		response.put("token", token);
	 		return ResponseEntity.ok(response);
	 	}else {
	 		throw new UsernameNotFoundException("Invalid User Request");
	 	}
	}
	
	@PostMapping("user/{id}")
	public User getUserById(@PathVariable int id) {
		return userServ.getUserByid(id);
	}
	
}
