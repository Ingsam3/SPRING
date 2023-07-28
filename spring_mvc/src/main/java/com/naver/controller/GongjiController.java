package com.naver.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/gongji/*")//컨트롤러 자체 매핑주소 등록
public class GongjiController {

	/*
	 O 1. tbl_gongji 공지사항 테이블 생성 +gongji_no_seq 시퀀스 생성
	 O 2.gongji.xml 을 com.naver.mappers.mybatis 패키지에 매퍼태그 파일을 만든다
	 O 3. 테이블 컬럼명과 일치하는 데이터 저장빈 클래스 GongjiVO.java를 만들고, 
	     lombok setter(),getter()생성
	O  4. com.naver.dao패키지에 GongjiDAO.java 인터페이스 생성, 
	          자손클래스   GongjiDAOImpl.java 생성
	 O 5. com.naver.service패키지에 GongjiService.java 인터페이스 생성, 
	          자손클래스   GongjiServiceImpl.java 생성
	  6. GongjiController 를 통한 뷰페이지 작성
	   : o 1) gongji_insert.jsp 생성 (공지작성자, 공지제목, 공지내용 입력폼 + 유효성검사)
	     2) 공지저장후 공지목록페이지를 gongji_list.jsp를 작성한다
	                 뷰리졸브 경로는 /WEB-INF/views/gongji로 한다.
	                 공지저장 매핑주소는 gongji_insert_ok로 한다. 공지목록 매핑주소는   gongji_list로한다
	     3) 공지 수정폼  뷰페이지는 gongji_update.jsp를 작성한다 +유효성검사
	       	공지 수정 완료 매핑주소는 gongji_update_ok로 한다. 
	       	공지 수정폼 매핑주소는 gongji_update로 한다
	     4) 공지 내용보기에서는 조회수 증가와 함께 GongjiServiceImpl.java에서
	        AOP를 통한 트랜잭션 처리를 한다. 
	                 내용보기 매핑주소는 gongji_cont로 한다.
	     5) gongji_cont.jsp에서confirm()로 삭제버튼을 클릭하면 삭제유무 창띄우고 확인시 삭제처리한다.              
	                 취소를 클릭하면 현재창에 그대로 있게 한다.삭제 매핑주소는 gongji_del로 한다.	
	  7. 공지목록에서 페이징 작업
	  8. 공지 목록에서 등록날짜 출력할 때 jstl 사용해서 년월일만 나오게 한다.
	 */
	
	
	//공지 작성  폼
		
	
		
}


