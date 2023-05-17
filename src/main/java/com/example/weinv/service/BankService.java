package com.example.weinv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weinv.entity.Bank;
import com.example.weinv.persistence.BankRepo;

import jakarta.transaction.Transactional;

@Service
public class BankService {
	
	@Autowired
	private BankRepo bankRepo;

	@Transactional
	public boolean checkBankCred(Bank bank) {
		Bank get_bank = bankRepo.getBankDet(bank.getCard_number());
		if(bank.getHolder_name().equals(get_bank.getHolder_name()) && bank.getExp_date().equals(get_bank.getExp_date())
				&& bank.getCvv() == get_bank.getCvv()) {
			return true;
		}
		return false;
	}
}
