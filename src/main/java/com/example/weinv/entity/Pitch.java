package com.example.weinv.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
	@Column(name="pitch_id")
	private int pitch_id;
	
	@Column(name="cmp_id")
	private int cmp_id;
	
	@Column(name="deck")
	private String deck;
	
	@Column(name="feature_img")
	private String feature_img;
	
	@Column(name="feature_vid")
	private String feature_vid;
	
    @OneToOne(mappedBy = "pitch", cascade = CascadeType.ALL)
    private Campaign campaign;
	
}
