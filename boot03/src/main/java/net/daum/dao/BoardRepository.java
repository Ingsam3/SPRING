package net.daum.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import net.daum.vo.BoardVO;

public interface BoardRepository extends CrudRepository<BoardVO, Integer> {

	/*쿼리메서드란 : 메서드 이름만으로 필요한 쿼리문을 만들어 내는 메서드를 말한다 */
	public List<BoardVO> findBoardVOByTitle(String title);
	//클래스명 +By +테이블 컬럼 명()
	
	
	public Collection<BoardVO> findByWriter(String writer);
	//쿼리메서드에서 Writer라는 빈클래스의 속성 멤버 변수 명 = >findBy+빈클래스 속성명(멤버 변수명), 작성자로 검색
	
	//작성자에 대한 like % 검색어 % => '%' + 검색어 + '%' 
	
	
	public Collection<BoardVO> findByWriterContaining(String writer);
	
	
	//or 조건절 처리 => '%'+제목+'%' + Or + '%' + 내용 + '%'
	public Collection<BoardVO> findByTitleContainingOrContentContaining
	(String title,String content);
	
	
	//title like %?% AND Bno > ?
	public Collection<BoardVO> findByTitleContainingAndBnoGreaterThan
	(String title, int bno);
	
	
	
	//bno > order by bno desc => 게시물 번호가 특정 번호보다 큰 세기물을 bno 기준으로 내림차순 정렬
	public Collection<BoardVO> findByBnoGreaterThanOrderByBnoDesc(int bno);
	
	
	@Query("select b from BoardVO b where b.title like %?1% and b.bno > 0 order by"
			+ "b.bno desc")
	public List<BoardVO> findByTitle(String title);
	//JPQL (JPA에서 사용하는 쿼리 언어)에서는 테이블 명 대신 엔티티빈 클래스명을 이용하고
	//실제 테이블 컬럼명 대신 엔티티빈의 변수 즉, 속성을 사용한다
	//?1은 첫번째로 전달되는 인자을 뜻함
	
	@Query("select b from BoardVO b where b.content like %:content% and b.bno>0"
			+"order by b.bno desc")
	public List<BoardVO> findByContent(@Param("content") String content);
	//content 는 @Param ("content")와 연결된다.
	
	
	@Query("select b.bno, b.title,  b.writer, b.regdate from BoardVO b where "
			+ "b.title" +" like %1% and b.bno >0 0 order by b.bno desc")
	//원하는 컬럼만 검색할 때는 반환타입이 컬렉션 제네릭 타입이 아니라 Object[] 배열이다.
	public List<Object[]> findByTitle2(String title);
	
	
}
