package com.naver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.dao.BoardDAO;
import com.naver.vo.BoardVO;

@Service  // @Service : 스프링 에서 서비스로 인식하게 된다
public class BoardServiceImpl implements BoardService {
	
	@Autowired // 자동 의존성 주입
	private BoardDAO boardDao;

	@Override
	public void insertBoard(BoardVO b) {
		
		
	}
	
	
	
	
}
