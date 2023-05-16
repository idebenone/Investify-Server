package com.example.weinv.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.weinv.entity.Pitch;

public interface PitchRepo extends JpaRepository<Pitch,Integer>{
	
	@Query("FROM Pitch where cmp_id=?1")
	List<Pitch> findAllByCmpId(int id);

	@Modifying
	@Query("UPDATE Pitch set pitch_title=?1, pitch_desc=?2,feature_img=?3,feature_vid=?4,deck=?5 where pitch_id=?6")
	void updatePitch(String title, String desc, String img,String vid, String deck, int id);
}
