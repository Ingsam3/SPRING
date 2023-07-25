package com.naver.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.vo.GuestVO;

@Repository
public class GuestDAOImpl implements GuestDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertGuest(GuestVO g) {
		this.sqlSession.insert("g_in", g);		
	}//방명록 저장
	
	@Override
	public int getTotalCount() {
		return this.sqlSession.selectOne("g_count");
	}//총레코드 개수	

	@Override
	public List<GuestVO> getGuestList(GuestVO g) {
		return this.sqlSession.selectList("g_list",g);
	}//방명록 목록	

	@Override
	public void updateHit(int gno) {
		this.sqlSession.update("g_hit",gno);		
	}//조회수 증가

	@Override
	public GuestVO getGuestCont(int gno) {
		return this.sqlSession.selectOne("g_cont",gno);
	}//내용보기

	@Override
	public void editGuest(GuestVO eb) {
		this.sqlSession.update("g_edit", eb);		
	}//수정

	@Override
	public void delGeust(int gno) {
        this.sqlSession.delete("g_del",gno);		
	}//삭제
}
