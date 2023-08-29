package com.car.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //스프링 MVC 게시판 컨트롤러 클래스
@RequestMapping("/guide/*")
public class GudieController {
	
	@GetMapping("/guide")
	public void guide() {
		
	}
}
