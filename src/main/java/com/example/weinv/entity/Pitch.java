package com.example.weinv.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Pitch")
public class Pitch {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pitch_id;
	
	private String  pitch_title;
	
	private String pitch_desc;

	private int cmp_id;
	
	private String deck;
	
	private String feature_img;
	
	private String feature_vid;
    
	@ManyToOne(targetEntity = Company.class,fetch = FetchType.EAGER)
	@JoinColumn(name="cmp_id",insertable = false, updatable = false)
	@JsonBackReference
	private Company company;
	
}
