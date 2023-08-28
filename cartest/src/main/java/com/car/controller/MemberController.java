package com.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.car.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/member", method=RequestMethod.GET)
	   public String service() {
	      return "member/member";
	   }
	@GetMapping("m_login")
	   public String memberLogin() {
		   return "member/m_login";
	   }
	   
	   @GetMapping("m_join")
	   public String insurance() {
		   return "member/m_join";
	   }
	
}
