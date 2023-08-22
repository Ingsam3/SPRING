package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.daum.vo.BbsVO;

public class BbsDAOImpl implements BbsDAO {

	@Autowired
	   private BbsRepository bbsRepo; //JPA를 통한 하이버네이트로 쿼리문 수행을 위한 자동 의존성 주입
	   
	   @Autowired
	   private SqlSession sqlsession; //mybatis 로 쿼리문 수행 자동의존성 주입

	@Override
	public void insertBbs(BbsVO b) {
		//this.sqlsession.insert("bbs_in", b); //mybatis
		/*
		 * bbs_in : mybatid bbs.xml매퍼태그에서 설정한 유일한 아이디명이다
		 * insert() 메서드는 레코드 저장
		 * */
		
		
		int bbs_no=this.sqlsession.selectOne("bbs_max_no");
		//자료실 번호에서 최대값을 구함 mybatis에서 selectOne는 단 한개의 레코드 값만 반환
		System.out.println("최대값 번호" +bbs_no);
		b.setBbs_ref(bbs_no);//글 그룹 번호로 저장
		
		this.bbsRepo.save(b); //jpa로 하이버 네이트를 구동해서 저장함
	}//자료실 저장
}
