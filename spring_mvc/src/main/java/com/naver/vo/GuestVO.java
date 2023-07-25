package com.naver.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GuestVO {//데이터 저장빈 클래스
	
	private int gno;
	private String gname;
	private String gtitle;
	private String gcont;
	private int ghit;
	private String gdate;
	
	//페이징
    private int startrow;
    private int endrow;
    
}
