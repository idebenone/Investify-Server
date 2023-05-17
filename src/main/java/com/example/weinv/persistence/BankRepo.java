package com.example.weinv.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.weinv.entity.Bank;

public interface BankRepo extends JpaRepository<Bank, Integer> {

	@Query(value="Select * from Bank where card_number=?1",nativeQuery=true)
	Bank getBankDet(String card_number);

}
