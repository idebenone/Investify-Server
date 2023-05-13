package com.example.weinv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weinv.entity.Campaign;
import com.example.weinv.persistence.CampaignRepo;

import jakarta.transaction.Transactional;

@Service
public class CampaignService {
	
	@Autowired
	private CampaignRepo campaignRepo;
	
	@Transactional
	public List<Campaign> getAllCampaigns(){
		return campaignRepo.findAll();
	}
	
	@Transactional
	public Campaign getCampaignById(int id) {
		return campaignRepo.findById(id).get();
	}
	
	@Transactional
	public void addCampaign(Campaign cmp) {
		campaignRepo.save(cmp);
	}
	
	@Transactional
	public void updateCampaign(Campaign cmp) {
		campaignRepo.save(cmp);
	}
}
