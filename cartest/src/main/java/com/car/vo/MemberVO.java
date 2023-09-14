package com.car.vo;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO { 

	//private int m_no;//번호값
	@Id//식별키 기본키 컬럼
	private String m_id; 
	private String m_pwd; 
	private String m_name; 
	private String m_email; 
	private String m_phone; 
	private String m_tel; 
	private String m_birth; 
	
	private String regdate;
	
	
	
}
