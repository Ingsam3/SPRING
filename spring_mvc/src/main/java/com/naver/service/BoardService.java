package com.naver.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.naver.vo.BoardVO;

public interface BoardService {
	
	
	void insertBoard(BoardVO b);

}
