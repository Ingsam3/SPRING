package com.naver.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.service.GuestService;

@Controller
@RequestMapping("/guest")
public class GuestController {
	/* 문제) 1. 다음과 같은 컬럼 정보를 가진 방명록 테이블 tbl_guest를 생성한다.
	 *        컬럼명     자료형     크기    제약조건
	 *        gno    int          기본키       번호
	 *        gname  varchar 20   not null 글쓴이
	 *        gtitle varchar2 200 not null 글제목
	 *        gcont  varchar2 4000 not null 글내용
	 *        ghit   int           sydate date  조회수
	 *        gdate date
	 *        
	 *      2.1부터 시작해서 1씩증가하고,임시 메모리를 사용하지 않는 gno_seq2 시퀀스를 생성한다.
	 *      3.GuestService.java,GuestServiceImpl.java를 com.naver.service패키지에 생성한다.
	 *      4.GuestDAO.java, GuestDAOImpl.java를 com.naver.dao패키지에 생성한다.
	 *      5.com.naver.mappers.mybatis 패키지에 guest.xml를 만들어서 mybatis매퍼태그로 sql문을 
	 *      작성한다.
	 *      6./WEB-INF/views/guestbook폴더에 뷰페지이 파일을 만든다. 
	 *        가. 먼저 방명록 글쓴이,글제목,글내용을 입력하는 입력폼을 만들고 자바스크립트와jQuery를 사용한 유효성 검증
	 *        메시지를 띄우게 한다. 입력폼 매핑주소는  guest_write로 한다.
	 *        나. 방명록 저장되는 매핑주소 guest_write_ok를 작성한다.
	 *        다. 페이징과 책갈피 기능이 되는 guest_list 방명록 목록보기 매핑주소를 작성한다.
	 *        라. 조회수증가와 내용보기가 되는 guest_cont 매핑주소를 작성한다. 조회수증가와 내용보기는 GuestServiceImpl.java에서 
	 *        나중에 스프링를 AOP를 통한 트랜잭션을 적용할 수 있게 논리적 단위로 묶는다.
	 *        마. 방명록 수정폼 guest_edit매핑주소를 작성하고,수정완료 되게 guest_edit_ok매핑주소를 작성한다.
	 *        바. 번호를 기준으로 삭제되게 guest_del매핑주소를 작성한다. 모든 매핑주소를 처리할 때 책갈피 기능이
	 *        구현되게 get방식으로 페이지 번호를 전달한다.
	 */ 
	
	@Autowired
	//private GuestService guestservice;
	
	//방명록 입력 폼
		@RequestMapping(value="/guest_write",method=RequestMethod.GET) 
		public void guest_write(Model wm, HttpServletRequest request) {
			int page=1;
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			wm.addAttribute("page",page);
			
		}//guest_write() =>GET방식
	
}
