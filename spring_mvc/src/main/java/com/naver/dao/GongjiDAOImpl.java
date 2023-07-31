package com.naver.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.vo.GongjiVO;
import com.naver.vo.GuestVO;

@Repository
public class GongjiDAOImpl implements GongjiDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertGongji(GongjiVO vo) {
		this.sqlSession.insert("gongji_in",vo);
	}


	
	
}
