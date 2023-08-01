package com.naver.service;

import java.util.List;

import com.naver.vo.GongjiVO;
import com.naver.vo.GuestVO;

public interface GongjiService {

	void insertGongji(GongjiVO g);
	int getTotalCount();
	List<GuestVO> getGongjiList(GongjiVO g);
	GongjiVO getGongjiCont(int gno);
	GongjiVO getGongjiCont2(int gno);
	void updateGongji(GongjiVO eb);
	void delGongji(int gno);

}
