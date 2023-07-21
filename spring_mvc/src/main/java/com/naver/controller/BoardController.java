package com.naver.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.naver.service.BoardService;
import com.naver.vo.BoardVO;

@Controller //스프링 MVC 게시판 컨트롤러 클래스
@RequestMapping("/board/*") //경로 구분하기 위해서 컨트롤러 자체 매핑주소 /board등록
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//게시판 글쓰기 폼
	@RequestMapping(value="/board_write",method=RequestMethod.GET) //get으로 접근하는 매핑주소를 처리
	// /board_write매핑주소 등록
	public void board_write(Model wm, HttpServletRequest request) {//책갈피
		//리턴타입이 void형이면 매핑주소가 뷰페이지 파일명이 된다.
		//뷰리졸브 경로는 /WEB-INF/views/board/board_write.jsp
		
		int page =1;
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
			//쪽번호 받아서 정수 숫자로 변경해서 저장
		}
		wm.addAttribute("page",page);
		//페이징에서 내가 본 쪽번호로 바로 이동하기 위한 책갈피 기능을 구현하기 위해서 
		
	}//board_write() =>GET방식
	
	//게시판 저장
	@RequestMapping(value="/board_write",method=RequestMethod.POST) //post로 접근하는 매핑주소를 처리
	//동일 컨트롤러에서 같은 매핑주소를 사용하는 경우 메서드 방식으로 구분한다.
	public ModelAndView board_write(BoardVO b,RedirectAttributes rttr) {
		//전달인자 개수가 다른 메서드 오버로딩
		/* BoardVO.java의 변수명과 board_write.jsp의 네임피라미터 이름이 같으면 Board b라고만 해도 b객체에 글쓴
		 * 이,글제목,글내용이 저장되어 있다. 
		 */
		this.boardService.insertBoard(b);//게시판 저장
		rttr.addFlashAttribute("msg","success");
		/* 백엔드 서버의 스프링 컨트롤러 에서 다른 매핑주소로 msg키이름에 success문자열을 담아서 값을 전달할 때
		 * 사용한다. 이 방법은 웹주소창에 값 노출이 안된다.보안상 좋다.
		 */
		return new ModelAndView("redirect:/board/board_list");
		//게시물 목록보기 매핑주소인 board_list로 이동
		/*  ModelAndView 생성자 인자값으로 올수 있는 것 종류)
		 *   1.뷰페이지 파일명과 경로
		 *   2.redirect:/를 사용해서 매핑주소
		 */
	}//board_write() => POST방식
	
	//게시판 목록
	@RequestMapping("/board_list") //get or post로 접근하는 매핑주소를 처리,board_list매핑주소 등록
	public String board_list(Model listM, HttpServletRequest request,
			@ModelAttribute BoardVO b ) {
		
		/*페이징 관련 된 것 시작 */
			int page = 1; //현재쪽번호
			int limit=10; //한페이지에 보여지는 쪽번호 수
			if(request.getParameter("page") !=null) {
				//get으로 전달된 쪽번호가 있는 경우
				page = Integer.parseInt(request.getParameter("page"));
			}
			b.setStartrow((page-1)*10+1); //시작행번호
			b.setEndrow(b.getStartrow()+limit-1); //끝행번호
		
		
		/*페이징 관련 된 것 끝 */
		
		int totalCount = this.boardService.getTotalCount();
		
		List<BoardVO> blist = this.boardService.getBoardList(b); //페이징 부분 : b객체 전달 => change method로 변경
		
		/* 페이징 관련 연산 시작*/
		  int maxpage = (int)((double)totalCount/limit+0.95); //총페이지 수
		  int startpage = (((int)((double)page/10+0.9))-1)*10+1;//현재 페이지에 보여질 시작페이지
		  int endpage = maxpage;//현재페이지에 보일 마지막 페이지
		  
		  if(endpage>startpage+10-1) endpage=startpage+10-1;
		  //마지막페이지>시작페이지+10-1 일 때,  마지막페이지 = 시작페이지+10-1
		 /* 페이징 관련 연산  끝*/
		
		
		listM.addAttribute("totalCount",totalCount);
		//totalCount 키이름에 총 레코드 개수저장
		listM.addAttribute("blist",blist);
		//blist 키이름에 목록 저장
		
		/*페이지 저장*/
		listM.addAttribute("startpage", startpage);//시작페이지 저장
		listM.addAttribute("endpage", endpage);//마지막페이지 저장
		listM.addAttribute("maxpage", maxpage);// 총 페이지저장
		listM.addAttribute("page", page);// 현재 쪽번호
		
		return "board/board_list";//뷰페이지 경로(뷰리졸브 경로)=> /WEB-INF/views/board/board_list.
		//jsp
	}//board_list()
	
	
	@GetMapping("/board_cont")//get으로 접근하는 매핑주소를 처리, board_cont 매핑주소 등록
	
	public ModelAndView board_cont(@RequestParam("bno") int bno, int page) {
		
		//@RequestParam :request.getparameter("bno")와 같음
		//bno 파라미터에 담겨져서 전달된 번호값을 가져온다 int page만 사용하서 쪽번호를 받는다
		BoardVO bc = this.boardService.getBoardCont(bno);
		//내용보기+조회수 증가
		return null;
	} //board_cont
	
	
	
}
