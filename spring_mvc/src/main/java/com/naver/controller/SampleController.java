package com.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //@Controller 애노테이션을 사용하면 해당 컨트롤러 클래스를 스프링에서 컨트롤러로 인식하게 한다.
public class SampleController {

	@RequestMapping("/doA") // doA매핑주소 등록 , GET OR POST로 접근하는 매핑주소를 처리
	public void doA() {//리턴 타입이 없는 void형이면 매핑주소가 뷰페이지 파일명이 된다.
		System.out.println("doA매핑주소가 실행됨.");
	}
	
	@GetMapping("/doB") //GET으로 접근하는 매핑주소를 처리
	public ModelAndView doB() {
		
		ModelAndView bm = new ModelAndView();
		bm.setViewName("./test/doB"); //뷰페이지 경로 설정(뷰리졸브 설정) => /WEB-INF/views/test/doB.
		//jsp
		return bm;
	}
}
