package net.daum.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.daum.vo.AddrVO;
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
	
	@RequestMapping(value = "/addrList",produces = "application/json")
	public List<AddrVO> addrList(){
		
		List<AddrVO> addrList = new ArrayList<>();
		
		for(int i=1; i<=3; i++) {
			AddrVO addrvo = new AddrVO();
			addrvo.setAddrNo(i);
			addrvo.setSido("서울시");
			addrvo.setGugun("종로구");
		
			addrList.add(addrvo); //컬렉션에 추가
		
	   }
	   return  addrList;
	
	}//addrList
	
	//키, 값 쌍의 Map 타입 Json 데이터
	@RequestMapping(value = "/mapList",produces = "application/json")
	public Map<Integer,AddrVO> mapList(){
		Map<Integer,AddrVO> maplist = new HashMap<>();
		
		for(int i=1; i<=5; i++) {
			AddrVO addr = new AddrVO();
			addr.setAddrNo(i);
			addr.setSido("부산시");
			addr.setGugun("해운대구");
		
			maplist.put(i, addr);//키, 값 저장
			//오토박싱..? i => int로 저장 X
	   }
	   return  maplist;
		
	}//mapList
	
	//정상적인 json 데이터와 404 - (해당 경로에 파일 없는 에러) -나쁜 상태코드가  동시전송
	@RequestMapping(value = "/sendlistNot",produces = "application/json")
	public ResponseEntity<List<AddrVO>> sendlistNot(){
		List<AddrVO> addrList = new ArrayList<>();
		
		for(int i=1; i<=3; i++) {
			AddrVO addr = new AddrVO();
			addr.setAddrNo(i);
			addr.setSido("부산시");
			addr.setGugun("영도구");
			
			addrList.add(addr);//컬렉션에 추가
	   }
		
		return new ResponseEntity<>(addrList,HttpStatus.NOT_FOUND);
	}
	
	
	
}
