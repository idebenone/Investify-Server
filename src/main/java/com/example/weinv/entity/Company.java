package com.example.weinv.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cmp_id")
	private int cmp_id;
	
	@Column(name="cmp_name")
	private String cmp_name;
	
	@Column(name="prf_img")
	private String prf_img;
	
	@Column(name="pan")
	private String pan;
	
	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="bio")
	private String bio;
	
	@Column(name="media_link1")
	private String media_link1;
	
	@Column(name="media_link2")
	private String media_link2;
	
	@Column(name="media_link3")
	private String media_link3;
	
	@OneToMany(mappedBy="company")
	private Set<Pitch> pitch;
}
