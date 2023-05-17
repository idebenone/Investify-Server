package com.example.weinv.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvCamp {
	
	private int id;
	private int user_id;
	private String trans_id;
	private int camp_id;
	private float amount;
	private Timestamp inv_date;
	private String cmp_name;
	private int cmp_id;
}
