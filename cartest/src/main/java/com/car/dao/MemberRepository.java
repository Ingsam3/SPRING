package com.car.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.car.vo.CarMemberVO;

public interface MemberRepository extends JpaRepository<CarMemberVO, String> {

	
	/*
	@Query("select m from MemberVO m where m.mem_id=?1 and m.mem_name=?2")
	public CarMemberVO pwdFind(String id,String name); //아이디와 회원이름을 기준으로 디비로 부터 비번을 검색
	
	@Modifying //@Query 애노테이션은 select문만 가능하지만 @Modifying을 이용해서 DML(insert,update,delete)문 작업 처리가 가능하다.
	@Query("update MemberVO m set m.mem_pwd=?1 where m.mem_id=?2") //?1은 첫번째로 전달되는 피라미터 값 ,?2은 두번째로 전달된  피라미터 값
	//JPQL(JPA에서 사용하는 Query Language => Java Persistence Query Language의 약어)이다.
	//JPQL은 테이블 대신 엔티빈 클래스를 이용하고,테이블 컬럼대신 엔티티빈 클래스의 변수 즉 속성을 이용한다. 
	public void updatePwd(String pwd,String id); //아이디를 기준으로 암호화 된 임시 비번을 수정		
	
	@Modifying 
	@Query("update MemberVO m set m.mem_pwd=?1, m.mem_name=?2, m.mem_zip=?3, m.mem_zip2=?4, m.mem_addr=?5,"
			+" m.mem_addr2=?6, mem_phone01=?7, mem_phone02=?8, mem_phone03=?9, m.mail_id=?10, m.mail_domain=?11 where m.mem_id=?12")
	public void updateMember(String pwd,String name,String zip,String zip2,String addr,String addr2,String phone01,String phone02,
			String phone03,String mail_id,String mail_domain,String id); //회원 정보 수정	
	*/
	
	
}
