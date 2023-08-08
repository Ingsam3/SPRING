package net.daum.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHander implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException,
	ServletException {
	//403 접근 금지 에러가 발생했을 때 다양한 처리를 하고 싶다면 직접 AccessDeniedHandler 인터페이스를 구현 상속받아서
	//사용하면 된다.	

		System.out.println("Access Denied Handler");
		System.out.println("Redirect.....");
		
		response.sendRedirect("/accessError");//accessError 매핑주소로 이동
	}
}
