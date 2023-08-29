package com.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //스프링 MVC 게시판 컨트롤러 클래스
@RequestMapping("/rent/*")
public class RentController {
	
	@RequestMapping(value="/rent", method=RequestMethod.GET)
	public String rent() {
		return "rent/rent";
	}
	
	@RequestMapping(value="/rentOK", method=RequestMethod.GET)
	public String rentOK() {
		return "rent/rentOK";
	}
}
