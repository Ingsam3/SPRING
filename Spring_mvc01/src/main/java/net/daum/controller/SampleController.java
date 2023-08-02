package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/*")//컨트롤 자체 매핑주소 등록
public class SampleController {
	@GetMapping("/all")//로그인 하지 않은 사용자도 접근 가능한 매핑주소
	public void doAll(){
		/*리턴 타입이 없는 void 형이기 때문에 매핑 주소가 뷰페이지 파일명이 된다
		 뷰리졸브 경로 : WEB-INF/views/sample/all.jsp
		 */
		System.out.println("do all can access everyone");
		
	}//doAll()
	@GetMapping("/member") // 로그인 사용자만 접근가능 함
	public void doMember (){
		System.out.println("logined member");
		
	}//doMember()
	
	@GetMapping("/admin")//로그인 한 사용자들 중에서 관리자 권한을 가진 사용자
	public void doAdmin(){
		System.out.println("admin only");
	}//doAdmin()
}
