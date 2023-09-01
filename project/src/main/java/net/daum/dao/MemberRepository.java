package net.daum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.daum.vo.MemberVO;

public interface MemberRepository extends JpaRepository<MemberVO, String> {

	@Query("select m from MemberVO m where m.mem_id=?1 and m.mem_name=?2")
	public MemberVO pwdFind(String id,String name); //아이디와 회원이름을 기준으로 오라클로 부터
	//비번을 검색
	
	@Modifying //@Query 애노테이션은 select문만 가능하지만 @Modifying을 이용해서 DML(insert,update
	//,delete)문 sql 처리가 가능하게 된다.
	@Query("update MemberVO m set m.mem_pwd=?1 where m.mem_id=?2")
	//?1은 첫번째로 전달되어지는 인자값, ?2는 두번째로 전달되어지는 인자값
	//JPQL(JPA에서 사용하는 query language 이다.(Java Persistence Query Language의 약어)
	//JPQL에서는 실제 테이블명 대신 엔티티빈 클래스명을 사용하고,실제 컬럼명 대신 엔티티빈의 변수 즉 속성명을 사용
	//한다.
	public void updatePwd(String pwd,String id);//아이디를 기준으로 암호화 된 임시비번을 수정
	
	@Query("select m from MemberVO m where m.mem_id=?1 and m.mem_state=1")
	public MemberVO loginCheck(String id);//아이디와 가입 회원 1인 경우만 로그인 인증 처리
}
