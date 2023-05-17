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
	@Query("UPDATE User set password=:pass, is_active= :active where email=:email")
	void updatePassword(@Param("email")String email,@Param("active")int id,@Param("pass")String pass);
	
	@Modifying
	@Query("UPDATE User set full_name=?1,bio=?2,phone=?3,city=?4,state=?5,zip=?6 where id=?7")
	void updateUser(String name,String bio,long phone, String city,String state,String zip, int id);
}
