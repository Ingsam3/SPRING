package net.daum.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Primary;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//lombock
import lombok.ToString;
@Setter
@Getter
@ToString
@EqualsAndHashCode(of= "uid2")
/*equals(), hashCode(), canEqual() 메서드 자동 생성*/
//JAP
@Entity // 엔티티빈
@Table(name = "tbl_members")//tbl?_member 회원테이블 생성

public class MemberVO {

	@Id // 엔티티빈 구별 식별키(기본키)
	private String uid2; // 회원 아이디 값 (uid는 에러난다)
	private String upw; //비밀번호
	private String uname; //회원 이름
}
