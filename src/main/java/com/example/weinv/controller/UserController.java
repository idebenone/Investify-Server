package com.example.weinv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.weinv.dto.AuthRequest;
import com.example.weinv.entity.User;
import com.example.weinv.service.JwtService;
import com.example.weinv.service.UserService;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("api")
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
	
	@PostMapping("/auth/register")
	public String addUser(@RequestBody User user) {
		userServ.register(user);
		return "USER SAVED";
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
}
