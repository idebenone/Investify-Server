package com.example.weinv.entity;


import java.sql.Timestamp;

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
@Table(name="Investment")
public class Investment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int user_id;

	private String trans_id;
	
	private int camp_id;
	
	private float amount;
	
	private Timestamp inv_date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="camp_id",insertable = false,updatable=false)
	private Campaign campaign;
}
