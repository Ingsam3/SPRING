package net.daum.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="membre")
//toString ()매서드를 호출할 때 member 변수를 재외 시켜서 호출 안 되게 한다
@Entity
@SequenceGenerator(
	//시퀀스 생성기를 설정하는 애노테이션
	name="bno_seq2_gname", //시퀀스 제너레이터 이름
	sequenceName = "bno_seq3", //시퀀스 이름
	initialValue = 1 , //시작값
	allocationSize = 1 // 기본 값 50, 증가값 1
)
@Table(name="tbl_profile")//tbl_profile 테이블이 생성
@EqualsAndHashCode(of="fname")
public class Profile {
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE , //사용할 전략을 시퀀스로 선택
			generator ="bno_seq3_gname" // 시퀀스 생성에서 설정해 놓은 시퀀스 제너레이터 이름
			)
	private int fno; // 번호 -> 유일한 번호 값
	private String fname; // 회원 프로필 사진 파일명
	private boolean current2; //현재 사용중인 프로필 사진은 true 사용하지 않으면 false
	
	
	@ManyToOne // 다대일 연관 관계
	private MemberVO member; 
	//foregin key(외래키 -> 주종관계 -> Fetch Join문을 만들기 위해서)
	//tbl_members 테이블의 uid2컬럼 회원 아이디 값만 저장 됨
	
	
}
