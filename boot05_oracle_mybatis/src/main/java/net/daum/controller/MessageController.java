package net.daum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.daum.service.MessageService;
import net.daum.vo.MessageVO;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	//메세지 추가
	
	@RequestMapping(value = "/message_write", method = RequestMethod.POST)
	//POST로 접근하는 매핑주소처리 
	public ResponseEntity<String> message_write(@RequestBody MessageVO vo){
		/*
		  @RequestBody MessageVO vo: 전송되는 JSON 키,값을 MessageVO 객체타입으로 변환시켜준다 
		 */
		//반환타입 객체 생성
		ResponseEntity<String> entity=null;
		
		try {
			this.messageService.insertMessage(vo);//메시지 추가
			entity =new ResponseEntity<>("SUCESS",HttpStatus.OK);
			//성공시
		} catch (Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
			//예외에러 발생 시 예외에러 메세지와 나쁜 상태 코드 반환
		}
		return entity;
		
	}
	
}
