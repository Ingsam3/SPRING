package net.daum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.daum.vo.BbsVO;

public interface AdminBbsRepository extends JpaRepository<BbsVO, Integer> {

	@Modifying
	/*@Query 애노테이션은 select 검색 쿼리문만 가능하지 @Modifying 은
	 DMI(insert, update, delete)문 작업 처리도 가능하다
	 */
	@Query("update BbsVO b set b.bbs_name=?1, b.bbs_title=?2, b.bbs_cont=?3,"
			+ " b.bbs_file=?4 where b.bbs_no=?5")
	//=?1은 첫번째로 전달되어 지는 인자 값 , =?2는 두번 째로 전달되어지는 인자값
	//JPQL : JPA를 사용하는 쿼리문
	//JPQL 에서는 실제 테이블 명 대신 엔티티빈 클래스를 사용하고 실제 컬럼명대신 엔티티빈 클래스명 변수를 사용한다
	public void adminEditBbs(String name, String title, String cont, String fileName,
			int bno); //인터페이스 abstract가 생략된 추상메서드 사용
	
}
