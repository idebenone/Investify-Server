package com.example.weinv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weinv.entity.Transactions;
import com.example.weinv.service.PaymentService;

@RestController
@RequestMapping("api/payment")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	
	@PostMapping("trans")
	public void initTrans(@RequestBody Transactions trans) {
		paymentService.addTrans(trans);
	}
	
	@PutMapping("trans")
	public void updateTrans(@RequestBody Transactions trans) {
		paymentService.updateTrans(trans);
	}
	
}
