package com.naver.dao;

import java.util.List;

import com.naver.vo.GongjiVO;
import com.naver.vo.GuestVO;

public interface GongjiDAO {

	void insertGongji(GongjiVO g);
	int getTotalCount();
	List<GuestVO> getGongjilist(GongjiVO g);
	GongjiVO getGongjiCont(int gno);
	void updateHit(int gno);
	void updateGongji(GongjiVO eb);
	void delGongji(int gno);

}
