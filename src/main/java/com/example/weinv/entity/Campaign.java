package com.example.weinv.entity;

import java.sql.Timestamp;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	private int camp_id;
	
	private int pitch_id;
	
	private Timestamp start_date;
	
	private Timestamp end_date;
	
	private long min_raise;
	
	private long max_raise;
	
	private long target_raise;
	
	private int is_active;
	
	@OneToOne
	@JoinColumn(name = "pitch_id", insertable = false, updatable = false)
	private Pitch pitch;
	
	@OneToMany(mappedBy="campaign")
	private Set<Investment> investment;
	
	
}
