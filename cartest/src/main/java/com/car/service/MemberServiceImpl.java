package com.car.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.car.dao.MemberDAO;
import com.car.vo.CarMemberVO;
import com.car.vo.SocialVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDao;
	
	
	@Override
	public CarMemberVO idCheck(String id) {
		
		return this.memberDao.idCheck(id);
	}

	@Override
	public void insertMember(CarMemberVO cm) {
		this.memberDao.insertMember(cm);
		
	}

	@Override
	public CarMemberVO loginCheck(String m_id) {
		
		return this.memberDao.loginCheck(m_id);
	}

	@Override
	public void insertKakao(SocialVO kakaoUser) {
		this.memberDao.insertKakao(kakaoUser);
		
	}

	@Override
	public SocialVO serchkakao(String userEmail) {
		
		return this.memberDao.serchkakao(userEmail);
	}

	@Override
	public CarMemberVO serchUserEmail(String m_email) {
		
		return this.memberDao.serchUserEmail(m_email);
	}
	/*
	@Override
	public int sendMail(String m_email) {
		String test = "leeye1021@naver.com";
		int number =0;
        if(m_email.equals(test.trim())) {
        	
        	number =1; 
        	
        }else {
        	number =0000;
        }
        return number;
		
		
	}//이메일 보내기
	
	 public int sendMail(String m_email){
	    	
	        MimeMessage message = CreateMail(m_email);
	        javaMailSender.send(message);

	        return number;
	    }
		
	
	
	 private JavaMailSender javaMailSender;
	    private static final String senderEmail= "dldpdnjs1021@gmail.com";
	    private static int number;
	
	 public static void createNumber(){
	        number = (int)(Math.random() * (90000)) + 100000;// (int) Math.random() * (최댓값-최소값+1) + 최소값
	    }//랜덤 번호 생성
	 
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
	    }*/


	}



	

	

	

