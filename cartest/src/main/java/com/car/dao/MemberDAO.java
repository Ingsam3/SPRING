package com.car.dao;

import com.car.vo.CarMemberVO;
import com.car.vo.MemberVO;

public interface MemberDAO {

	CarMemberVO idCheck(String id);

	void insertMember(CarMemberVO cm);





}
