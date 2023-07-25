package com.naver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.dao.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {

	
	@Autowired
	private ReplyDAO replyDao;
}
