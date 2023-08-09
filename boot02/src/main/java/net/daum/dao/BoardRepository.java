package net.daum.dao;

import org.springframework.data.repository.CrudRepository;

import net.daum.vo.BoardVO;

public interface BoardRepository extends CrudRepository<BoardVO, Integer> {
	//<엔티티 빈클래스 명, 빈클래스 유일 식별키 @ID로 변수명 자료형의 참조 타입>
	//제네릭은 아이디 기본키 타입 못 넣음 - > Integer 넣음
	// ==> 이 설정 후에 쿼리문 수행 가능
	

}
