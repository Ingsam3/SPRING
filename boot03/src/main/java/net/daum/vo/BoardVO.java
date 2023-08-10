package net.daum.vo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data//getter(), setter, ToString() 메서드 자동 생성
@Entity //JPA를 다루는 엔티티 빈 클래스
@SequenceGenerator(
	//@SequenceGenerator: 시퀀스 생성기를 설정하는 애너테이션
		name="bno_seq2_gename", //시퀀스 제너레이터 이름(연결 시 사용) 
		sequenceName = "bno_seq2", // 시퀀스 이름
		initialValue = 1, //시퀀스 시작 값
		allocationSize = 1 //시퀀스 증가 값 (기본 값이 50, )
		) 
@Table(
		name="tbl_board2" //테이블 명 
		//컬럼은 빈클래스 변수 명
		)
public class BoardVO { 
	//데이터 저장  엔티티 빈 클래스 => sql 문을 생성하고 테이블 만들고, 시퀀스를 생성
	
	@Id //기본 키 컬럼 => 유일 식별 키
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE, //사용할 전략을 시퀀스로 사용
		generator = "bno_seq2_gename" // 위에서 설정한 제너레이터 이름 넣기
			
	)
	private int bno; //게시판 번호
	private String writer; //게시판 작성자
	private String title; //게시판  제목
	private String content; //게시판  내용
	
	@CreationTimestamp//hibernate의 기능으로 게시물 등록시점 날짜 값을 기록
	private Timestamp redate; //등록날짜
	
	@UpdateTimestamp //hibernate의 기능으로 게시물 수정시점 날짜 값을 기록
	private Timestamp updatedate; //수정날짜

	
}
