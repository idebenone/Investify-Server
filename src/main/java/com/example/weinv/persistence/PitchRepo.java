package com.example.weinv.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.weinv.entity.Pitch;

public interface PitchRepo extends JpaRepository<Pitch,Integer>{
	
}
