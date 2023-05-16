package com.example.weinv.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.weinv.dto.CompanyPitchCampaign;
import com.example.weinv.entity.Campaign;

public interface CampaignRepo extends JpaRepository<Campaign,Integer>{
	
	@Query(value="Select cmp.* from Campaign cmp join pitch pc on pc.pitch_id=cmp.pitch_id where pc.cmp_id=?1 ", nativeQuery=true)
	List<Campaign> findAllCampsByCmpId(int id);
	
	
    @Query(value = "SELECT camp.camp_id AS campaignId, camp.camp_title AS campaignTitle, camp.pitch_id AS pitchId, " +
            "camp.start_date AS startDate, camp.end_date AS endDate, camp.min_raise AS minRaise, " +
            "camp.max_raise AS maxRaise, camp.target_raise AS targetRaise, camp.is_active AS isActive, " +
            "pc.pitch_desc AS pitchDescription, pc.feature_img AS featureImage, pc.feature_vid AS featureVideo, " +
            "pc.deck, cmp.cmp_id AS companyId, cmp.cmp_name AS companyName, cmp.prf_img AS profileImage, " +
            "cmp.pan, cmp.address, cmp.city, cmp.state, cmp.bio, cmp.media_link1 AS mediaLink1, " +
            "cmp.media_link2 AS mediaLink2, cmp.media_link3 AS mediaLink3 " +
            "FROM Campaign camp " +
            "JOIN Pitch pc ON pc.pitch_id = camp.pitch_id " +
            "JOIN Company cmp ON pc.cmp_id = cmp.cmp_id", nativeQuery = true)
    List<Object[]> publicCamps();

}
