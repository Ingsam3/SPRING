package com.car.vo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name="cid_members")
@EqualsAndHashCode(of="m_id")
public class CarMemberVO { 

	@Id//식별키 기본키 컬럼
	private String m_id; //회원 아이디
	
	private String m_pwd; //회원 비밀번호
	private String m_name; //회원 이름
	private String m_email; //회원 이메일
	private String m_phone; //회원 번화번호
	private String m_tel; //통신사
	private String m_birth; //회원 생년월일
	
	private String user_auth; //회원 권한
	private int m_state; //가입회원이면 1, 탈퇴회원이면 2
	
	

	private Timestamp regdate;
	
	 @ManyToMany
	 @JoinTable(
	            name = "user_role",
	            joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private List<Role> roles = new ArrayList<>();
	
	
}
