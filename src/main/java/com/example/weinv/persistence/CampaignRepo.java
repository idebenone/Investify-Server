package com.example.weinv.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.weinv.entity.Campaign;

public interface CampaignRepo extends JpaRepository<Campaign,Integer>{
	
	@Query(value="Select cmp.* from Campaign cmp join pitch pc on pc.pitch_id=cmp.pitch_id where pc.cmp_id=?1 ", nativeQuery=true)
	List<Campaign> findAllCampsByCmpId(int id);
	
	@Query(value="select camp.*,pc.pitch_desc, pc.feature_img, pc.feature_vid, pc.deck, cmp.* from Campaign camp "
			+ "join pitch pc on pc.pitch_id = camp.pitch_id join Company cmp on pc.cmp_id=cmp.cmp_id", nativeQuery=true)
    List<Object[]> publicCamps();

}
