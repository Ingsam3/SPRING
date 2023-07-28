package com.naver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.dao.MessageDAO;
import com.naver.dao.PointDAO;

@Service
public class MessageServiceImpl implements MessageService {

	//다른 서비스와 차이점은  AOP를통한 트랜잭션을 적용하기 위해 2개의 DAO로 나눠진다

	@Autowired
	private MessageDAO messageDao;
	
	@Autowired
	private PointDAO pointDao;
	
	
	
}
