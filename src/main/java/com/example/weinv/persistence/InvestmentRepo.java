package com.example.weinv.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.weinv.entity.Investment;

public interface InvestmentRepo extends JpaRepository<Investment,Integer> {
	
	@Query("FROM Investment where camp_id=?1")
	List<Investment> findByCampId(int camp_id);
	
	@Query("FROM Investment where user_id=?1")
	List<Investment> findByUserId(int user_id);
	
}
