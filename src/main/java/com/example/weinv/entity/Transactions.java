package com.example.weinv.entity;

import java.sql.Timestamp;

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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Transactions")
public class Transactions {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int user_id;
	
	private String trans_id;

	private int camp_id;
	
	private float amount;
	
	private Timestamp init_time;
	
	private Timestamp update_time;
	
	@Builder.Default
	private int is_confirmed = 0;
}
