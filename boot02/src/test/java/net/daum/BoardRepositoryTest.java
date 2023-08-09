package net.daum;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.daum.dao.BoardRepository;
import net.daum.vo.BoardVO;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testInsertBoard() {
	/*	BoardVO board = new BoardVO();
		
		board.setWriter("홍길동");
		board.setTitle("게시판 제목입니다");
		board.setContent("게시판 내용입니다");
		
		this.boardRepo.save(board); //게시판 저장 */
		
	}//게시판에 자료저장
	
	@Test
	public void testRedBoard() {
		/*
		Optional<BoardVO> b = this.boardRepo.findById(2); //2번 레코드 값 검색
		System.out.println(b.toString());*/
		
	}//게시판 읽기
	
	
	@Test
	public void testUpdateBord() {
		/*Optional<BoardVO> eb = this.boardRepo.findById(2); //2번 데이터 검색
		
		eb.ifPresent(ebBoard -> { //람다식
			ebBoard.setWriter("수정 홍길동");
			ebBoard.setTitle("수정 게시판 제목");
			ebBoard.setContent("수정 게시판 내용");
			
			System.out.println("2번 레코드의 작성자, 제목, 내용을 수정 => ");
			this.boardRepo.save(ebBoard);//게시판 수정하고 수정 된 레코드 값을 다시 검색
			
		});*/
		
	}//게시판 수정
	
	
	//1번 레코드 삭제
	@Test 
	public void testDelBoard() {
		System.out.println("JPA 엔티티빈 레코드 삭제");
		boardRepo.deleteById(1); 
	}
	
	
	
	
}
