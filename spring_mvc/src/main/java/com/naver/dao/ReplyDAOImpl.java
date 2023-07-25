package com.naver.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // 모델DAO인식
public class ReplyDAOImpl implements ReplyDAO {
	@Autowired // 자동의존성 주입
	
	private SqlSession sqlsession; // mybatis 쿼리문 수행sqlsession
}
