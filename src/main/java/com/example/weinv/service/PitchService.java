package com.example.weinv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weinv.entity.Pitch;
import com.example.weinv.persistence.PitchRepo;

import jakarta.transaction.Transactional;

@Service
public class PitchService {
	
	@Autowired
	private PitchRepo pitchRepo;
	
	@Transactional
	public List<Pitch> getAllPitches(){
		return pitchRepo.findAll();
	}
	
	@Transactional
	public Pitch getPitchById(int id) {
		return pitchRepo.findById(id).get();
	}
	
	@Transactional
	public void addPitch(Pitch p) {
		pitchRepo.save(p);
	}
	
	@Transactional
	public void updatePitch(Pitch p) {
		pitchRepo.save(p);
	}
}
