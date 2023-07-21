package com.naver.vo;

import lombok.Getter;
import lombok.Setter;

@Setter //setter()메서드 자동제공
@Getter //getter()메서드 자동제공
public class BoardVO { /* tbl_board테이블의 컬럼명과 데이터 저장 빈 클래스 변수명이 일치하는 클래스 정의 */
	//lombok.jar 라이브러리를 추가해서 setter(),getter()메서드를 생략한다.
	
	private int bno;//게시판 번호
	private String writer; //글쓴이
	private String title;//글제목
	private String content; //글내용
	private int viewcnt; //조회수
	private String regdate; //등록날짜
	
	//페이징 =>쪽나누기
	private int startrow; //시작행 번호
	private int endrow; //끝행 번호
}
