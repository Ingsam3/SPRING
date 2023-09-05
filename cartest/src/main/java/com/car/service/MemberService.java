package com.car.service;

import com.car.vo.CarMemberVO;
import com.car.vo.MemberVO;

public interface MemberService {

	CarMemberVO idCheck(String id);

	void insertMember(CarMemberVO cm);

	CarMemberVO loginCheck(String login_id);

	

}
