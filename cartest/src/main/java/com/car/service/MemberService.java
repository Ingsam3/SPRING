package com.car.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.car.vo.CarMemberVO;
import com.car.vo.MemberVO;
import com.car.vo.SocialVO;

public interface MemberService {
	
	


	CarMemberVO idCheck(String id);

	void insertMember(CarMemberVO cm);

	CarMemberVO loginCheck(String m_id);

	void insertKakao(SocialVO kakaoUser);

	SocialVO serchkakao(String userEmail);

	CarMemberVO serchUserEmail(String m_email);

	
	
	


	
	


	

}
