package net.daum.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import net.daum.vo.BoardVO;

public interface BoardRepository extends CrudRepository<BoardVO,Integer> {

	/* 쿼리 메서드란 : 메서드 이름만으로 필요한 쿼리문을 만들어 내는 메서드를 말한다. */
	
	public List<BoardVO> findBoardVOByTitle(String title);//쿼리메서드 중에서 find+엔티티빈
	//클래스명+By+테이블컬럼명()
	
	public Collection<BoardVO> findByWriter(String writer);//쿼리메서드에서 Writer는 빈클래스
	//의 속성인 멤버변수명 => findBy+빈클래스 속성명(멤버변수명) ,작성자로 검색
	
	//작성자에 대한 like % 검색어 % => '%'+검색어+'%'(Containging)
	/* like 검색 쿼리 메서드 형태
	 *  형태                 쿼리 메서드
	 *  검색어+'%'   StartingWith
	 *  '%'+검색어      EndingWith
	 * '%'+검색어+'% Containing
	 */
	public Collection<BoardVO> findByWriterContaining(String writer);
	
	//or 조건 처리 => '%'+제목+'%' + Or + '%' +내용 + '%'
	public Collection<BoardVO> findByTitleContainingOrContentContaining(String title,
			String content);
	
	//title like %?% And Bno > ?
	public Collection<BoardVO> findByTitleContainingAndBnoGreaterThan(String title,
			int bno);
	
	//bno > ? order by bno desc => 게시물 번호가 특정번호보다 큰 게시물을 bno기준으로 내림차순 정렬
	public Collection<BoardVO> findByBnoGreaterThanOrderByBnoDesc(int bno);
	
	@Query("select b from BoardVO b where b.title like %?1% and b.bno > 0 order by "
			+" b.bno desc") //JPQL(JPA에서 사용하는 Query Language)에서는 테이블명 대신 엔티티빈
	//클래스명을 이용하고, 실제 테이블의 컬럼명 대신 엔티티빈의 변수 즉 속성을 사용한다. ?1의 뜻은 첫번째로 전달되
	//는 인자값을 의미한다.
	public List<BoardVO> findByTitle(String title);
	
	@Query("select b from BoardVO b where b.content like %:content% and b.bno>0 "
			+" order by b.bno desc")
	public List<BoardVO> findByContent(@Param("content") String content); //:content
	//는 @Param("content")와 연결된다.
	
	@Query("select b.bno,b.title,b.writer,b.regdate from BoardVO b where b.title "
			+" like %?1% and b.bno > 0 order by b.bno desc")
	//원하는 컬럼만 검색할 때는 반환타입이 컬렉션 제네릭 타입 엔티티빈(BoardVO)타입이 아니라 Object[] 배열이다.
	public List<Object[]> findByTitle2(String title);
}









