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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.naver.service.GuestService;
import com.naver.vo.GuestVO;

@Controller //방명록 컨트롤러 클래스
@RequestMapping("/guest/*")
public class GuestController {

	@Autowired
	private GuestService guestService;

	//게시판 글쓰기 폼
	@RequestMapping(value="/guest_write",method=RequestMethod.GET) //get으로 접근하는 매핑주소를 처리
	// 매핑주소 등록
	public void guest_write(Model wm, HttpServletRequest request) {
		//리턴타입이 void형이면 매핑주소가 뷰페이지 파일명이 된다.
		//뷰리졸브 경로는 /WEB-INF/views/guest/guest_write.jsp
		int page=1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			//쪽번호를 받아서 정수 숫자로 변경해서 저장
		}
		wm.addAttribute("page",page);//페이징에서 내가본 쪽번호로 바로 이동하기 위한 책갈피 기능을 구현하기 
		//위해서 page키이름에 쪽번호를 저장해서 전달한다.
	}//board_write() =>GET방식

	//게시판 저장
	@RequestMapping(value="/guest_write_ok",method=RequestMethod.POST) //post로 접근하는 매핑주소를 처리	
	public ModelAndView guest_write_ok(GuestVO g,RedirectAttributes rttr) {
		//전달인자 개수가 다른 메서드 오버로딩
		/* GuestVO.java의 변수명과 guest_write.jsp의 네임피라미터 이름이 같으면 GuestVO g라고만 해도 g객체에 글쓴
		 * 이,글제목,글내용이 저장되어 있다. 
		 */
		this.guestService.insertGuest(g);//게시판 저장
		rttr.addFlashAttribute("msg","success");
		/* 백엔드 서버의 스프링 컨트롤러 에서 다른 매핑주소로 msg키이름에 success문자열을 담아서 값을 전달할 때
		 * 사용한다. 이 방법은 웹주소창에 값 노출이 안된다.보안상 좋다.
		 */
		return new ModelAndView("redirect:/guest/guest_list");
		//게시물 목록보기 매핑주소인 board_list로 이동
		/*  ModelAndView 생성자 인자값으로 올수 있는 것 종류)
		 *   1.뷰페이지 파일명과 경로
		 *   2.redirect:/를 사용해서 매핑주소
		 */
	}//guest_write_ok() => POST방식

	//방명록 목록
	@RequestMapping("/guest_list") //get or post로 접근하는 매핑주소를 처리,guest_list매핑주소 등록
	public String guest_list(Model listM,HttpServletRequest request,
			@ModelAttribute GuestVO g) {

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


		int totalCount = this.guestService.getTotalCount();//총 레코드 개수
		List<GuestVO> glist = this.guestService.getGuestList(g);//게시물 목록

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

		return "guest/guest_list";//뷰페이지 경로(뷰리졸브 경로)=> /WEB-INF/views/guest/guest_list.
		//jsp
	}//board_list()

	@GetMapping("/guest_cont") //get으로 접근하는 매핑주소를 처리, guest_cont매핑주소 등록
	public ModelAndView guest_cont(@RequestParam("gno") int gno, int page) {
		/* @RequestParam("gno") 스프링 애노테이션은 서블릿 자바의 request.getParameter("gno")와 기능이
		 * 같다. 즉 gno피라미터이름에 담겨져서 전달된 번호값을 가져온다. int page만 사용해서 쪽번호를 받는다.
		 */
		GuestVO gc=this.guestService.getGuestCont(gno);//내용보기+조회수 증가
		String gcont=gc.getGcont().replace("\n","<br>");//textarea 입력박스에서 엔터키를 친 부분을
		//줄바꿈 처리한다.

		ModelAndView cm=new ModelAndView("guest/guest_cont");//생성자 인자값으로 뷰페이지 경로 설정
		//=> /WEB-INF/views/guest/guest_cont.jsp
		cm.addObject("gc",gc);//gc키이름에 gc객체 저장
		cm.addObject("gcont",gcont);
		cm.addObject("page",page);//페이징에서 책갈피 기능을 구현하기 위해서 page키이름에 쪽번호 저장

		return cm;
	}//guest_cont()

	//게시판 수정폼
	@RequestMapping("/guest_edit")
	public ModelAndView guest_edit(int gno,int page) {
		GuestVO eb=this.guestService.getBoardCont2(gno);//조회수는 증가 안되고 내용보기만 처리 

		ModelAndView em=new ModelAndView();
		em.addObject("eb",eb);
		em.addObject("page",page);
		em.setViewName("guest/guest_edit");//메서드 인자값으로 뷰리졸브 경로 설정=> /WEB-INF/views/
		//guest/guest_edit.jsp
		return em;
	}//board_edit()

	//게시판 수정완료
	@PostMapping("/guest_edit_ok") //post로 접근하는 매핑주소를 처리
	public String guest_edit_ok(@ModelAttribute GuestVO eb,int page,
			Model m) {
		/*@ModelAttribute GuestVO eb로 처리하면 빈클래스 변수명과 네임피라미터 이름이 같으면 eb객체에 글번호, 
		 * 수정한 글쓴이,글제목,글내용까지 저장되어 있다. 하지만 page는 빈클래스의 변수명으로 정의 안되어 있어서 별도로
		 * 가져와야 한다.
		 */
		this.guestService.editGuest(eb);//번호를 기준으로 글쓴이,글제목,글내용을 수정
		m.addAttribute("page",page);//책갈피 기능때문에 page키이름에 쪽번호 저장
		m.addAttribute("gno",eb.getGno());
		return "redirect:/guest/guest_cont";//guest_cont?page=쪽번호&gno=번호 형태의
		//get방식으로 2개의 피라미터 값이 전달된다.    	
	}//board_edit_ok()

	//방명록 삭제
	@GetMapping("/guest_del")
	public ModelAndView guest_del(int gno,int page,RedirectAttributes rttr) {
		this.guestService.delGuest(gno);//번호를 기준으로 게시물 삭제
		rttr.addFlashAttribute("msg","success");
		return new ModelAndView("redirect:/guest/guest_list?page="+page);
	}//board_del()
}
