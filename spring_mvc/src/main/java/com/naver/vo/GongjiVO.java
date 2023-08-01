package com.naver.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GongjiVO {//TBL_gongji 테이블의 컬럼명과 일치하는 빈클래스 변수명을 정의
	
	private int gongji_no;
	private String gongji_name;
	private String gongji_title;
	private String gongji_cont;
	private int gongji_hit;
	private String gongji_date;
	
	//페이징 관련 변수
	private int startrow;//시작 행 번호
	private int endrow; //끝 행 번호

}
