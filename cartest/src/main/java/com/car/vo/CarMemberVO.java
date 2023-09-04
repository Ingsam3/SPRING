package com.car.vo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
@Table(name="cid_members")//C_member 생성
@EqualsAndHashCode(of="m_id")
/*equals(), hashcode(),canEquals() 메서드 자동 제공*/
public class CarMemberVO { 

	@Id//식별키 기본키 컬럼
	private String m_id; //회원 아이디
	private String m_pwd; //회원 비밀번호
	private String m_name; //회원 이름
	private String m_email; //회원 이메일
	private String m_phone; //회원 번화번호
	private String m_tel; //통신사
	private String m_birth; //회원 생년월일
	private int m_state; //가입회원이면 1, 탈퇴회원이면 2
	
	
	@CreationTimestamp
	private Timestamp regdate;//등록날짜
	
	
}
