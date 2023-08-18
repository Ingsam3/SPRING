package net.daum.vo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity // JPA 다루는 엔티티빈 클래스
@SequenceGenerator( //시퀀스 생성기를 설정하는 애노테이션
		name=" bno_seq2_gename", // 시퀀스 제너레이터 이름
		sequenceName = "bno_seq2", //시퀀스 이름
		initialValue = 1, //시작값
		allocationSize = 1 // 기본값 - 50, 증가값 - 1
		)
@Table(
		name = "tbl_useraddr2"// tbl_useraddr2 테이블 생성
		)
public class UserAddrVO {
	@Id //기본키 컬럼 -> 식별키(구분키)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, //사용할 전략 시퀀스 선택
			generator = "bno_seq2_gename" //시퀀스 생성기에 설정해놓은 제너레이터 이름 설정
			)
	private int userno; //번호(구분값)
	private String username; //이름
	private String address; //주소
	
	@CreationTimestamp //하이버 네이트에서 제공하는 애노테이션으로 등록날짜 설정
	private Timestamp regdate; //등록날짜
	
}
