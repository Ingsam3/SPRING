package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommonController {

	@GetMapping("/accessError") //403접근 금지 에러가 발생했을 때 실행되는 매핑주소
	public void accessDenied(Model model) {
		//메서드 리턴타입이 void형이면 매핑주소가 뷰페이지 파일명이 된다.
		
		System.out.println("access Denied ");
		model.addAttribute("msg","Access Denied");//msg키이름에 Access Denied 값을 저장
	}
	
	@GetMapping("/customLogin") //customLogin매핑주소 등록
	public void loginInput(String error,String logout,Model model) {
      	System.out.println("error : " +error);
      	System.out.println("logout : " + logout);
      	
      	if(error != null) {
      		model.addAttribute("error", "Login Error Check Your Account");
      	}
      	
      	if(logout != null) {
      		model.addAttribute("logout","Logout!!");
      	}
	}//loginInput()
	
	//get방식으로 로그아웃을 처리하는 페이지
	@GetMapping("/customLogout")
	public void logoutGet() {}
	
	//post방식으로 로그아웃 처리
	@PostMapping("/customLogout")
	public void logoutPost() {}
}




