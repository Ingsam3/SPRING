package com.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.MemberDAO;
import com.car.vo.CarMemberVO;

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

	

	
	
}
