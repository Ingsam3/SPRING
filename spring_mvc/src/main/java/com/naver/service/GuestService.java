package com.naver.service;

import java.util.List;

import com.naver.vo.GuestVO;

public interface GuestService {

	void insertGuest(GuestVO g);
	int getTotalCount();
	List<GuestVO> getGuestList(GuestVO g);
	GuestVO getGuestCont(int gno);
	GuestVO getBoardCont2(int gno);
	void editGuest(GuestVO eb);
	void delGuest(int gno);
	

}
