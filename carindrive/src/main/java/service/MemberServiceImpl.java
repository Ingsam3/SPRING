package com.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.MemberDAO;
import com.car.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDao;

	@Override
	public void joinMember(MemberVO m) {
		this.memberDao.joinMember(m); 
	}

	@Override
	public int memberJoin(MemberVO m) {
		
		return this.memberDao.memberJoin(m);
	}

	

	

}
