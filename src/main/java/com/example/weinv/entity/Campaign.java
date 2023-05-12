package com.example.weinv.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Campaign")
public class Campaign {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="camp_id")
	private int camp_id;
	
	@Column(name="pitch_id", insertable = false, updatable = false)
	private int pitch_id;
	
	@Column(name="start_date")
	private Date start_date;
	
	@Column(name="end_date")
	private Date end_date;
	
	@Column(name="min_raise")
	private long min_raise;
	
	@Column(name="max_raise")
	private long max_raise;
	
	@Column(name="is_active")
	private int is_active;
	
	@OneToOne
	@JoinColumn(name = "pitch_id")
	private Pitch pitch;
	
	
}
