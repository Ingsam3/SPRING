package com.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 해당 컨트롤러 클래스를 스프링에서 인식하게한다.
public class SampleController {
	@RequestMapping("/doA")
	//doA 매핑주소 등록 , GET or POST로 접근하는 매핑주소를 처리
	public void doA() {
		
	}
}
