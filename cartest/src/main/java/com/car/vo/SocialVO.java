package com.car.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Id;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;

@Entity 
@Table(name="social")//C_member 생성

@SequenceGenerator( //시퀀스 생성기를 설정하는 애노테이션
		name=" socail_mem_seq", // 시퀀스 제너레이터 이름
		sequenceName = "socail_seq", //시퀀스 이름
		initialValue = 1, //시작값
		allocationSize = 1 // 기본값 - 50, 증가값 - 1
		)
@Builder
public class SocialVO { //SocialLogin 유저 정보 테이블

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	//프로젝트에 연결된 DB의 넘버링 전략을 따름 
	private Long Id;//시퀀스
	
	@Column(nullable = false, length = 20) //null X
	private String username; // 아이디
	
	@Column(nullable = false, length = 200) //null X
	private String password; 
	
	@Column(nullable = false, length = 50) //null X
	private String email; 
	
	@ColumnDefault(" 'user' ")
	private String role; //권한
	
	@CreationTimestamp // 시간 자동 입력
	private Timestamp createDate;//가입날짜
	
	//전화번호는 권한 승인 되어야 사용가능
	
	
	
	
	
}
