package net.daum.vo;

import lombok.Data;

@Data //setter(). getter(), tostring() 등 메서드 자동 제공
public class UeserVO { //tbl_user 테이블과 일치하는 컬럼

	private String uid2; //회원아이디
	private String upw; //회원비번
	private String uname; //회우너이름
	private int upoint; //보낸메세지 하나당 포인트 점수 10점 업데이트
}
