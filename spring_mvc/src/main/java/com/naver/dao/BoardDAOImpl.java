package com.naver.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.vo.BoardVO;

@Repository //@Repository 애노테이션은 DAO를 스프링에서 인식하게 한다.
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession; //mybatis 쿼리문을 수행할 sqlSession생성

	@Override
	public void insertBoard(BoardVO b) {
		this.sqlSession.insert("board_in", b);
		//mybatis 에서 insert()메드는 레코드를 저장시키는 기능을 한다. board_in은 board.xml에서 설정할 유일한
		//아이디명이다.
	}//스프링 MVC 게시판 저장	

	@Override
	public int getTotalCount() {

		return this.sqlSession.selectOne("board_count");
		//mybatis 에서 selectOne()메서드 단 한개의 레코드 값만 반환
		//board_count는 board.xml 매퍼 태그에서 설정할 유일한 아이디명.
	}//게시물 레코드 개수

	@Override
	public List<BoardVO> getBoardList(BoardVO b) {// 페이징 시BoardVO b 추가

		return this.sqlSession.selectList("board_list",b);// 페이징 시 객체 b 추가
		//mybatis 에서 selectList()메서드는 하나이상의 레코드를 검색해서 컬렉션 List로 반환
		//board_list는 board.xml에서 설정항 유일한 아이디명
	}//게시물 물 목록

	@Override
	public void updateHit(int bno) {
		this.sqlSession.update("board_hit",bno);
		//mybatis에서 update()메서드는 레코드 수정
		//board_hit는 board.xml에서 설정한 유일한 아이디명
	}//조회수 증가
}
