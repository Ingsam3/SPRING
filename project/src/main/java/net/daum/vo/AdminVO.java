package net.daum.vo;

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
@Table(name="admin")//admin table 생성
@EqualsAndHashCode(of="admin_id")
/*equals(), hashcode(),canEquals() 메서드 자동 제공*/
public class AdminVO { //관리자 엔티티빈 클래스

	private int admin_no;//번호값
	@Id//식별키 기본키 컬럼
	private String admin_id;//관리자 아이디
	private String admin_pwd;//관리자 비번
	private String admin_name;//관리자 이름
	
	
	@CreationTimestamp//하이버네이트 - 등록시점의 날짜 값을 기록함(mybatis는 구동 안 됨)
	private Timestamp admin_date;//등록날짜 =>JPA 로 레코드 저장시 실행되어 등록시점 날짜값이 기록
	
	
	
	
}
