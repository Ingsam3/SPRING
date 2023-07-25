package com.naver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.dao.GuestDAO;
import com.naver.vo.GuestVO;
//AOP를 통한 트랜잭션 적용대상 (데이터 일관성 유지)
@Service
public class GuestServiceImpl implements GuestService{

	@Autowired
	private GuestDAO guestDao;
	
	@Override
	public void insertGuest(GuestVO g) {
		this.guestDao.insertGuest(g);		
	}

	@Override
	public int getTotalCount() {
		return this.guestDao.getTotalCount();
	}

	@Override
	public List<GuestVO> getGuestList(GuestVO g) {
		return this.guestDao.getGuestList(g);
	}

	@Override
	public GuestVO getGuestCont(int gno) {
		this.guestDao.updateHit(gno);
		return this.guestDao.getGuestCont(gno);
	}

	@Override
	public GuestVO getBoardCont2(int gno) {
		return this.guestDao.getGuestCont(gno);
	}

	@Override
	public void editGuest(GuestVO eb) {
		this.guestDao.editGuest(eb);		
	}

	@Override
	public void delGuest(int gno) {
        this.guestDao.delGeust(gno);		
	}		
}
