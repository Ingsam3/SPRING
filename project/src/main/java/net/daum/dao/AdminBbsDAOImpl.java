package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.PageVO;

@Repository
public class AdminBbsDAOImpl implements AdminBbsDAO {

	
	@Autowired
	private SqlSession sqlSession; 
	
	@Autowired
	private AdminBbsRepository adminBbsRepo;

	@Override
	public int getListCount(PageVO p) {
		
		return this.sqlSession.selectOne("abbs_count",p);
	}//관리자 자료실 목록
	
}
