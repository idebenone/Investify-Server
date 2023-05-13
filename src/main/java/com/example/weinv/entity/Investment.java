package com.example.weinv.entity;

import java.util.Date;



import jakarta.persistence.Column;
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
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="trans_id")
	private long trans_id;
	
	@Column(name="camp_id")
	private int camp_id;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="inv_date")
	private Date inv_date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="camp_id",insertable = false,updatable=false)
	private Campaign campaign;
}
