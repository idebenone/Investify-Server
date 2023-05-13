package com.example.weinv.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.weinv.entity.Company;

public interface CompanyRepo extends JpaRepository<Company,Integer>{
	
	@Query("FROM Company where cmp_id= :id")
	Company getCmpById(@Param("id") int id);
	
	@Modifying
	@Query("UPDATE Company set cmp_name= :name, prf_img= :img, pan= :pan,address= :address,city= :city, state= :state,bio= :bio,media_link1= :link1,media_link2= :link2,media_link3= :link3 where cmp_id= :id")
	void editCmp(
			@Param("name")String name,
			@Param("img")String img,
			@Param("pan")String pan,
			@Param("address")String address,
			@Param("city")String city,
			@Param("state")String state,
			@Param("bio")String bio,
			@Param("link1")String link1,
			@Param("link2")String link2,
			@Param("link3")String link3,
			@Param("id")int id
			);
}
