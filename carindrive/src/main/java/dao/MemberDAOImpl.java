package com.car.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.car.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void joinMember(MemberVO m) {
		this.sqlSession.insert("member_in",m);
	}

	@Override
	public int memberJoin(MemberVO m) {
		
		return this.sqlSession.insert("memberJoin",m);
	}



	

}
