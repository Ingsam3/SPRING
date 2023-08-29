package com.car.vo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@Table(name="C_member")//C_member 생성
@EqualsAndHashCode(of="m_id")
/*equals(), hashcode(),canEquals() 메서드 자동 제공*/
@SequenceGenerator( //시퀀스 생성기를 설정하는 애노테이션
		name=" car_mem_seq", // 시퀀스 제너레이터 이름
		sequenceName = "carmem_seq", //시퀀스 이름
		initialValue = 1, //시작값
		allocationSize = 1 // 기본값 - 50, 증가값 - 1
		)
public class MemberVO { //관리자 엔티티빈 클래스

	private int m_no;//번호값
	@Id//식별키 기본키 컬럼
	private String m_id; 
	private String m_pwd; 
	private String m_name; 
	private String m_email; 
	private String m_phone; 
	private String m_tel; 
	private String m_birth; 
	
	@CreationTimestamp//하이버네이트 - 등록시점의 날짜 값을 기록함(mybatis는 구동 안 됨)
	private Timestamp regdate;//등록날짜 =>JPA 로 레코드 저장시 실행되어 등록시점 날짜값이 기록
	
	
	
}
