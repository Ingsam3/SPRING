package net.daum.vo;

import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.swing.SwingContainer;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(//오라클에서만 사용 mysql등에서는 사용 X
		name = "zip_no_seq_gename" , //시퀀스 제너레이터 이름
		sequenceName = "zip_no_seq", //시퀀스 이름 
		initialValue = 1, //시퀀스 시작값
		allocationSize = 1 //시퀀스 증가값, 기본값 = 50
		)
@Table(name = "zipcode")//테이블명
@EqualsAndHashCode(of = "no")
public class ZipCodeVO { //우편번호, 주소 등 저장할 엔티티빈 클래스

	@Id //기본키
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, //사용할 전략을 시퀀스로 선택
			generator = "zip_no_seq_gename" //시퀀스 제너레이터 이름
			)
	private int no; 
	
	private String zipcode;///우편번호
	private String sido;//시도
	private String gugun;//구군
	private String gil; //길
	private String bunji; //나머지 주소
	
	
}
