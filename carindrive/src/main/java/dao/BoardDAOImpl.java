package com.car.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.car.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired	//의존주입
	private SqlSession sqlSession;

	@Override	//게시물 저장
	public void insertBoard(BoardVO b) {
		this.sqlSession.insert("board_in",b);
	}

	@Override	//한개의 레코드 반환
	public int getTotalCount() {
		return this.sqlSession.selectOne("board_count");
	}

	@Override //게시물 목록 반환
	public List<BoardVO> getBoardList(BoardVO b) {
		return this.sqlSession.selectList("board_list",b);
	}

	@Override	//bno를 이용한 내용보기
	public BoardVO getBoardCont(int bno) {
		return this.sqlSession.selectOne("board_cont",bno);
	}

	@Override	//수정
	public void editBoard(BoardVO eb) {
		this.sqlSession.update("board_edit",eb);
	}

	@Override	//삭제
	public void delBoard(int bno) {
		this.sqlSession.delete("board_del",bno);
	}
}
