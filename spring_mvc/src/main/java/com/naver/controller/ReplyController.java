package com.naver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.naver.service.ReplyService;
import com.naver.vo.ReplyVO;

@RestController // @RestController : 해당 컨트롤러는 REST API서비스 프로그램을 개발할 있게 됨
@RequestMapping("/replies")//컨틀롤러 자체 매핑주소 등록
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	//댓글 등록
	@RequestMapping(value = "",method = RequestMethod.POST )//POST로 접근하는 매핑주소 처리
	public ResponseEntity<String> addReply(@RequestBody ReplyVO vo){
		/*
		 * @RequestBody : JSON -> ReplyVO 객체로 변경해줌
		 * */
		
		ResponseEntity<String> entity = null;
		try {
			this.replyService.addreply(vo);//댓글 등록
			entity=new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			//댓글 저장 성공시 200 정상 상태 코드 반환 
		} catch (Exception e) {
				e.printStackTrace();	
				entity=new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
				//댓글 저장 실패시 예외 에러 메세지 및 나쁜 상태코드 반환 및
		}
		return entity;
	}//addReply
	
	//게시판 번호에 해당하는 댓글목록 =>get 방식
	@RequestMapping(value = "/all/{bno}", produces = "application/json")
	public ResponseEntity<List<ReplyVO>> getReplyList(@PathVariable("bno")int bno) {
		/*@PathVariable("bno") : 매핑주소로부터 게시판 번호값을 추출하는 용도로 활용된다 ->매개변수에 전달
		 * 
		 * */
		
		 ResponseEntity<List<ReplyVO>> entity=null;
		 try {
			entity=new ResponseEntity<>(this.replyService.listReply(bno)
					,HttpStatus.OK); 
			//게시판 번호에 해당하는 댓글 목록이 반환 됨
			 
		} catch (Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		 
		return entity;
	}//getReplyList end
	
	//댓글 수정
	@RequestMapping(value = "/{rno}", method = {RequestMethod.PUT, RequestMethod.PATCH})
	//Put : 전체 자료수정  & PATCH : 일부 자료 수정
	public ResponseEntity<String> editReply(@PathVariable("rno")int rno,
			@RequestBody ReplyVO vo){
		
		ResponseEntity<String> entity =null;
		try {
			vo.setRno(rno);//댓글번호 저장
			this.replyService.updateReply(vo);//댓글수정
			entity=new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	return entity;	
	}//editReply end
	
	//댓글 삭제
	@RequestMapping(value = "/{rno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delReply(@PathVariable("rno")int rno){
		ResponseEntity<String> entity =null;
		try {
			this.replyService.delReply(rno);//댓글삭제
			entity=new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;	
	}//delReply end
	
	
	
	
}
