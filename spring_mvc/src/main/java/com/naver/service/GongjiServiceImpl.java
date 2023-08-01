package com.naver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.dao.GongjiDAO;
import com.naver.vo.GongjiVO;
import com.naver.vo.GuestVO;

@Service
public class GongjiServiceImpl implements GongjiService {

	@Autowired
	private GongjiDAO gongjiDao;

	@Override
	public void insertGongji(GongjiVO g) {
		this.gongjiDao.insertGongji(g);		
	}

	@Override
	public int getTotalCount() {
		return this.gongjiDao.getTotalCount();
	}

	@Override
	public List<GuestVO> getGongjiList(GongjiVO g) {
		return this.gongjiDao.getGongjilist(g);
	}

	@Transactional //스프링의 AOP를 통한 트랜잭션 적용
	@Override
	public GongjiVO getGongjiCont(int gno) {
		this.gongjiDao.updateHit(gno);//조회수 증가
		return this.gongjiDao.getGongjiCont(gno);//내용 보기
	}

	@Override
	public GongjiVO getGongjiCont2(int gno) {
		return this.gongjiDao.getGongjiCont(gno);
	}

	@Override
	public void updateGongji(GongjiVO eb) {
		this.gongjiDao.updateGongji(eb);		
	}

	@Override
	public void delGongji(int gno) {
		this.gongjiDao.delGongji(gno);		
	}
}
