package com.naver.service;

import java.util.List;

import com.naver.vo.BoardVO;

public interface BoardService {

	void insertBoard(BoardVO b);

	int getTotalCount();

	List<BoardVO> getBoardList(BoardVO b);

}
