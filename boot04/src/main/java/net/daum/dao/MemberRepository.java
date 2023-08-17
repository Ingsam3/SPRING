package net.daum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import net.daum.vo.MemberVO;

public interface MemberRepository extends CrudRepository<MemberVO, String> {
	//T : 가져올 데이터   & ID : 아이디 식별키 타입 (private String uid2;의 타입인 string)

	@Query("select m.uid2,count(p) from MemberVO m left outer join Profile p "
			+ " on m.uid2 = p.member where m.uid2 = ?1 group by m")
	/*JPQL문 =?> tbl_members 테이블에 레코드가 있거나 
	tbl_profile 테이블에는 레코드가 없는 경우
	outer join 을 한다. 스프링 부트 2.0 이상과 하이버네이트 5.2.x버전 이후부터는 
	참조 관계 없이도 lerf outer join 이 가능하다
	JPQL문은 실제 테이블 명 대신 엔티티빈 클래스명을 사용한다
	Fetch Join 문  
	 */
	public List<Object[]> getMemberVOWithProfileCount(String uid);
	//회원 아이디와 프로필 사진 개수
	
	@Query("select m,p from MemberVO m left outer join Profile p on m.uid2=p.member "
			+" where m.uid2=?1 and p.current2=true")
	//회원 아이디 정보와 현재 사용중인 프로필 사진 정보
	public List<Object[]> getMemberVOWithProfile(String uid);
	
}
