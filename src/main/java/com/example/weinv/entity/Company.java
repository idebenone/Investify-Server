package com.example.weinv.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Company")
public class Company {
	
	@Id
	private int cmp_id;
	
	private String cmp_name;
	
	private String prf_img;
	
	private String pan;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String bio;
	
	private String media_link1;
	
	private String media_link2;

	private String media_link3;
	
	@OneToMany(mappedBy="company", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Pitch> pitch;
}
