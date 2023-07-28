package com.naver.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageVO { //tbl_messege 테이블 컬럼명과일치하는 데이터 저장 빈클래스

	private int mid; 
	private String targetid; //외래키 설정
	private String sender; //메세지 보낸사람
	private String message; // 보낸 메세지
	private String senddate; //보낸 날짜
	
}
