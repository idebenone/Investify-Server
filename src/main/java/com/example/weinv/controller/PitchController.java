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

import com.example.weinv.entity.Pitch;
import com.example.weinv.service.PitchService;

@RestController
@RequestMapping("api/comp")
@CrossOrigin(origins = "http://localhost:4200")
public class PitchController {
	
	@Autowired
	private PitchService pitchService;

	@GetMapping("pitch")
	public List<Pitch> getAllPitch(){
		return pitchService.getAllPitches();
	}
	
	@GetMapping("pitch/{id}")
	public Pitch getPitchById(@PathVariable int id) {
		return pitchService.getPitchById(id);
	}
	
	@PostMapping("pitch")
	public void addPitch(@RequestBody Pitch p) {
		pitchService.addPitch(p);
	}
	
	@PutMapping("pitch")
	public void updatePitch(@RequestBody Pitch p) {
		pitchService.updatePitch(p);
	}
	
	
}
