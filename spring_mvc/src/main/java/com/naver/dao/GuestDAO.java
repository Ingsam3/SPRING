package com.naver.dao;

import java.util.List;

import com.naver.vo.GuestVO;

public interface GuestDAO {

	void insertGuest(GuestVO g);
	int getTotalCount();
	List<GuestVO> getGuestList(GuestVO g);
	void updateHit(int gno);
	GuestVO getGuestCont(int gno);
	void editGuest(GuestVO eb);
	void delGeust(int gno);	

}
