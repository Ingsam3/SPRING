package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.BbsVO;

@Repository
public class BbsDAOImpl implements BbsDAO {

	@Autowired
	private BbsRepository bbsRepo;//JPA를 통한 하이버네이트로 쿼리문 수행할려고 자동의존성 주입
	
	@Autowired
	private SqlSession sqlSession; //mybatis로 통한 쿼리문 수행할려고 자동의존성 주입

	@Override
	public void insertBbs(BbsVO b) {
		this.sqlSession.insert("bbs_in", b);
		/* bbs_in은 mybatis bbs.xml매퍼태그에서 설정할 유일한 아이디명이다.
		 * mybatis에서 insert()메서드는 레코드를 저장해 준다.
		 */
		//int bbs_no=this.sqlSession.selectOne("bbs_max_no");//자료실 번호에서 최대값을 구함.
		//mybatis에서는 selectOne()메서드는 단 한개의 레코드값만 반환, bbs_max_no는 bbs.xml에서
		//설정할 유일한 아이디명
		//System.out.println("최대값 번호:"+bbs_no);
		//b.setBbs_ref(bbs_no+1);//글 그룹번호로 저장
		//b.setBbs_no(bbs_no+1);
		
        //this.bbsRepo.save(b);//JPA로 하이버네이트를 구동해서 저장함.		
	}//자료실 저장
}



