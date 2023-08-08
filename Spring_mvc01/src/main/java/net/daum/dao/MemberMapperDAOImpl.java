package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.MemberVO;

@Repository
public class MemberMapperDAOImpl implements MemberMapper {

	@Autowired //자동의존성 주입
	private SqlSession sqlSession;

	@Override
	public MemberVO readMember(String userid) {
		return this.sqlSession.selectOne("readMem",userid);
	} 
}
