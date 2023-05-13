package com.example.weinv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequest {
    private String senderEmail;
    private String recipientEmail;
    private String subject;
    private String textContent;
    private String htmlContent;
}
