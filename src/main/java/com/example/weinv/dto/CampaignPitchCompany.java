package com.example.weinv.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampaignPitchCompany {
    private int campaignId;
    private String campaignTitle;
    private int pitchId;
    private Timestamp startDate;
    private Timestamp endDate;
    private long minRaise;
    private long maxRaise;
    private long targetRaise;
    private long isRaisedAmt;
    private String pitchDescription;
    private String featureImage;
    private String featureVideo;
    private String deck;
    private int companyId;
    private String companyName;
    private String profileImage;
    private String pan;
    private String address;
    private String city;
    private String state;
    private String bio;
    private String mediaLink1;
    private String mediaLink2;
    private String mediaLink3;
	
}
