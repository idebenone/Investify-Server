package com.example.weinv.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.weinv.dto.InvCamp;
import com.example.weinv.entity.Investment;

public interface InvestmentRepo extends JpaRepository<Investment,Integer> {
	
	@Query("FROM Investment where camp_id=?1")
	List<Investment> findByCampId(int camp_id);
	
	@Query(value="Select inv.*, cmp.cmp_name,cmp.cmp_id FROM Investment inv join campaign camp on inv.camp_id = camp.camp_id "
			+ " join pitch pc on pc.pitch_id = camp.pitch_id join company cmp on pc.cmp_id = cmp.cmp_id where user_id=?1",nativeQuery=true)
	List<Object[]> findByUserId(int user_id);
	
}
