package com.example.weinv.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weinv.entity.Transactions;
import com.example.weinv.persistence.PaymentRepo;

import jakarta.transaction.Transactional;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepo  paymentRepo;
	
	@Transactional
	public List<Transactions> getTransByUserId(int id){
		return paymentRepo.findTransByUserId(id);
	}
	
	@Transactional
	public void addTrans(Transactions trans){
		LocalDateTime init = LocalDateTime.now();
		trans.setTrans_id(generateUniqueId());
		trans.setInit_time(Timestamp.valueOf(init));
		trans.setUpdate_time(Timestamp.valueOf(init));
		paymentRepo.save(trans);
	}
	
	@Transactional
	public void updateTrans(Transactions trans) {
		LocalDateTime update = LocalDateTime.now();
		trans.setUpdate_time(Timestamp.valueOf(update));
		paymentRepo.save(trans);
	}
	
	public static String generateUniqueId() {
        UUID uuid = UUID.randomUUID();
        String uniqueId = uuid.toString();
        return uniqueId;
    } 
	
}	
