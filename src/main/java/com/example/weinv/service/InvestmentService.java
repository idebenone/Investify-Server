package com.example.weinv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weinv.entity.Investment;
import com.example.weinv.persistence.InvestmentRepo;

import jakarta.transaction.Transactional;

@Service
public class InvestmentService {

	@Autowired
	private InvestmentRepo investmentRepo;
	
	@Transactional
	public List<Investment> getInvByCampId(int id){
		return investmentRepo.findByCampId(id);
	}
	
	@Transactional
	public List<Investment> getInvByUserId(int id){
		return investmentRepo.findByUserId(id);
	}
	
	@Transactional
	public void addInvestment(Investment inv) {
		investmentRepo.save(inv);
	}
	
	@Transactional
	public void updateInvestment(Investment inv) {
		investmentRepo.save(inv);
	}
}
