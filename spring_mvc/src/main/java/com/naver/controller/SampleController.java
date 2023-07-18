package com.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 해당 컨트롤러 클래스를 스프링에서 인식하게한다.
public class SampleController {
	@RequestMapping("/doA")
	//doA 매핑주소 등록 , GET or POST로 접근하는 매핑주소를 처리
	public void doA() {
	//리턴타입이 없는 void 형이면 매핑 주소가 뷰페이지 파일명이 된다.
	 System.out.println("doA매핑 주소 실행");
		
}
	
	@GetMapping("/doB")
	public ModelAndView doB() {
		ModelAndView bm = new ModelAndView();
		
		bm.setViewName("./test/doB");
		//뷰페이지 경로 : WEB-INF/views/test/doB.jsp
		return bm;
	}
}