package com.example.weinv.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.weinv.entity.Campaign;

public interface CampaignRepo extends JpaRepository<Campaign,Integer>{

}
