package net.daum.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.bytebuddy.asm.Advice.This;
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
		int bbs_no=this.sqlSession.selectOne("bbsNoSeq_Find");//시퀀스 다음 번호값을 구함
		//mybatis에서는 selectOne()메서드는 단 한개의 레코드값만 반환, bbsNoSeq_Find는 bbs.xml에서
		//설정할 유일한 아이디명
		
		
		System.out.println("\n JPA  자료실 저장 ==================>");
		System.out.println("시퀀스 번호:"+bbs_no);
		b.setBbs_ref(bbs_no);//글 그룹번호로 저장
		b.setBbs_no(bbs_no);//자료실 번호값 저장
		
        this.bbsRepo.save(b);//JPA로 하이버네이트를 구동해서 저장함.		
	}//자료실 저장

	@Override
	public int getRowCount(PageVO p) {
		return this.sqlSession.selectOne("bbs_count",p);//bbs_count는 bbs.xml에서 설정한
		//유일한 아이디명
	}//검색 전후 레코드 개수

	@Override
	public List<BbsVO> getBbsList(PageVO p) {
		return this.sqlSession.selectList("bbs_list",p);//mybatis에서  selectList()
		//메서드는 하나이상의 레코드를 검색해서 컬렉션 List로 반환
	}//검색 전후 목록

	@Override
	public void updateHit(int bbs_no) {
		//this.sqlSession.update("bbs_hi",bbs_no);//mybatis에서 update()메서드로 레코드를 수정
		//bbs_hi는 bbs.xml에서 설정할 유일한 아이디명
		
		System.out.println("\n조회수 증가 JPA==================>");
		Optional<BbsVO> bbs_hit = this.bbsRepo.findById(bbs_no);//JPA로 번호를 기준으로
		//레코드 검색
		
		bbs_hit.ifPresent(bbs_hit2 ->{//자료가 있다면 
			
			int bbsHit_count=bbs_hit2.getBbs_hit()+1;//조회수+1=>증가된 조회수
			this.bbsRepo.updateBbsHit(bbs_no, bbsHit_count);//jpa로 번호를 기준으로 조회수 증가
		});
	}//조회수 증가

	@Override
	public BbsVO getBbsCont(int bbs_no) {
		//return this.sqlSession.selectOne("bbs_co",bbs_no);
		
		System.out.println("\n내용보기 jpa ====================>");
		BbsVO bc=this.bbsRepo.getReferenceById(bbs_no);//JPA로 번호에 해당하는 자료를 검색해서
		//엔티티빈 타입으로 반환
		return bc;
	}//내용보기

	@Override
	public void updateLevel(BbsVO b) {
		//this.sqlSession.update("levelUp",b);//mybatis에서는 update메서드로 레코드를 수정
		
		//JPA
		System.out.println("\n===================>JPA 답변 레벨 증가");
		this.bbsRepo.updateLevel(b.getBbs_ref(), b.getBbs_level());
		
	}//답변레벨증가
	
	
	@Override
	public void replyBbs(BbsVO b) {
		//this.sqlSession.insert("reply_in2",b);
		
		//JPA
		System.out.println("\n===================>JPA 답변 저장");
		int bbs_no=this.sqlSession.selectOne("bbsNoSeq_Find");
		// 시퀀스로부터 번호값을 구함
		b.setBbs_no(bbs_no);//자료실 번호 저장
		b.setBbs_step(b.getBbs_step()+1);
		b.setBbs_level(b.getBbs_level()+1);
		
		
	}//답변저장

	@Transactional
	@Override
	public void editBbs(BbsVO b) {
		//this.sqlSession.update("bbs_edit",b);
		
		System.out.println("\n===================>JPA 자료실 수정");
		this.bbsRepo.updatebbs(b.getBbs_name(), b.getBbs_no()
				,b.getBbs_title(), b.getBbs_cont(), b.getBbs_file());
		
		
	}//자료실 수정

	@Override
	public void delBbs(int bbs_no) {
		this.sqlSession.delete("bbs_del", bbs_no);
		
		
		
	}//자료실 삭제

	
}



