package com.naver.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

public class Sample2Controller {
	@RequestMapping("/doC")//doC매핑 주소
	
	public String doC(@ModelAttribute("msg2") String msg) {
		
		//@ModelAttribute : msg2 파라미터 이름에 인자값을 담아서 전달
		//주소창에 노푸로디는 방식인 doC?msg2=인자값 형태로 전달한다
		
		return "result"; 
		//뷰페이지 경로 : WEB-INF/views/result.jsp
	}
	
	
}
