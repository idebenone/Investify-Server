package com.example.weinv.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weinv.dto.CampaignPitchCompany;
import com.example.weinv.dto.InvCamp;
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
	public List<InvCamp> getInvByUserId(int id){
		List<Object[]> res = investmentRepo.findByUserId(id);
		List<InvCamp> resList = new ArrayList<>();
		
		for(Object[] row:res) {
			InvCamp invCmp = new InvCamp();
			invCmp.setId((int)row[0]); invCmp.setTrans_id((String)row[1]);
			invCmp.setUser_id((int)row[2]);invCmp.setCamp_id((int)row[3]);
			invCmp.setAmount((float)row[4]);invCmp.setInv_date((Timestamp)row[5]);
			invCmp.setCmp_name((String)row[6]);invCmp.setCmp_id((int)row[7]);
			resList.add(invCmp);
		}
		return resList;
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
