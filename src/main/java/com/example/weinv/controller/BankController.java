package com.example.weinv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weinv.entity.Bank;
import com.example.weinv.service.BankService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class BankController {
	
	@Autowired
	private BankService bankService;
	
	@PostMapping("bank")
	public boolean checkBankCred(@RequestBody Bank bank) {
		return bankService.checkBankCred(bank);
	}
}
