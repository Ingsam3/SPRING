package net.daum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.MemberService;

@Controller
public class MemberController {//사용자 회원관리

		@Autowired
		private MemberService memberService;
		
		//로그인폼
		@GetMapping("/member_login")
		public ModelAndView member_login() {
			return new ModelAndView("member/member_Login");
			//생성자 인자값으로 뷰페이지 경로 설정
		}//member_login()
		
		
		@RequestMapping("/member_join")
		private ModelAndView member_join() {
			
			String [] phone = {"010","011","019"};
			String [] email = {"naver.com","daum.com","gmail.com","nate.com","직접입력"};
			
			ModelAndView jm = new ModelAndView();
			jm.addObject("phone", phone);
			jm.addObject("email", email);
			jm.setViewName("member/member_Join");
			return jm;
		}//member_join()
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
