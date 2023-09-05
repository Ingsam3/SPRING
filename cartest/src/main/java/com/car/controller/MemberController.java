package com.car.controller;

import java.io.PrintWriter;

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
	
	
	   //회원가입  
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
	  
	   
	    //회원 가입 저장
	    @RequestMapping("member_join_ok")
	    public ModelAndView member_join_ok(CarMemberVO cm) {
	    	
	    	cm.setM_pwd(CarPwdCh.getPassWordToXEMD5String(cm.getM_pwd()));//비번 암호화
	    	this.memberService.insertMember(cm);//회원 저장
	    	
	    	return new ModelAndView("redirect:/member/m_login");
	    }
	    
	    //회원 로그인
	    @GetMapping("m_login")
		   public String memberLogin() {
			   return "member/m_login";
		   }
	    
	
	    
	    // 로그인 인증 처리
	    //가입회원인 경우는 mem_state=1 일때 로그인 인증 처리(탈퇴 회원은 mem_state=2라서 로그인 인증 불가)
	    @PostMapping("/m_login_ok")
	    public ModelAndView member_login_ok(String login_id,String login_pwd,
	    		HttpServletResponse response,HttpSession session) throws Exception{
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out=response.getWriter();
	        
	        CarMemberVO cm=this.memberService.loginCheck(login_id);//아이디와 가입회원 1인 경우만
	        //로그인 인증 처리한다.
	        
	        if(cm == null) {
	        	out.println("<script>");
	        	out.println("alert('가입 안된 회원입니다.!');");
	        	out.println("history.back();");
	        	out.println("</script>");
	        }else {
	        	if(!cm.getM_pwd().equals(CarPwdCh.getPassWordToXEMD5String(login_pwd))) {
	        		out.println("<script>");
	        		out.println("alert('비번이 다릅니다!');");
	        		out.println("history.go(-1);");
	        		out.println("</script>");        		
	        	}else {
	        		session.setAttribute("id",login_id);//세션 id키이름에 아이디를 저장
	        		return new ModelAndView("redirect:/member_login");
	        	}
	        }
	    	return null;
	    }//member_login_ok()
	   
	 //반복적인 코드를 하나로 줄이기 =>로그인 상태 확인
	    public static boolean isLogin(HttpSession session,HttpServletResponse response)
	    throws Exception{
	    	PrintWriter out=response.getWriter();
	    	String id=(String)session.getAttribute("id");
	    	
	    	if(id == null) {
	    		out.println("<script>");
	    		out.println("alert('다시 로그인 하세요!');");
	    		out.println("location='member_login';");
	    		out.println("</script>");
	    		
	    		return false;
	    	}
	    	return true;
	    }//isLogin()
	   
}
