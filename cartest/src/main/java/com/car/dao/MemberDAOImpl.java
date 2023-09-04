package com.car.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.car.vo.CarMemberVO;
import com.car.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

		@Autowired
		private MemberRepository memberRepo;
		
		@Autowired
		private SqlSession sqlSession;

		@Override
		public CarMemberVO idCheck(String id) {
			
			return this.sqlSession.selectOne("m_idcheck",id);
		}//아이디 중복 검색

		@Override
		public void insertMember(CarMemberVO cm) {
			this.sqlSession.insert("C_mem_in",cm);
			
		}//회원 저장

	
}
