package com.example.weinv.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.weinv.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {
	Optional<User> findByEmail(String email);
	
	@Modifying
	@Query("UPDATE User set verified= :verf where email=:email")
	void verifyUser(@Param("verf")int verf, @Param("email")String email);
	
	@Modifying
	@Query("UPDATE User set password=:pass where email=:email")
	void updatePassword(@Param("email")String email,@Param("pass")String pass);
}
