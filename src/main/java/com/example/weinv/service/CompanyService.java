package com.example.weinv.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weinv.entity.Company;
import com.example.weinv.persistence.CompanyRepo;

import jakarta.transaction.Transactional;


@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepo companyRepo;
	
	@Transactional
	public Company findCmp(int id) {
		return companyRepo.getCmpById(id);
	}
	
	@Transactional
	public void createCmp(Company cmp) {
		companyRepo.save(cmp);
	}
	
	@Transactional
	public void editCmp(Company cmp) {
		companyRepo.editCmp(cmp.getCmp_name(),
				cmp.getPrf_img(), 
				cmp.getPan(), 
				cmp.getAddress(),
				cmp.getCity(), 
				cmp.getState(), 
				cmp.getBio(),
				cmp.getMedia_link1(),
				cmp.getMedia_link2(), 
				cmp.getMedia_link3(), 
				cmp.getCmp_id());
	}
	
	@Transactional
	public void deleteCmp(int id) {
		companyRepo.deleteById(id);
	}
	
}
