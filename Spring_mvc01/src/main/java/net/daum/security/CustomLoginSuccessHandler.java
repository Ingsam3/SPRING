package net.daum.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

//로그인 성공시 호출되는 클래스
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response,
			Authentication auth) throws IOException,
	ServletException {
		
       System.out.println("Login Success");
       List<String> roleNames = new ArrayList<>();//권한 목록을 저장하는 컬렉션 제네릭
       
       auth.getAuthorities().forEach(authority -> {
    	   roleNames.add(authority.getAuthority());
       });//로그인 권한을 가져와서 컬렉션에 추가
       
       System.out.println("ROLE NAME(권한 목록): "+ roleNames);
       
       if(roleNames.contains("ROLE_ADMIN")) {//관리자 권한인 경우
    	   response.sendRedirect("/sample/admin");
    	   return;//종료
       }
       
       if(roleNames.contains("ROLE_MEMBER")) {//일반 회원인 경우
    	   response.sendRedirect("/sample/member");
    	   return;
       }
       response.sendRedirect("/");
	}
}
