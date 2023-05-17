package com.example.weinv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String full_name;
	
	private String email;

	private String password;
	
	private long phone;
	
	private String bio;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	@Builder.Default
	private String role = "User";
	
	@Builder.Default
	private int verified = 0;
	
	@Builder.Default
	private int is_active = 0;
}
