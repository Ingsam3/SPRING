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

@Setter
@Getter
@ToString
@Entity
@Table(name = "member")//member 테이블 생성
@EqualsAndHashCode(of = "mem_id")
//equals(), hashCode(), canEqual() 메서드 자동제공 
public class MemberVO { //회원관리 엔티티빈 클래스
	
	@Id//기본키
	private String mem_id;//회원 아이디
	
	private String mem_pwd;//회원 비번
	private String mem_name;//회원 이름
	private String mem_zip;//우편 번호
	private String mem_zip2;//우편 번호
	//자체 우편검색
	//요즘에는 포털에서 직접 API 가져와 사용함
	private String mem_addr;//주소
	private String mem_addr2;//나머지주소
	private String mem_phone01;//첫번째 폰 번호 =>010
	private String mem_phone02;//두번째 폰 번호 
	private String mem_phone03;//세번째 폰 번호 
	private String mail_id;//메일아이디
	private String mail_domain;//메일도메인 주소
	
	@CreationTimestamp// 하이버네이트의 특별기능으로 회원가입시점의 날짜를 기록,mybatis 에서는 실행 안함
	private Timestamp mem_date; //가입 날짜
	
	private int mem_state;//가입회원이면 1, 탈퇴회원이면 2
	private String mem_delcont;//탈퇴 사유=사이트 리뉴얼시 반영하기 위해

	private Timestamp mem_deldate; //회원 탈퇴 날짜
	

}
