package com.naver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.service.BoardService;

@Controller //spring mvc 게시판 컨트롤러 클래스
@RequestMapping("/board/*")//경록 구분 하기 위해서 컨트롤러 자체 매핑주소 /board 등록
public class BoardController {
	
	//boardService와 연결
	@Autowired
	private BoardService boardService;
	
	//게시판 클쓰기 폼
	@RequestMapping(value="/board_write", method=RequestMethod.GET)
	//get 으로 접근하는 매핑주소 등록
	
	public void board_write() {
		//리턴 타입이 void 형이면 매핑주소가 부페이지 파일명이된다.
		//뷰리졸브 경로는 /WEB_INF/views/bpard/board_write.jsp
	}


	
}
