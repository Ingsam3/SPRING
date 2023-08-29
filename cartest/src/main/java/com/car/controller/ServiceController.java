package com.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //스프링 MVC 게시판 컨트롤러 클래스
@RequestMapping("/service/*")
public class ServiceController {
	
	@RequestMapping(value="/service_center", method=RequestMethod.GET)
	public String service_center() {
		return "service/service_center";
	}
	
	@RequestMapping(value="/service_qna", method=RequestMethod.GET)
	public String service_qna() {
		return "service/service_qna";
	}
	
	@RequestMapping(value="/service_notice", method=RequestMethod.GET)
	public String service_notice() {
		return "service/service_notice";
	}
	
	@RequestMapping(value="/service_qwrite", method=RequestMethod.GET)
	public String service_qwrite() {
		return "service/service_qwrite";
	}
	
}
