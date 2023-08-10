package net.daum;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.daum.dao.BoardRepository;
import net.daum.vo.BoardVO;

@SpringBootApplication
public class Boot03Application {

	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testInsert20() {
		//샘플 레코드 20개 저장
		for(int i=1; i<=20; i++) {
			BoardVO b= new BoardVO();
			
			b.setWriter("user0"+(i % 10));
			b.setTitle("게시판 제목..:"+i);
			b.setContent("게시판 내용.."+i);
			this.boardRepo.save(b); //게시판 저장
			
		}
	}//testInsert20
	
	//쿼리 메서드에서 제목으로 검색
	@Test
	public void testByTitle() {
		/*java8 이전
		List<BoardVO> blist =this.boardRepo.findBoardVOByTitle("게시판 제목 ..17");
	
		if(blist != null && blist.size() >0) {
			//검색 된 레코드가 있는 경우 
			for(int i=0; i<blist.size(); i++) {
				//size는 컬렉션 원소 개수 반환. 첫 원소값은 1부터 시작 
				System.out.println(blist.get(i));//get()메서드로 원소값을 가져옴
			}
		}else {
			System.out.println("검색된 레코드가 없습니다!");
		}
	
	*/
	
	//java 8이후(람다식 사용)
	this.boardRepo.findBoardVOByTitle("게시판 제목 ... :7")
	.forEach(board -> System.out.println(board));
	
	}//testByTitle
	
	
	@Test//글쓴이로 검색
	public void testByWriter() {
		Collection<BoardVO> blist = this.boardRepo.findByWriter("user00");
		
		blist.forEach(board -> System.out.println(board));
		 
	}//testByWriter
	
	
	@Test//글쓴이(작성자)에서 05가 포함된 게시물 검색 = > '%'+05+'%' like 검색
	public void testByWriterContaining() {
		Collection<BoardVO> blist = this.boardRepo.findByWriterContaining("05");

		blist.forEach(b -> System.out.println(b));

	}//testByWriterContaining
	
	@Test//제목에 '2'가 포함되거나 내용에 '5'가 포함된 경우
	public void testByTitleOrContentContaining() {
		Collection<BoardVO> blist = 
		this.boardRepo.findByTitleContainingOrContentContaining("2", "5");

		blist.forEach(b -> System.out.println(b));

	}//testByTitleOrContentContaining
	
	
	@Test//제목에 '5'가 포함되어 있고 게시물 번호가 20보다 큰 자료 검색
	public void testByTitleAndBno() {
		Collection<BoardVO> blist = 
		this.boardRepo.findByTitleContainingAndBnoGreaterThan("5", 20);

		blist.forEach(b -> System.out.println(b));

	}//testByTitleAndBno
	
	
	
	@Test//게시물 번호가 30 보타 큰 자료를 내림차순 정렬
	public void testByOrderBy() {
		Collection<BoardVO> blist = 
		this.boardRepo.findByBnoGreaterThanOrderByBnoDesc(30);

		blist.forEach(b -> System.out.println(b));

	}//testByOrderBy
	
	@Test // '제목이 들어간 자료 검색'
	public void testByTitle2() {
	
		this.boardRepo.findByTitle("제목").forEach(b->System.out.println(b));

	}//testByTitle2
	
	@Test // @Parm 내용에 대한 검색 처리
	public void testByContext() {
		this.boardRepo.findByContent("내용").forEach(b -> System.out.println(b));
		
	}//testByContext
	
	@Test//원하는 컬럼만 검색
	public void testByTitle3() {
		this.boardRepo.findByTitle2("7")
		.forEach(arr -> System.out.println(Arrays.toString(arr)));
		//반환된 배열을 문자열로 변환하여 출력
	}//testByTitle3
	
	
}
