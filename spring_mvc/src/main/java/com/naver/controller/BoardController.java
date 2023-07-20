package com.naver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.naver.service.BoardService;
import com.naver.vo.BoardVO;

@Controller //spring mvc 게시판 컨트롤러 클래스
@RequestMapping("/board/*")//경로 구분 하기 위해서 컨트롤러 자체 매핑주소 /board 등록
public class BoardController {
	
	//boardService와 연결
	@Autowired
	private BoardService boardService;
	
	//게시판 글쓰기 폼
	@RequestMapping(value="/board_write", method=RequestMethod.GET)
	//get 으로 접근하는 매핑주소 등록
	
	public void board_write() {
		//리턴 타입이 void 형이면 매핑주소가 뷰페이지 파일명이된다.
		//뷰리졸브 경로는 /WEB_INF/views/bpard/board_write.jsp
	}//board_write end => get 방식

	//게시판 저장 - 전달 인자 개수가 다른 메서드 오버로딩
	@RequestMapping(value="/bord_write",method=RequestMethod.POST)
	public ModelAndView board_write(BoardVO b, RedirectAttributes rttr) {
		
		/*boardVO.java 의 변수명과 board_write.jsp 의 네임 파라미터 이름이 같으면 
		 Board b라고만 해도 b객체에 글쓴이, 글제목, 글내용이 저장되어있다 =>코드라인감소
		 */
		this.boardService.insertBoard(b);
		rttr.addFlashAttribute("msg","succes");
		//다른 매핑 주소로 msg 키이름에 succes 문자열을 담아서 값을 전달할 때 사용 -> post
		
		
		return new ModelAndView("redirect:/board/board_list");
		
		/*
		  ModelAndView 생성자 인자값 가능한  종류
		  1. 뷰페이지 경로와 파일명
		  2. redirect:/ 사용한 매핑주소
		 */
	}//board_write => post 방식
	
	//게시판 목록
	@RequestMapping("/board_list")
	//get or post로 접근하는 매핑주소를 처리, board_list매핑주소 등록
	public String board_list() {
		
		return "board/board_list";
		//뷰페이지 경로 : /WEB_INF/views/board/board_list.jsp
	}//board_list() end
	
}




