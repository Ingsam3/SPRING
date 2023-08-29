package com.car.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.car.service.MemberService;
import com.car.vo.MemberVO;

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
	
	//임시 로그인
	@PostMapping("/m_login_ok")
	public ModelAndView m_login_ok () {
		
		
		
		return null;
	}
	   
	
	   @GetMapping("m_join")
	   public String m_join( HttpServletResponse response) {
		   response.setContentType("text/html;charset=UTF-8");
		   
		   return "member/m_join";
	   }
	   
	   // 임시 회원 저장
	   @PostMapping("/m_join_ok")
	   public ModelAndView m_join_ok(HttpServletResponse response, HttpSession session, HttpServletRequest request, MemberVO m)
	   throws Exception{
		   
		   response.setContentType("text/html;charset=UTF-8");
		   PrintWriter out = response.getWriter();
		   this.memberService.insertMember(m);
		   
	       return new ModelAndView("redirect:/member/m_login"); 
	   }
	   
	   @GetMapping("test")
	   public String test() {
		   return "member/test";
	   }
	
}
