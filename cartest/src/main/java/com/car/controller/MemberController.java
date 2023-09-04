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
import com.car.vo.CarMemberVO;
import com.car.vo.MemberVO;

import pwdchange.CarPwdCh;

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
	   public String m_join( HttpServletResponse response) {
		   response.setContentType("text/html;charset=UTF-8");
		   
		   return "member/m_join";
	   }
	   
	   @PostMapping("/m_join_ok")
	   public ModelAndView m_join_ok() {
		   
		   return null;
	   }
	   
	   
	   //아이디 중복 검색
	    @PostMapping("/member_idcheck")
	    public ModelAndView member_idcheck(String id,HttpServletResponse response)
	    throws Exception{
	    	response.setContentType("text/html;charset=UTF-8");
	    	
	    	PrintWriter out=response.getWriter();
	    	
	    	CarMemberVO db_id = this.memberService.idCheck(id);
	    	
	    	int re=-1;//중복 아이디가 없을 때 반환값
	    	if(db_id != null) {//중복아이디가 있는 경우
	    		re=1;
	    	}
	    	out.println(re);//값 반환기능
	    	
	    	return null;
	    }//member_idcheck()
	  
	   
	    //회원저장
	    @RequestMapping("member_join_ok")
	    public ModelAndView member_join_ok(CarMemberVO cm) {
	    	
	    	cm.setM_pwd(CarPwdCh.getPassWordToXEMD5String(cm.getM_pwd()));//비번 암호화
	    	this.memberService.insertMember(cm);//회원 저장
	    	
	    	return new ModelAndView("redirect:/member/m_login");
	    }
	    
	    //회원 로그인
	    
	    
	    
	   @GetMapping("test")
	   public String test() {
		   return "member/test";
	   }
	
}
