package com.car.dao;

import com.car.vo.CarMemberVO;
import com.car.vo.MemberVO;
import com.car.vo.SocialVO;

public interface MemberDAO {

	CarMemberVO idCheck(String id);
	
	void insertMember(CarMemberVO cm);

	CarMemberVO loginCheck(String m_id);

	void insertKakao(SocialVO kakaoUser);

	SocialVO serchkakao(String userEmail);

	CarMemberVO serchUserEmail(String m_email);






}
