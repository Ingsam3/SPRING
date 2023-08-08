package net.daum.vo;

import lombok.Data;

@Data
public class AuthVO {//tbl_member_auth테이블의 컬럼명 레코드값을 가져와서 저장할 빈클래스

	private String userid;
	private String auth;
}
