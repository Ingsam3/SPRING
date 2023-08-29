package com.car.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.car.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

		@Autowired
		private MemberRepository memberRepo;
		
		@Autowired
		private SqlSession sqlSession;

		@Override
		public void insertMember(MemberVO m) {
			this.sqlSession.insert("mem_in",m);
			
		}
}
