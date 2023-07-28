package com.naver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.dao.GongjiDAO;

@Service
public class GongjiServiceImpl implements GongjiService {


	@Autowired //자동의존성 주입
	private GongjiDAO gongjiDao;
	
}
