package com.example.weinv.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weinv.dto.CampaignPitchCompany;
import com.example.weinv.entity.Campaign;
import com.example.weinv.persistence.CampaignRepo;

import jakarta.transaction.Transactional;

@Service
public class CampaignService {
	
	@Autowired
	private CampaignRepo campaignRepo;
	
	@Transactional
	public List<CampaignPitchCompany> getAllPublicCamps(){
		List<Object[]> res = campaignRepo.publicCamps();
		List<CampaignPitchCompany> resList = new ArrayList<>();
		for(Object[] row : res) {
			CampaignPitchCompany cpc = new CampaignPitchCompany();
			cpc.setCampaignId((int) row[0]); cpc.setPitchId((int) row[1]); cpc.setCampaignTitle((String) row[2]);
			cpc.setMinRaise((long) row[3]); cpc.setMaxRaise((long) row[4]); cpc.setTargetRaise((long) row[5]);
			cpc.setStartDate((Timestamp) row[6]); cpc.setEndDate((Timestamp) row[7]); cpc.setIsRaisedAmt((long) row[8]);
			cpc.setPitchDescription((String) row[9]); cpc.setFeatureImage((String) row[10]); cpc.setFeatureVideo((String) row[11]);
			cpc.setDeck((String) row[12]); cpc.setCompanyId((int) row[13]); cpc.setCompanyName((String) row[14]);
			cpc.setProfileImage((String) row[15]); cpc.setPan((String) row[16]); cpc.setBio((String) row[17]);
			cpc.setAddress((String) row[18]); cpc.setCity((String) row[19]); cpc.setState((String) row[20]);
			cpc.setMediaLink1((String) row[21]); cpc.setMediaLink2((String) row[22]); cpc.setMediaLink3((String) row[23]);
			resList.add(cpc);
		}
		return resList;
	}
	
	@Transactional
	public List<Campaign> getAllCampaignsByCmpId(int id){
		return campaignRepo.findAllCampsByCmpId(id);
	}
	
	@Transactional
	public CampaignPitchCompany getCampaignById(int id) {
		List<Object[]> res = campaignRepo.findCampbyCmpId(id);
		CampaignPitchCompany cpc = new CampaignPitchCompany();
		for(Object [] row:res) {
			cpc.setCampaignId((int) row[0]); cpc.setPitchId((int) row[1]); cpc.setCampaignTitle((String) row[2]);
			cpc.setMinRaise((long) row[3]); cpc.setMaxRaise((long) row[4]); cpc.setTargetRaise((long) row[5]);
			cpc.setStartDate((Timestamp) row[6]); cpc.setEndDate((Timestamp) row[7]); cpc.setIsRaisedAmt((long) row[8]);
			cpc.setPitchDescription((String) row[9]); cpc.setFeatureImage((String) row[10]); cpc.setFeatureVideo((String) row[11]);
			cpc.setDeck((String) row[12]); cpc.setCompanyId((int) row[13]); cpc.setCompanyName((String) row[14]);
			cpc.setProfileImage((String) row[15]); cpc.setPan((String) row[16]); cpc.setBio((String) row[17]);
			cpc.setAddress((String) row[18]); cpc.setCity((String) row[19]); cpc.setState((String) row[20]);
			cpc.setMediaLink1((String) row[21]); cpc.setMediaLink2((String) row[22]); cpc.setMediaLink3((String) row[23]);
		}
		return cpc;
	}
	
	public Campaign getCmpCampById(int id) {
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
