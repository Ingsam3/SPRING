package com.naver.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.naver.service.GongjiService;
import com.naver.vo.GongjiVO;
import com.naver.vo.GuestVO;

@Controller
@RequestMapping("/gongji/*") //컨트롤러 자체 매핑주소 등록
public class GongjiController {

	/* 문제)
	 *  1. 다음과 같은 테이블 정보를 가진 tbl_gongji 공지 사항 테이블을 생성한다.
	 *     컬럼명                자료형        크기    제약조건
	 *     gongji_no    number   38  primary key
	 *     gongji_name  varchar2 50  not null
	 *     gongji_title varchar2 200 not null
	 *     gongji_cont  varchar2 4000 not null
	 *     gongji_hit   number   38   sysdate 0
	 *     gongji_date  date          sysdate sysdate
	 *  
	 *     1부터 시작하고, 1씩 증가하고, 임시 메모리를 사용하지 않는 gongji_no_seq 시퀀스를 생성한다.
	 *     
	 *  2. gongji.xml을 com.naver.mappers.mybatis패키지에 매퍼태그 파일을 만든다.
	 *  3. 테이블 컬럼명과 일치하는 데이터 저장빈 클래스 GongjiVO.java를 만들고, Lombok라이브러러를 활용해서
	 *  setter(),getter()메서드를 자동 생성한다.
	 *  4. com.naver.dao패키지에 GongjiDAO.java인터페이스를 만들고 이를 구현 상속한 자손클래스 GongjiDAOImpl
	 *  .java를 만든다.
	 *  5. com.naver.service패키지에 GongjiService.java인터페이스를 만들고,이를 구현 상속한 자손클래스
	 *  GongjiServiceImpl.java를 만든다.
	 *  6. com.naver.controller 패키지의 스프링 컨트롤러 클래스 GongjiController.java를 통한
	 *  뷰페이지를 다음과 같이 작성한다.
	 *    가. 공지 작성 폼 뷰페이지 gongji_insert.jsp를 만든다. 공지작성자,공지제목,공지내용 입력폼을 만들고 자바스
	 *    크립트와 jQuery를 사용한 유효성 검증 처리를 한다. 공지 작성 폼 매핑주소는 gongji_insert로 한다.
	 *    나. 공지 저장후 공지목록페이지를 gongji_list.jsp를 작성한다. 뷰리졸브 경로는 /WEB-INF/views/gongji
	 *    로한다. 공지 저장 매핑주소는 gongji_insert_ok로 한다.공지 목록 매핑주소는 gongji_list로 한다.
	 *    다. 공지 수정폼 뷰페이지 gongji_update.jsp를 작성한다. 물론 유효성 검증 처리 한다. 공지 수정 완료 
	 *    매핑주소는 gongji_update_ok로 한다. 공지 수정폼 매핑주소는 gongji_update로 한다.   
	 *    라. 공지 내용보기에서는 조회수증가와 함께 GongjiServiceImpl.java에서 스프링의 aop를 통한 트랜잭션 
	 *    처리를 한다. 내용보기 매핑주소는 gongji_cont로 한다.
	 *    마.gongji_cont.jsp에서 삭제 버튼을 클릭하면 자바스크립트 어떤함수를 사용하여 삭제유무 창 띄운다음 확인 버튼을
	 *    클릭하면 삭제 처리한다. 취소를 클릭하면 현재창에 그대로 있게 한다.삭제 매핑주소는 gongji_del로 한다.
	 *  7.공지목록에서 페이징도 한다.  
	 *  8.공지목록에서 등록날짜 출력할 때 JSTL를 사용해서 년월일만 나오게 한다.
	 */

	@Autowired
	private GongjiService gongjiService;

