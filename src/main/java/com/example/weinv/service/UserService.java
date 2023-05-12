package com.example.weinv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.weinv.entity.User;
import com.example.weinv.persistence.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passEnc;

	public void register(User user) {
		user.setPassword(passEnc.encode(user.getPassword()));
		userRepo.save(user);
	}
}
