package com.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //스프링 MVC 게시판 컨트롤러 클래스
@RequestMapping("/insurance/*")
public class InsuranceController {
	@RequestMapping(value = "/insurance",method=RequestMethod.GET)
	   public String insurance() {
	      return "insurance/insurance";
	   }

}
