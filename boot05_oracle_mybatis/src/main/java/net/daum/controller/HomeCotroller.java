package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeCotroller {

	@RequestMapping(value = "/mybatis_jpa", method = RequestMethod.GET)//GET으로 접금하는 매핑주소 처리
	public void jpa_mybatis_test(Model m) {
		//반환타입이 없는 void 형이면 매핑 주소가 뷰페이지 파일명이 된다 뷰리졸브 경로 (/WEB_INF/views/mybatis_jpa.jsp)
		
		m.addAttribute("content_title", "mybatis_jpa와 이름,주소 폼 연동 연습");
		
		
	}//jpa_mybatis_test()
	
}
