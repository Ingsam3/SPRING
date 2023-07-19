package com.naver.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.naver.vo.ProductVO;

@Controller
public class Sample4Controller {

	@RequestMapping("/doE") // GET OR POST로 접근하는 매핑 주소를 처리,doE 매핑주소 
	public String doE(RedirectAttributes rttr) {
		rttr.addFlashAttribute("msg", "pusan");
		//다른 URL-pattern 매핑 주소msg키에 부산시 값을 담아서 전달한다. 
		//백엔그 서버상에서 다른 매핑 주소로 이동할 때 웹주소창에 전달값 노출 X => 보안이 좋다.
		return "redirect:/doF";
		//doE 매핑 주소가 실행되면 다른 매핑 주소인 /doF로 이동한다
		// => 저장, 수정 , 삭제 후에 새롭게 테이블 컬럼 레코드 값이 변화된 것을 전확히 확인하고자 하는 경우 사용한다
		
	}
	
	@GetMapping("/doF")//get으로 접근하는 매핑주소 => redirect 자체가get 방식
	public void doF(@ModelAttribute("msg") String value) {
		//리턴 타입이 없는 void 형이면 매핑 주소인 doF가 뷰페이지 파일명이 된다
		System.out.println("전달되어 지는 값 : " +value);
	}
	
	//키 값 쌍의json데이터 만드는 실습
	@RequestMapping(value = "/doJSON", produces="application/json" )
	public @ResponseBody ProductVO doJSON() {
		/*
		 @ResponseBody : jsp 파일을 만들지 않고 브라우저에 키,값 쌍의 사전적인 
		 json데이터를 쉽게 만들 수 있음 
		 리턴 타입이  ProductVO 빈클래스 타입이면 json 데이터의 키이름은 해당 클래스의 변수면이 된다. 
		 * */
		
		ProductVO p =new ProductVO("aircon",15000000);
		
		return p;
		
		
	}
	
	
	
}
