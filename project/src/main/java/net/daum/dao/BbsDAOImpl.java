package net.daum.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.BbsVO;
import net.daum.vo.PageVO;

@Repository
public class BbsDAOImpl implements BbsDAO {

	@Autowired
	private BbsRepository bbsRepo;//JPA를 통한 하이버네이트로 쿼리문 수행할려고 자동의존성 주입
	
	@Autowired
	private SqlSession sqlSession; //mybatis로 통한 쿼리문 수행할려고 자동의존성 주입

	@Override
	public void insertBbs(BbsVO b) {
		//this.sqlSession.insert("bbs_in", b);
		/* bbs_in은 mybatis bbs.xml매퍼태그에서 설정할 유일한 아이디명이다.
		 * mybatis에서 insert()메서드는 레코드를 저장해 준다.
		 */
		int bbs_no=this.sqlSession.selectOne("bbsNoseq_Find");//시퀀스 다음 번호값을 구함.
		//mybatis에서는 selectOne()메서드는 단 한개의 레코드값만 반환, bbs_max_no는 bbs.xml에서
		//설정할 유일한 아이디명
		
		System.out.println("시퀀스 번호:"+bbs_no);
		//b.setBbs_ref(bbs_no+1);//글 그룹번호로 저장
		b.setBbs_ref(bbs_no);//글 그룹번호로 저장
		//b.setBbs_no(bbs_no+1);
		b.setBbs_no(bbs_no);//자료실 번호 값 저장
		
        this.bbsRepo.save(b);//JPA로 하이버네이트를 구동해서 저장함.		
	}//자료실 저장

	@Override
	public int getRowCount(PageVO p) {
		
		return this.sqlSession.selectOne("bbs_cont",p);
	}//검색 전후 레코드 개수

	@Override
	public List<BbsVO> getBbsList(PageVO p) {
		return this.sqlSession.selectList("bbs_list",p);
		//selectList는 하나 이상의 레코드를 검색해서 컬렉션 리스트로 반환
	}//검색전후목록

	@Override
	public void updateHit(int bbs_no) {
		//this.sqlSession.update("bbs_hi",bbs_no); 
		
		System.out.println("조회수 증가 JPA================");
		Optional<BbsVO> bbs_hit = this.bbsRepo.findById(bbs_no);
		
		bbs_hit.ifPresent(bbs_hit2 -> {
			//자료가 있다면 true
			int bbsHit_count=bbs_hit2.getBbs_hit()+1;
			//증가된 조회수
			this.bbsRepo.updateBbsHit(bbs_no, bbsHit_count);
			//JPA로 번호를 기준으로 조회수 증가
		});
		
	}//조회수 증가

	@Override
	public BbsVO getBbsCont(int bbs_no) {
		//return this.sqlSession.selectOne("bbs_co",bbs_no);
		System.out.println("내용보기JPA=======================");
		BbsVO bc = this.bbsRepo.getReferenceById(bbs_no);
		//JPA로 번호에 해당하는 자료를 검색해서 엔티팁민 타입으로 변환
		return bc;
	}//내용보기
}



