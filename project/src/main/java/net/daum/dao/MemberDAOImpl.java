package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlsession; //mybatis 쿼리문 수행
	
	@Autowired
	private MemberRepository memberRepo; //JPA 쿼리문 수행 
	
	@Autowired
	private ZipCodeRepository zipcodeRepo;//JPA 쿼리문 수행 
	
	
	
	
}
