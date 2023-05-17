package com.example.weinv.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.weinv.entity.Campaign;

public interface CampaignRepo extends JpaRepository<Campaign,Integer>{
	
	@Query(value="Select cmp.* from Campaign cmp join pitch pc on pc.pitch_id=cmp.pitch_id where pc.cmp_id=?1 ", nativeQuery=true)
	List<Campaign> findAllCampsByCmpId(int id);
	
	@Query(value="select camp.*,pc.pitch_desc, pc.feature_img, pc.feature_vid, pc.deck, cmp.* from Campaign camp "
			+ "join pitch pc on pc.pitch_id = camp.pitch_id join Company cmp on pc.cmp_id=cmp.cmp_id", nativeQuery=true)
    List<Object[]> publicCamps();

	@Query(value="select camp.*,pc.pitch_desc, pc.feature_img, pc.feature_vid, pc.deck, cmp.* from Campaign camp "
			+ "join pitch pc on pc.pitch_id = camp.pitch_id join Company cmp on pc.cmp_id=cmp.cmp_id where camp.camp_id=?1", nativeQuery=true)
    List<Object[]> findCampbyCmpId(int id);
    
    @Modifying
    @Query("Update Campaign set raised_amt= raised_amt + ?1 where camp_id=?2")
    void updateCampAmt(float amt,int camp_id);
}
