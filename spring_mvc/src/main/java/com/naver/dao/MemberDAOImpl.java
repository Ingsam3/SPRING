package com.naver.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.vo.MemberVO;

@Repository // DAO를 스프링으로 인식하게 함
public class MemberDAOImpl implements MemberDAO {
	@Autowired //자동 의존성 주입(DI)
	private SqlSession sqlSession;
	//mybatis 쿼리문 수행 객체 SqlSession 생성

	@Override
	public void insertMember(MemberVO mem) {
		this.sqlSession.insert("mem_in",mem);
	
	}
	
	

}
