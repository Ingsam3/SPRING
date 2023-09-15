package net.daum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.BoardExService;
import net.daum.vo.BoardDTO;

@Controller
public class BoardExController {
	//레코드 저장
	
	@Autowired
	private BoardExService boardExService;
	
	@RequestMapping("/boardEx_insertOK")
	public ModelAndView boardEx_insertOK(BoardDTO b){
		
		//게시판 저장
		this.boardExService.boardEx_insert(b);
		
		return null;
		
	}

}
