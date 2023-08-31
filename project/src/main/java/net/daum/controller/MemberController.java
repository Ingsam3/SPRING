package net.daum.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.MemberService;
import net.daum.vo.MemberVO;
import net.daum.vo.ZipCodeVO;
import net.daum.vo.ZipCodeVO2;
import pwdconv.PwdChange;

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
		
		//아이디 중복 검색
		@PostMapping("/member_idcheck")
		public ModelAndView member_idcheck(String id, HttpServletResponse response
				)throws Exception {
			response.setContentType("text/html;charset=UTF-8");
			//언어코딩 타입을 설정함으로써 출력되는 한글이 안 깨지고, html과 자바스크립트가 잘 실행되게 한다
			
			PrintWriter out = response.getWriter(); //출력스트림 out 생성
			 MemberVO db_id = this.memberService.idCheck(id);//아이디에 해당되는 회원정보 검색
			 
			 int re =-1; //중복 아이디가 없을 때 반환 값
			 if(db_id != null) {//중복아이디가 있는 경우
				 re=1;
			 }
			out.println(re); //값 반환 기능
			return null;
			
		}//member_idcheck()
		
		
		//우편 주소 검색 공지 창
		@RequestMapping("/zip_find")
		public ModelAndView zip_find() {
			
			ModelAndView zm = new ModelAndView();
			zm.setViewName("member/zip_Find");
			//뷰페이지 경로
			
			return zm;
		}
		
		//우편 주소 검색 결과
		@PostMapping("/zip_find_ok")
		public ModelAndView zip_find_ok(String dong) {
			
			List<ZipCodeVO> zlist = this.memberService.zipFind("%"+dong+"%");
			List<ZipCodeVO2> zlist2 = new  ArrayList<>();
			
			for(ZipCodeVO z:zlist) {
				ZipCodeVO2 z2 = new ZipCodeVO2();
				
				z2.setZipcode(z.getZipcode());//우편번호 저장
				z2.setAddr(z.getSido()+" "+z.getGugun()+" "+z.getGil());//시도 구군 길 
				
				zlist2.add(z2);//컬렉션에 추가
			}
			ModelAndView zm = new ModelAndView("member/zip_Find");
			zm.addObject("zipcodelist",zlist2);
			zm.addObject("dong",dong);
			return zm;
		}//zip_find_ok()
		
		//회원 저장
		@RequestMapping("/member_join_ok")
		public ModelAndView member_join_ok(MemberVO m) {
			
			/*member_join의 네임 파라미터 이름과 MemberVo 의 변수명이 같으면 MemberVO m의 
			 * 가입폼에서 입력한 회원정보가 저장되어진다 => 코드 라인 줄임*/
			
			m.setMem_pwd(PwdChange.getPassWordToXEMD5String(m.getMem_pwd()));
			//비번 암호화
			this.memberService.insertMember(m);//회원 저장
			
			/*탈퇴 사유, 탈퇴 날짜 빼 고 저장
			 * 가입회원인 경우는 mem_state=1이고, 탈퇴회원이면2로 한다*/
			
			return new ModelAndView("redirect:/member_login"); 
		}//member_join_ok
		
		//비번 찾기 공치창
		@GetMapping("/pwd_find")
		public ModelAndView pwd_find() {
			
			return new ModelAndView("redirect:/pwd_find");
		}//pwd_find()
		
		
		//비번 찾기 결과
		@RequestMapping("/pwd_find_ok")
		public ModelAndView pwd_find_ok(@RequestParam("pwd_id") String pwd_id,
				String pwd_name, HttpServletResponse response, MemberVO m)
		throws Exception{
			/*@RequestParam("pwd_id")의 뜻은 pwd_id 네임 파라미터 이름에 저장된 아이디 값을 가져오는 것
			 * request.getParemeter("ped_id)와 같은 의미
			 * 
			 * */
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			m.setMem_id(pwd_id);
			m.setMem_name(pwd_name);
			
			return new ModelAndView("redirect:/pwd_find");
		}//pwd_find_ok()
		
		
		
		
		
		
		
		
		
		
}
