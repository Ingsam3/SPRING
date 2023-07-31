package com.naver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.dao.GongjiDAO;
import com.naver.vo.GongjiVO;
import com.naver.vo.GuestVO;

@Service
public class GongjiServiceImpl implements GongjiService {


	@Autowired //자동의존성 주입
	private GongjiDAO gongjiDao;

	@Override
	public void insertGongji(GongjiVO vo) {
		this.gongjiDao.insertGongji(vo);
	}

	
	
}
