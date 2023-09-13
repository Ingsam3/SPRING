package com.car.controller;

import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.apache.bcel.generic.MULTIANEWARRAY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.car.service.MemberService;
import com.car.vo.CarMemberVO;
import com.car.vo.KakaoProfile;
import com.car.vo.OAuthToken;
import com.car.vo.SocialVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
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
	    public String m_login_ok(String m_id,String m_pwd,
	    		HttpServletResponse response,HttpSession session) throws Exception{
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out=response.getWriter();
	        
        	
	        CarMemberVO cm=this.memberService.loginCheck(m_id);
	        //아이디와 가입회원 1인 경우만로그인 인증 처리
	        //login_id =m_id //login_pwd =m_pwd
	        
	        if(cm == null) {
	        	out.println("<script>");
	        	out.println("alert('가입 안된 회원입니다.!');");
	        	out.println("history.back();");
	        	out.println("</script>");
	        }else {
	        	if(!cm.getM_pwd().equals(CarPwdCh.getPassWordToXEMD5String(m_pwd))) {
	        		out.println("<script>");
	        		out.println("alert('비번이 다릅니다!');");
	        		out.println("history.go(-1);");
	        		out.println("</script>");        		
	        	}else {
	        		session.setAttribute("id",m_id);//세션 id키이름에 아이디를 저장
	        		return "main/index";
	        		
	        	}
	        }
	    	return null;
	    }//member_login_ok()
	    
	    //로그아웃
	    @RequestMapping("/m_logout")
	    public String m_logout(HttpServletResponse response,
	    		HttpSession session) throws Exception{
	    	response.setContentType("text/html;charset=UTF-8");
	    	PrintWriter out=response.getWriter();
	    	
	    	session.invalidate();//세션 만료 => 로그아웃
	    	
	    	out.println("<script>");
	    	out.println("alert('로그아웃 되었습니다!');");
	    	out.println("</script>");
	    	
	    	return "main/index";
	    }//m_logout()
	    
	   
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
	    
	    //아이디 찾기 뷰페이지
	    @RequestMapping("/serch_id")
	    public String serch_id() {
	    	
	    	return "member/serch_id";
	    }
	    
	    //비밀번호 찾기 뷰페이지
	    @RequestMapping("/serch_pwd")
	    public String serch_pwd() {
	    	
	    	return "member/serch_pwd";
	    }
	    

	   
	    
	    //이메일 인증 함수
	    @RequestMapping("/test_email")
	    public String test_email() {
	    	
	    	return null;
	    }
	    
	    //kakao callback
	    @GetMapping("/kakaotest")
	    public @ResponseBody ModelAndView kakaotest(String code , HttpSession session) 
	    throws Exception{
	    	   //Data를 리턴해주는 함수
	    	
	    	
	    	
	    	//POST 방식으로 key=value 데이터 요청(카카오 쪽으로)
	    	RestTemplate rt = new RestTemplate();
	    	
	    	//HttpHeader 오브젝트 생성
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
	    	//key-value 형태임을 알림
	    	
	    	//HttpBody 오브젝트 생성
	    	MultiValueMap<String ,String> params = new LinkedMultiValueMap<>();
	    	params.add("grant_type", "authorization_code");
	    	params.add("client_id", "4094fcc6d950836e2f6c9f216ab46fef");
	    	params.add("redirect_uri", "http://localhost:7990/member/kakaotest");
	    	params.add("code", code);
	    	//값들은 변수화시켜 넣는게 좋음
	    	
	    	//HttpHeader와 httpbody를 하나의 오브젝트에 담기
	    	HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = 
	    			new HttpEntity<>(params,headers);
	    	
	    	//Http 요청 - post 방식으로 - 그리고 response변수의 응답을 받음
	    	ResponseEntity<String> response = rt.exchange(
	    			
	    			"https://kauth.kakao.com/oauth/token",
	    			HttpMethod.POST,
	    			kakaoTokenRequest,
	    			String.class
	    			//응답받을 타입
	    			);
	    	
	    	
	    	ObjectMapper obmapper = new ObjectMapper();
	    	OAuthToken oauthToken =null;
	    	
	    	try {
				oauthToken = obmapper.readValue(response.getBody(), OAuthToken.class);
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
	    	e.printStackTrace();
			}
	    	
	    	System.out.println("카카오 엑세스토큰"+oauthToken.getAccess_token());
	    	
	    	
	    	//두번째
	    	//POST 방식으로 key=value 데이터 요청(카카오 쪽으로)
	    	RestTemplate rt2 = new RestTemplate();
	    	
	    	//HttpHeader 오브젝트 생성
	    	HttpHeaders headers2 = new HttpHeaders();
	    	headers2.add("Authorization", "Bearer "+oauthToken.getAccess_token());
	    	headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
	    	//key-value 형태임을 알림
	    	 
	    	
	    	
	    	//HttpHeader와 httpbody를 하나의 오브젝트에 담기
	    	HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest2 = 
	    			new HttpEntity<>(headers2);
	    	
	    	//Http 요청 - post 방식으로 - 그리고 response변수의 응답을 받음
	    	ResponseEntity<String> response2 = rt2.exchange(
	    			
	    			"https://kapi.kakao.com/v2/user/me",
	    			HttpMethod.POST,
	    			kakaoProfileRequest2,
	    			String.class
	    			//응답받을 타입
	    			);
	    	
	    	System.out.println(response2.getBody());
	    	
	       	
	    	//카카오 프로필 정보 받아오기
	    	ObjectMapper obmapper2 = new ObjectMapper();
	    	KakaoProfile kakaoProfile =null;
	    	
	    	try {
	    		kakaoProfile = obmapper2.readValue(response2.getBody(), KakaoProfile.class);
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
	    	e.printStackTrace();
			}
	    	
	    	//UserObject  (c_member 테이블 정보)
	    	//아이디, 비밀번호, 생일, 이름, 이메일, 통신사, 전화번호, 가입회원 유무, 가입날짜
	    	System.out.println("카카오 아이디:" +kakaoProfile.getId());
	    	System.out.println("카카오 이메일:" +kakaoProfile.getKakao_account().getEmail());
	    	System.out.println("카카오 닉네임" +kakaoProfile.getKakao_account().getProfile().getNickname());
	    	System.out.println("carindrive 카카오 유저 네임 :"+kakaoProfile.getKakao_account().getEmail()+"_"+kakaoProfile.getId());
	    	System.out.println("carindrive 카카오 유저 이메일 :" + kakaoProfile.getKakao_account().getEmail());
	    	
	    	//임시 패스워드
	    	UUID garbagePassword = UUID.randomUUID();
	    	System.out.println("carindrive 카카오 유저 패스워드 :" + garbagePassword);
	    	
	    /*
	    	//회원 테이블에 카카오 유저 정보 저장
	    	SocialVO kakaoUser = SocialVO.builder()
	    			.Id(kakaoProfile.getId())
	    			.username(kakaoProfile.getKakao_account().getEmail()+"_"+kakaoProfile.getId())
	    			.password(garbagePassword.toString())
	    			.email(kakaoProfile.getKakao_account().getEmail())
	    			.build();
	    	
	    	*/
	    	
	    	//SocialVO에 카카오 유저 정보 저장
	    	Long userId= kakaoProfile.getId();
	    	String userPwd= garbagePassword.toString();
	    	String userEmail=kakaoProfile.getKakao_account().getEmail();
	    	String userName=kakaoProfile.getKakao_account().getEmail()+"_"+kakaoProfile.getId();
	    	String userNickName=kakaoProfile.getKakao_account().getProfile().getNickname();
	    	
	    	System.out.println(userName);
	    	
	    	SocialVO kakaoUser = new SocialVO();
	    	
	    	kakaoUser.setPassword(userPwd);
	    	kakaoUser.setEmail(userEmail);
	    	kakaoUser.setUsername(userName);
	    	
	    	
	    	/*
	    	//로그인 유무 체크
	    	if(isLogin(session, responsek)) {//로그인 된 상태면
	    		
	    		out.println("<script>");
	    		out.println("alert('이미 로그인 된 상태입니다!');");
	    		out.println("history.back();");
	    		out.println("</script>");
	    		
	    		
	    	}else { //로그인 안 된 상태면
	    		
	    		
	    		//회원 비회원 유무 파악
		    	SocialVO originUser = this.memberService.serchkakao(userEmail);
		    			    	
		    	if(originUser == null) { // 가입 안 된 회원
		    		//회원가입 -> DB에 넣어짐  
			    	this.memberService.insertKakao(kakaoUser);
			    	

		    		session.setAttribute("id","사용자");//세션 id키이름에 아이디를 저장
		    	
	        		return "main/index";
		        }else {// 가입 된 회원
		        	
		        	out.println("<script>");
		        	out.println("alert('이미 가입한 회원입니다!');");
		        	out.println("history.back();");
		        	out.println("</script>");
		          		
		        	}
	    	}
	    	
	    	
	    	*/
	    	
	    	//회원 비회원 유무 파악
	    	
	    	System.out.println("1----------------");

	    	SocialVO originUser = this.memberService.serchkakao(userEmail);
	    	System.out.println("2----------------");
	    	System.out.println(originUser);
	    			    	
	    	if(originUser == null) { // 가입 안 된 회원
	    		//회원가입 -> DB에 넣어짐  
		    	this.memberService.insertKakao(kakaoUser);
		    	System.out.println("3----------------");

	    		session.setAttribute("id",userNickName);//세션 id키이름에 유저 이메일을 저장
	    		return  new ModelAndView("redirect:/rent/rent"); //일단 예약 화면으로 이동하게 
	    		//return  new ModelAndView("redirect:/main/index"); //일단 예약 화면으로 이동하게 
	    		//메인페이지로 이동이 안 됨. 뷰페이지 주소 이상
	        }else {// 가입 된 회원
	        	
	        	return  new ModelAndView("redirect:/member/m_login");
	    	
	    	
	    }//카카오 로그인
	    
	   
	   
	    }
	    
}
