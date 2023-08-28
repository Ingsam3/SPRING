package com.car.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

		@Autowired
		private MemberRepository memberRepo;
		
		@Autowired
		private SqlSession sqlSession;
}
