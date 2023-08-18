package net.daum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.UserAddrService;
import net.daum.vo.UserAddrVO;

@Controller
public class HomeCotroller {

	@Autowired
	private UserAddrService userAddrService; 
	
	@RequestMapping(value = "/mybatis_jpa", method = RequestMethod.GET)//GET으로 접금하는 매핑주소 처리
	public void jpa_mybatis_test(Model m) {
		//반환타입이 없는 void 형이면 매핑 주소가 뷰페이지 파일명이 된다 뷰리졸브 경로 (/WEB_INF/views/mybatis_jpa.jsp)
		
		m.addAttribute("content_title", "mybatis_jpa와 이름,주소 폼 연동 연습");
	}//jpa_mybatis_test()
	
	@RequestMapping(value = "/mybatis_jpa", method=RequestMethod.POST)
	//POST로 접근하는 매핑주소를 처리, 매핑주소가 같으면 메서드 방식으로 구분함
	//public ModelAndView mybatis_jpa(String username, String address) {
	public ModelAndView mybatis_jpa(UserAddrVO useraddr) {
		
		/*
		 mybatis_jpa.jsp 네임 파라미터 이름과 엔티티빈 클래스 useraddrVO.jsvs의 변수명이 같으면 
		 UserAddrVO useraddr 로 하면 이름과 주소가 저장되어 있다 
		 */
		
		//System.out.println("username : " +username); //mybatis_jpa.jsp 에서 받아온 username 값 출력
		//System.out.println("address : " +address); 
		System.out.println("username : " +useraddr.getUsername()); //mybatis_jpa.jsp 에서 받아온 username 값 출력
		System.out.println("address : " +useraddr.getAddress()); 
		
		//UserAddrVO useraddr = new UserAddrVO();
		//useraddr.setUsername(username); //받아온 값 UserAddrVO에 저장
		//useraddr.setAddress(address);
		
		this.userAddrService.insertUserAddr(useraddr); // 이름과 주소를 저장
		
		ModelAndView wm = new ModelAndView(); //
		wm.addObject("result","이름과 주소값 출력 And Jap+mybatis로 레코드 저장"); 
		wm.addObject("username", useraddr.getUsername());
		wm.addObject("address"+useraddr.getAddress());
		wm.setViewName("resultSuccess");//뷰페이지 파일명 설정 -> /WEB_INF/resultSuccess.jsp
		
		return wm;
	}
	
}
