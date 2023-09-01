package com.car.service;

import java.util.List;

import com.car.vo.BoardVO;

public interface BoardService {

	void insertBoard(BoardVO b);
	
	int getTotalCount();
	
	List<BoardVO> getBoardList(BoardVO b);
	
	BoardVO getBoardCont(int bno);
	
	BoardVO getBoardCont2(int bno);
	
	void editBoard(BoardVO eb);
	
	void delBoard(int bno);

}
