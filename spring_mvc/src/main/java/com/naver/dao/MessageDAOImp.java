package com.naver.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository//model DAO 인식
public class MessageDAOImp implements MessageDAO {
	@Autowired
	private SqlSession sqlsession;
}
