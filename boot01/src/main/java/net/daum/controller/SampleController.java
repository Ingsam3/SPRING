package net.daum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.daum.vo.Sample2VO;

@RestController
public class SampleController {

	@GetMapping("/boot_start") //boot_start매핑주소 등록
	public String boot_start() {
		return "스프링 부트 start"; //문자열 객체 반환
	}
	
	@RequestMapping(value="/sample2_write",produces="application/json")
	public Sample2VO sample2_write() {
		//리턴타입이 Sample2VO 빈클래스 타입이면 해당 클래스 변수명이 json데이터의 키이름이 된다.
		Sample2VO vo=new Sample2VO();
		vo.setVal01("val01변수 입니다.");
		vo.setVal02("val02변수 입니다.");
		vo.setVal03("val03변수 입니다.");
		
		System.out.println(vo.toString());//val03변수가 제외하고 출력된다.
		return vo;
	}
}
