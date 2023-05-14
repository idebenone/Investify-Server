package com.example.weinv.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import sendinblue.ApiClient;
import sendinblue.Configuration;
import sibApi.TransactionalEmailsApi;
import sibModel.SendSmtpEmail;
import sibModel.SendSmtpEmailSender;
import sibModel.SendSmtpEmailTo;

@Service
public class EmailService {
    private final ApiClient apiClient;
    private final TransactionalEmailsApi emailsApi;
    
    public EmailService() {
    	String apiKey = "";
    	
    	apiClient = Configuration.getDefaultApiClient();
    	apiClient.setApiKey(apiKey);
    	
    	emailsApi = new TransactionalEmailsApi();
    }
    
    public void sendEmail(String senderEmail, String recipientEmail, String subject, String textContent, String htmlContent) {
    	
    	SendSmtpEmail smtpEmail = new SendSmtpEmail();
    	smtpEmail.setSender(new SendSmtpEmailSender().email(senderEmail));
        smtpEmail.setTo(Arrays.asList(new SendSmtpEmailTo().email(recipientEmail)));
        smtpEmail.setSubject(subject);
        smtpEmail.setTextContent(textContent);
        smtpEmail.setHtmlContent(htmlContent);
    	
        try {
            emailsApi.sendTransacEmail(smtpEmail);
            System.out.println("Email sent successfully!");
        } catch (Exception e) {
            System.err.println("Error sending email: " + e.getMessage());
        }
    	
    }
	
}
