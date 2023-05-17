package com.example.weinv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weinv.dto.CampaignPitchCompany;
import com.example.weinv.entity.Campaign;
import com.example.weinv.entity.Investment;
import com.example.weinv.service.CampaignService;
import com.example.weinv.service.InvestmentService;

@RestController
@RequestMapping("api/comp")
@CrossOrigin(origins = "http://localhost:4200")
public class CampaignController {
	
	@Autowired
	private CampaignService campaignService;
	
	@Autowired
	private InvestmentService investmentService;

	@GetMapping("campaign")
	public List<CampaignPitchCompany> publicCamps(){
		return campaignService.getAllPublicCamps();
	}
	
	@GetMapping("campaign/cmp={id}")
	public List<Campaign> getAllCampsByCmpId(@PathVariable int id){
		return campaignService.getAllCampaignsByCmpId(id);
	}
	
	@GetMapping("campaign/cmp/{id}")
	public Campaign getCmpCampById(@PathVariable int id) {
		return campaignService.getCmpCampById(id);
	}
	
	@GetMapping("campaign/{id}")
	public CampaignPitchCompany getCampById(@PathVariable int id) {
		return campaignService.getCampaignById(id);
	}
	
	@PostMapping("campaign")
	public void addCampaign(@RequestBody Campaign cmp) {
		campaignService.addCampaign(cmp);
	}
	
	@PutMapping("campaign")
	public void updateCampaign(@RequestBody Campaign cmp) {
		campaignService.updateCampaign(cmp);
	}
	
	@GetMapping("campaign/inv/{id}")
	public List<Investment> getInvByCampId(@PathVariable int id){
		return investmentService.getInvByCampId(id);
	}
	
	
}
