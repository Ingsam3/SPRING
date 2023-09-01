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

import com.car.service.MemberService;
import com.car.vo.MemberVO;

@Controller //스프링 MVC 게시판 컨트롤러 클래스
@RequestMapping("/member/*")
public class MemberController {
	//private static final Logger logger = (Logger) LoggerFactory.getLogger(HomeController.class);
	
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
	   /*
	   @RequestMapping(value="/member/m_join_ok",method=RequestMethod.POST)
		public String m_join(MemberVO m, HttpSession session, HttpServletResponse response,
				 HttpServletRequest request) throws Exception{
		   response.setContentType("text/html;charset=UTF-8");
		   PrintWriter out = response.getWriter();
		   m.set
		   
		   this.memberService.joinMember(m);//회원 저장
			
			
			return "redirect:/member/m_login";
			
		}//m_join()*/
	   
	   @PostMapping("/m_join")
	   public String m_join(MemberVO m , HttpServletResponse response) 
	   throws Exception{
		   response.setContentType("text/html;charset=UTF-8");
		    PrintWriter out = response.getWriter();
		   
		   int result = memberService.memberJoin(m);
		   
		   String viewpage =null;
		   if(result == 1) { //DB 저장 성공시
			   viewpage = "redirect:/member/m_join_ok";
		   }else {
			  
			   viewpage = "redirect:/member/m_join";
			   out.println("<script>");
			   out.println("alert('회원가입에 실패했습니다!');");
			   out.println("</script>");
		   }
		   
		   return viewpage;
	   }
	   
	   
	   @GetMapping("serch_id")
	   public String serch_id() {
		   return "member/serch_id";
	   }
	   
	   @GetMapping("serch_pwd")
	   public String serch_pwd() {
		   return "member/serch_pwd";
	   }
	   
	   @GetMapping("pass_change")
	   public String pass_change() {
		   return "member/pass_change";
	   }
	 
}
