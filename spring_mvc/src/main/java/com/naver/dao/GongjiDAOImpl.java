package com.naver.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.vo.GongjiVO;
import com.naver.vo.GuestVO;

@Repository
public class GongjiDAOImpl implements GongjiDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertGongji(GongjiVO g) {
		this.sqlSession.insert("gongji_in",g);		
	}//공지 저장	

	@Override
	public int getTotalCount() {
		return this.sqlSession.selectOne("gongji_count");
	}//총 레코드 개수

	@Override
	public List<GuestVO> getGongjilist(GongjiVO g) {
		return sqlSession.selectList("gongji_li",g);
	}//페이징 공지 목록

	@Override
	public GongjiVO getGongjiCont(int gno) {
		return this.sqlSession.selectOne("gongji_co",gno);
	}//공지 내용 보기

	@Override
	public void updateHit(int gno) {
		this.sqlSession.update("gongji_hi",gno);		
	}//조회수 증가

	@Override
	public void updateGongji(GongjiVO eb) {
		this.sqlSession.update("gongji_up", eb);		
	}//공지 수정 완료

	@Override
	public void delGongji(int gno) {
		this.sqlSession.delete("gongji_de", gno);		
	}//공지 삭제
}
