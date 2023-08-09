package net.daum.vo;

import lombok.Data;

@Data
public class AddrVO { //데이터 저장 빈 클래스
	private int addrNo; //번호, 빈클래스의 변수명일 JSON 데이터의 키이름이 된다
	private String sido; //시도
	private String gugun; //구군
	
	

}
