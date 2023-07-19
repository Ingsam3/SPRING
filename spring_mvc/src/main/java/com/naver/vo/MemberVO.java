package com.naver.vo;
//중간 데이터 저장 빈 클래스 =>테이블 컬럼명과 일치하는 빈클래스 변수명을 정의
public class MemberVO {
	private String userid; //회원아이디
	private String userpw; 
	private String username; 
	private String email; 
	private String regdate; //가입날짜
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
