package com.car.controller;

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

import com.car.service.BoardService;
import com.car.vo.BoardVO;

@Controller //스프링 MVC 게시판 컨트롤러 클래스
@RequestMapping("/board/*") //경로 구분하기 위해서 컨트롤러 자체 매핑주소 /board등록
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//게시판 글쓰기 폼
	@RequestMapping(value="/board_write",method=RequestMethod.GET) //get으로 접근하는 매핑주소를 처리
	// /board_write매핑주소 등록
	public void board_write(Model wm, HttpServletRequest request) {
		int page=1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		wm.addAttribute("page",page);	
	}//board_write() =>GET방식
	
	//게시판 저장
	@RequestMapping(value="/board_write",method=RequestMethod.POST)
	public ModelAndView board_write(BoardVO b,RedirectAttributes rttr) {
		this.boardService.insertBoard(b);//게시판 저장
		rttr.addFlashAttribute("msg","success");
		return new ModelAndView("redirect:/board/board_list");
		//게시물 목록보기 매핑주소인 board_list로 이동
	}//board_write() => POST방식
	
	//게시판 목록
	@RequestMapping("/board_list")
	public String board_list(Model listM,HttpServletRequest request,
			@ModelAttribute BoardVO b) {
		
		/* 페이징에 관련된 것 시작*/
			int page=1;	//현재 쪽 번호
			int limit=5;//	한 페이지에 보여지는 목록개수
			if(request.getParameter("page")!= null) {
				//get으로 전달된 쪽 번호가 있는 경우 실행
				page=Integer.parseInt(request.getParameter("page"));
			}
			b.setStartrow((page-1)*5+1);//시작 행번호
			b.setEndrow(b.getStartrow()+limit-1);//끝 행번호
		
		/* 페이징 관련된 부분 끝*/
		
		
		int totalCount = this.boardService.getTotalCount();	//총레코드 개수 (this.생략가능)
		List<BoardVO> blist = this.boardService.getBoardList(b);//게시물 목록
		
		/*페이징 연산 시작*/
		 int maxpage = (int)((double)totalCount/limit+0.95);//총페이지수
		 int startpage = (((int)((double)page/10+0.9))-1)*10+1;	//현재 페이지에 보여질 시작페이지
		 int endpage = maxpage;	//현재 페이지에 보여질 마지막 페이지
		 
		 if(endpage>startpage+10-1) endpage=startpage+10-1;
		 //마지막페이지>시작페이지+10-1	마지막페이지=시작페이지+10-1
		/*페이징 연산 끝*/
		
		
		listM.addAttribute("totalCount",totalCount);	//totalCount키이름에 총 레코드 개수 저장
		listM.addAttribute("blist",blist);				//blist키이름에 목록저장
		listM.addAttribute("startpage",startpage);		//시작페이지 저장
		listM.addAttribute("endpage",endpage);			//마지막 페이지
		listM.addAttribute("maxpage",maxpage);			//총페이지
		listM.addAttribute("page",page);				//현재 쪽번호
		return "board/board_list";			//뷰페이지 경로(뷰리졸브 경로)=> /WEB-INF/views/board/board_list.
		//jsp
	}//board_list()
	
	@GetMapping("/board_cont") //get으로 접근하는 매핑주소를 처리, board_cont매핑주소 등록
	public ModelAndView board_cont(@RequestParam("bno")int bno, int page) {
		// @RequestParam("bno") 스프링 어노테이션은 서블릿 자바의 request.getParameter("bno")와 기능이 같다.
		BoardVO bc = this.boardService.getBoardCont(bno);	//내용보기 + 조회수 증가
		String bcont = bc.getContent().replace("\n", "<br>");//textarea 입력박스에서 엔터키를 친 부분을 줄바꿈처리한다.
		
		ModelAndView cm = new ModelAndView("board/board_cont");//생성자 인자값으로 뷰페이지 경로 설정
		//=> /WEB-INF/views/board/board_cont.jsp
		cm.addObject("bc",bc);//bc키 이름에 bc객체 저장
		cm.addObject("bcont",bcont);
		cm.addObject("page",page);//페이징에서 책갈피 기능을 구현하기 위해서 page키이름에 쪽번호 저장
		return cm;
	}//board_cont()
	
	//게시판 수정폼
	@RequestMapping("/board_edit")
	public ModelAndView board_edit(int bno, int page) {
		BoardVO eb = this.boardService.getBoardCont2(bno);//조회수는 증가 안되고 내용보기만 처리
		
		ModelAndView em = new ModelAndView();
		em.addObject("eb",eb);
		em.addObject("page",page);
		em.setViewName("board/board_edit"); 
		//메서드 인자값으로 뷰리졸브 경로 설정=> /WEB-INF/views/board/board_edit.jsp
		return em;
	}//board_edit()
	
	//게시판 수정완료
	@PostMapping("/board_edit_ok")	//post로 접근하는 매핑주소를 처리
	public String board_edit_ok(@ModelAttribute BoardVO eb, int page,
			Model m) {
		/*@ModelAttribute BoardVO eb로 처리하면 빈클래스 변수명과 네임파라미터 이름이 같으면 eb객체에 글번호,
		 * 수정한 글쓴이, 글제목, 글내용까지 저장되어 있다. 하지만 page는 빈클래스 변수명으로 정의 안되어 있어서 별도로 가져와야 한다.
		 */
		this.boardService.editBoard(eb);//번호를 기준으로 글쓴이, 글제목, 글내용을 수정
		m.addAttribute("page",page);//책갈피 기능 때문에 page키이름에 쪽번호 저장
		m.addAttribute("bno",eb.getBno());
		return "redirect:/board/board_cont";	//board_cont?page=쪽번호&bno=번호 형태의 get방식으로
		//2개의 파라미터 값이 전달된다.
	}//board_edit_ok()
	
	//게시물 삭제
	@GetMapping("/board_del")
	public ModelAndView board_del(int bno, int page, RedirectAttributes rttr) {
		this.boardService.delBoard(bno);	//번호를 기준으로 게시물 삭제
		rttr.addFlashAttribute("msg","success");
		return new ModelAndView("redirect:/board/board_list?page="+page);
	}//board_del()
	
}























