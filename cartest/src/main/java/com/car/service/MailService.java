package com.car.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailService {

	/*이메일 주소 들어오는지 확인하기*/
	public int sendMail(String m_email){
    	
		String test = "leeye1021@naver.com";
		int number =0;
        if(m_email.equals(test)) {
        	
        	number =1;
        	
        }else {
        	number =0000;
        }
        return number;
        
    }
	
	/*
    private final JavaMailSender javaMailSender;
    private static final String senderEmail= "dldpdnjs1021@gmail.com";
    private static int number;

    public static void createNumber(){
        number = (int)(Math.random() * (90000)) + 100000;// (int) Math.random() * (최댓값-최소값+1) + 최소값
    }

    public MimeMessage CreateMail(String m_email){
        createNumber();
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setFrom(senderEmail);
            message.setRecipients(MimeMessage.RecipientType.TO, m_email);
            message.setSubject("이메일 인증");
            String body = "";
            body += "<h3>" + "요청하신 인증 번호입니다." + "</h3>";
            body += "<h1>" + number + "</h1>";
            body += "<h3>" + "감사합니다." + "</h3>";
            message.setText(body,"UTF-8", "html");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return message;
    }

    public int sendMail(String m_email){
    	
        MimeMessage message = CreateMail(m_email);
        javaMailSender.send(message);

        return number;
    }*/
}