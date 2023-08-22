package net.daum.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageVO { //페이징과 검색기능 관련 빈클래스
	//페이진 관련 변수
	private int startrow; //시작행번호
	private int endtrow; //끝행번호
	
	//검색기능 관련변수
	//검색기능 관련변수
	private String fund_filed; //검색필드
	private String fund_name; //검색어
}
