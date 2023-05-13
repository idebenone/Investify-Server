package com.example.weinv.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.weinv.entity.Otp;

public interface OtpRepo extends JpaRepository<Otp,Integer> {
	@Query(value ="SELECT * FROM otp where otp= :otp",nativeQuery = true)
	List<Object[]> verify_reg(@Param("otp")int otp);
}
