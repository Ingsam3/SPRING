package com.naver.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {

	/*
	 tbl 테이블의 컬럼 명과  데이터 저장 빈 클래스  변수명이 일치하는 클래스 정의
	 lombok.jar 라이브러리 추가해서 setter() & getter() 메서드 생략
	 */
	
	private int bno; //게시판 번호
	private String writer; // 글쓴이
	private String title; //글제목
	private String content; //글내용
	private int viewcnt;//조회수
	private String regdate;//등록날짜
	
	//페이징 : 쪽나누기 
	private int startrow;//시작행번호
	private int entrow;//끝행번호

}
