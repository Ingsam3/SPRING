package com.naver.vo;

import lombok.Data;

//댓글 데이터 저장빈 클래스 => TBL_REPLY 테이블의 컬럼명과 일치
@Data
public class ReplyVO {

	private int rno;//댓글번호
	private int bno;//게시판번호
	private String replyer;//댓글작성자
	private String replytext;//댓글내용
	private String regdate;//등록날짜
	private String updatedate;//수정날짜
	
}
