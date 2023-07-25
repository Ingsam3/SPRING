package com.naver.vo;

import jdk.jfr.internal.PrivateAccess;
import lombok.Data;

//데이터 저장빈 클래스
@Data //setter(), getter(), equals() 메서드 등과 기본샌성자 등 자동제공 (lambok라이브러리)
public class SampleVO {

	private int mno; // 빈클래스 변수명이 json 데이터의 키이름이 된다
	private String firstName; //성
	private String lasrName; //이름
}
