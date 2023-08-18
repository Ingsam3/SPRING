package net.daum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
	@GetMapping("/start_thymLeaf")//start_thymLeaf 매핑주소 등록 - get으로 접근
	public ModelAndView start_thymLeaf() {
		
		ModelAndView tm = new ModelAndView();
		tm.addObject("greeting2","타임리프 페이지");//키이름,값 저장
		tm.setViewName("./thymLeaf/start_thymLeaf");
		//뷰페이지 경로 /src/main/resouces/templates/start_thymLeaf.html
		//src/main/resources/static경로로 html,js,css,이미지 등 
		//사이트 개발에 필요한 리소스 자원이 들어간다 
		//sts 상에서 html파일을 만들면 자동으로 src/main/webapp경로로 들어간다
		// 그러므로 해당경로에서 일반 file을 통해서 start_thymLeaf.html 파일을 생성해야한다
		return tm;
	}//start_thymLeaf
	
	//복수개 값을 타임리프로 가져오기
	@RequestMapping("/listTest")
	public void listTest(Model model) {
		//리턴타입이 없는 void형이면 매핑 주소가 뷰페이지 파일명이 된다
		//뷰페이지 경로 : src/main/resources/templates/listTest.html
		List<String> list = new ArrayList<>();
		
		for(int i=1; i<=10; i++) {
			list.add("Data : "+ i );//컬렉션에 추가
		}//for
		
		model.addAttribute("cont_title", "타임리프 복수개 값 가져오기");
		model.addAttribute("list",list);
	}//listTest
	
}
