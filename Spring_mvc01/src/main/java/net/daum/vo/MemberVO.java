package net.daum.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data //setter(),getter(),toString()등 메서드 자동제공
public class MemberVO {//TBL_member테이블의 레코드값 가져와서 저장할 빈클래스

	private String userid;
	private String userpw;
	private String userName; //userName,regDate,updateDate등 빈 변수명은 테이블 컬럼명과 다르다.
	private boolean enabled;
	
	private Date regDate;
	private Date updateDate;
	private List<AuthVO> authList;//권한 목록
}
