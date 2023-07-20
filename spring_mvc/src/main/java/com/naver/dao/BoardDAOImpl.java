package com.naver.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.vo.BoardVO;

@Repository //DAO를 스프링에서 인식하게 함
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired //자동의존성 주입
	private SqlSession sqlSession; //mybatis 쿼리문 실행
	// (DI) 객체 의존성 주입
	
	@Override
	public void insertBoard(BoardVO b) {
		this.sqlSession.insert("board_in",b);
		
	}


}
