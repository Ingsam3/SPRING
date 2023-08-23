package net.daum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.daum.vo.BbsVO;

public interface BbsRepository extends JpaRepository<BbsVO, Integer> {
/* 1.BbsRepository는 사용자 자료실을 JPA로 실행하기 위한 Repository이다.
 * 2.JpaRepository 인터페이스의 부모 인터페이스 중에서 PagingAndSortingRepository에서 페이징과 정렬이
 * 라는 기능을 제공한다.
 * PagingAndSortingRepository의 부모 인터페이스가 CrudRepository이다.
 */
	
	@Modifying // : DML(insert, update, delete)문 처리가능
	@Query("update BbsVO set b.bbs_hit =?2 where b.bbs_no=?1")
	//?2 = 2번째로 전달되는 인자값(증가 조회수 값) / ?1= 1번 째로 전달인자값(파라미터값)
	public void updateBbsHit(int bbs_no, int count);
}
