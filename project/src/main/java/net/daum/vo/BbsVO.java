package net.daum.vo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Entity//엔티티빈 JPA
@SequenceGenerator(//시퀀스 생성기 
		name = "bbs_no_seq_gname", //시퀀스 제너레이터 이름
		sequenceName = "bbs_no_seq", //시퀀스 이름
		initialValue = 1, //시작값
		allocationSize = 1 // 증가값 기본 값 50
		)
@Table(name = "bbs") //bbs 테이블 생성
@EqualsAndHashCode(of="bbs_no")//equals(), hashcode() 메서드 자동 생성
public class BbsVO {//bbs 자료실 테이블 생성과 중간 자료 저장하는 BbsVO 엔티티빈 클래스 = JPA
	@Id //기본키 컬럼
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, //사용할 전략을 시퀀스로 선택
			generator = "bbs_no_seq_gname" //시퀀스 생성기에서 설정해 놓은 시퀀스 제너레이터 이름
			)
	private int bbs_no; //자료실 번호 ->jpa를 통해서 bbs_no 컬럼이 생성, 기본키 됨
	
	private String bbs_name;//글쓴이
	private String bbs_title;//글제목
	private String bbs_pwd;//비번
	private String bbs_cont;//자료실 내용
	private String bbs_file;//첨부 파일 경로와 파일명
	private int bbs_hit; //조회수
	
	//계층형 계단형 자료실 기능을 만들기 위해서 -> 관리자 답변글 기능 추가 컬럼
	private int bbs_ref;//글 그룹 번호(답변글) -> 원본글과 답변글을 묶어주는 역할을 하는 글 그룹번호
	private int bbs_step; //원본글과 답변글을 구분하는 번호값이면서 몇번 째 답변글인지 알려줌
	//원본글이면 0
	private int bbs_level;//답변글 정렬순서
	
	@CreationTimestamp //ORM 하이버네이트 프레임워크의 특별한 기능으로 자료실 다료 등록시점 날짜 값을 기록 
	//mybatis 에서는 작동 안 됨 JPA를 통해서 작동 됨
	 private Timestamp bbs_date;// 등록날짜
	
}
