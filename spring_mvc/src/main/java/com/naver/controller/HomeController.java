package com.naver.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 스프링 컨트롤러 클래스
 */
@Controller // 애노테이션을 사용함으로써 인터넷 웹상에서 작동하는 스프링 컨트롤러로 인식함
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//매핑주소가-> / (루트경로)가 됨
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		//문자열 속성키이름인 server Time에 값으로 날짜 포맷 정보를 저장함
		
		return "home";
		//뷰페이지 경로(view 리졸브 경로) / WEB_INF/vuews/home.jsp
		//home이 뷰페이지인 jsp 파일명이다
	}
	
	//댓글 뷰페이지 작업
	@RequestMapping("/test") // /test 매핑주소 등록
	public void test() {
	// /test 메서드 리턴타입이 없어면    매핑주소 test.jsp가 파일명이 된다
	}
	
}
