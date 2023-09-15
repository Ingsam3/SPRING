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

	@Override
	public int sendMail(String m_email) {
		return 0;
		
		
	}//이메일 보내기
		
	}



	

	

	

