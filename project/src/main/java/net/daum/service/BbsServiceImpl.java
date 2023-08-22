package net.daum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.daum.dao.BbsDAO;
import net.daum.vo.BbsVO;

@Service
public class BbsServiceImpl implements BbsService {
	
	/*
	 서비스의 역할
	 1. 컨트롤러와 모델DAO를 연결하는 중간 매개체 역할
	 2. 고객 추가요구 사항을 반영하는 곳
	 3.  
	 */
	@Autowired
	private BbsDAO bbsDao;

	@Override
	public void insertBbs(BbsVO b) {
		this.bbsDao.insertBbs(b);
	}
	
}