	//공지 글쓰기 폼
	@GetMapping("/gongji_insert") //get으로 접근하는 매핑주소를 처리. gongji_insert 매핑주소 등록
	public ModelAndView gongji_insert(HttpServletRequest request) {
		int page=1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			//쪽번호를 받아서 정수 숫자로 변경해서 저장
		}
		ModelAndView wm=new ModelAndView();
		wm.addObject("page",page);//페이징에서 내가본 쪽번호로 바로 이동하기 위한 책갈피 기능을 구현하기 
		//위해서 page키이름에 쪽번호를 저장해서 전달한다.
		wm.setViewName("gongji/gongji_insert");
		return wm;
	}//gongji_insert() =>GET방식

	//공지 저장
	@PostMapping("/gongji_insert_ok") //post로 접근하는 매핑주소를 처리	
	public ModelAndView guest_insert_ok(GongjiVO g) {
		/* GongjiVO.java의 변수명과 gongji_insert.jsp의 네임피라미터 이름이 같으면 GongjiVO g라고만 해도 g객체에 공지 작성자, 공지 제목,공지 내용이 저장되어 있다. 
		 */
		this.gongjiService.insertGongji(g);//공지 저장

		return new ModelAndView("redirect:/gongji/gongji_list");
		//게시물 목록보기 매핑주소인 gongji_list로 이동
		/*  ModelAndView 생성자 인자값으로 올수 있는 것 종류)
		 *   1.뷰페이지 파일명과 경로
		 *   2.redirect:/를 사용해서 매핑주소
		 */
	}//guest_insert_ok() => POST방식

	//공지 목록
	@RequestMapping("/gongji_list") //get or post로 접근하는 매핑주소를 처리,gongji_list매핑주소 등록
	public String gongji_list(Model listM,HttpServletRequest request,
			@ModelAttribute GongjiVO g) {

		/* 페이징에 관련된 것 시작*/
		int page=1;//현재 쪽번호
		int limit=10;//한 페이지에 보여지는 목록개수
		if(request.getParameter("page") != null) {
			//get으로 전달된 쪽번호가 있는 경우 실행
			page=Integer.parseInt(request.getParameter("page"));
		}
		g.setStartrow((page-1)*10+1);//시작 행번호
		g.setEndrow(g.getStartrow()+limit-1);//끝 행번호
		/* 페이징 관련된 부분 끝 */


		int totalCount = this.gongjiService.getTotalCount();//총 레코드 개수
		List<GuestVO> glist = this.gongjiService.getGongjiList(g);//게시물 목록

		/*페이징 연산 시작 */
		int maxpage = (int)((double)totalCount/limit+0.95);//총페이지수
		int startpage = (((int)((double)page/10+0.9))-1)*10+1;//현재 페이지에 보여질 시작페이지
		int endpage = maxpage;//현재 페이지에 보여질 마지막 페이지

		if(endpage>startpage+10-1) endpage=startpage+10-1;
		//마지막페이지>시작페이지+10-1     마지막페이지=시작페이지+10-1
		/* 페이징 연산 끝 */

		listM.addAttribute("totalCount",totalCount);//totalCount키이름에 총 레코드 개수 저장
		listM.addAttribute("glist",glist);//glist키이름에 목록 저장
		listM.addAttribute("startpage",startpage);//시작페이지 저장
		listM.addAttribute("endpage",endpage);//마지막 페이지
		listM.addAttribute("maxpage",maxpage);//총페이지
		listM.addAttribute("page",page);//현재 쪽번호 

		return "gongji/gongji_list";//뷰페이지 경로(뷰리졸브 경로)=> /WEB-INF/views/gongji/gongji_list.
		//jsp
	}//gongji_list()

	//조회수 증가와 내용보기
	@GetMapping("/gongji_cont") //get으로 접근하는 매핑주소를 처리, gongji_cont매핑주소 등록
	public ModelAndView gongji_cont(@RequestParam("gno") int gno, int page) {
		/* @RequestParam("gno") 스프링 애노테이션은 서블릿 자바의 request.getParameter("gno")와 기능이
		 * 같다. 즉 gno피라미터이름에 담겨져서 전달된 번호값을 가져온다. int page만 사용해서 쪽번호를 받는다.
		 */
		GongjiVO gc=this.gongjiService.getGongjiCont(gno);//내용보기+조회수 증가
		String gcont=gc.getGongji_cont().replace("\n","<br>");//textarea 입력박스에서 엔터키를 친 부분을
		//줄바꿈 처리한다.

		ModelAndView cm=new ModelAndView("gongji/gongji_cont");//생성자 인자값으로 뷰페이지 경로 설정
		//=> /WEB-INF/views/gongji/gongji_cont.jsp
		cm.addObject("gc",gc);//gc키이름에 gc객체 저장
		cm.addObject("gcont",gcont);
		cm.addObject("page",page);//페이징에서 책갈피 기능을 구현하기 위해서 page키이름에 쪽번호 저장

		return cm;
	}//gongji_cont()

	//공지 수정폼
	@RequestMapping("/gongji_update")
	public ModelAndView gongji_update(int gno,int page) {
		GongjiVO eb=this.gongjiService.getGongjiCont2(gno);//조회수는 증가 안되고 내용보기만 처리 

		ModelAndView em=new ModelAndView();
		em.addObject("eb",eb);
		em.addObject("page",page);
		em.setViewName("gongji/gongji_update");//메서드 인자값으로 뷰리졸브 경로 설정=> /WEB-INF/views/
		//gongji/gongji_upate.jsp
		return em;
	}//gongji_update()

	//공지 수정완료
	@PostMapping("/gongji_update_ok") //post로 접근하는 매핑주소를 처리
	public String gongji_update_ok(@ModelAttribute GongjiVO eb,int page,
			Model m) {
		/*@ModelAttribute GongjiVO eb로 처리하면 빈클래스 변수명과 네임피라미터 이름이 같으면 eb객체에 글번호, 
		 * 수정한 글쓴이,글제목,글내용까지 저장되어 있다. 하지만 page는 빈클래스의 변수명으로 정의 안되어 있어서 별도로
		 * 가져와야 한다.
		 */
		this.gongjiService.updateGongji(eb);//번호를 기준으로 글쓴이,글제목,글내용을 수정
		m.addAttribute("page",page);//책갈피 기능때문에 page키이름에 쪽번호 저장
		m.addAttribute("gno",eb.getGongji_no());
		return "redirect:/gongji/gongji_cont";//gongji_cont?page=쪽번호&gno=번호 형태의
		//get방식으로 2개의 피라미터 값이 전달된다.    	
	}//gongji_update_ok()
	
	@GetMapping("/gongji_del")
	public ModelAndView gongji_del(int gno,int page) {
		this.gongjiService.delGongji(gno);//번호를 기준으로 게시물 삭제		
		return new ModelAndView("redirect:/gongji/gongji_list?page="+page);
	}
}
