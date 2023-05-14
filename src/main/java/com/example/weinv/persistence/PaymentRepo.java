package com.example.weinv.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.weinv.entity.Transactions;

public interface PaymentRepo extends JpaRepository<Transactions, Integer> {
	
	@Query("FROM Transactions where user_id=?1")
	List<Transactions> findTransByUserId(int id);
}
