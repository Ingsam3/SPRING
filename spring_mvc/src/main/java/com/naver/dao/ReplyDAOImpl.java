package com.naver.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.vo.ReplyVO;

@Repository // 모델DAO인식
public class ReplyDAOImpl implements ReplyDAO {
	@Autowired // 자동의존성 주입
	
	private SqlSession sqlsession; // mybatis 쿼리문 수행sqlsession

	@Override
	public void addreply(ReplyVO vo) {
		this.sqlsession.insert("reply_in", vo);		
	}

	@Override
	public List<ReplyVO> listReply(int bno) {
		return this.sqlsession.selectList("reply_list", bno);
		//mybatis에서 selectList()는 한개이상의 레코드를 건색해서 컬렉션 Lidt로 반환
	
	}

	@Override
	public void updateReply(ReplyVO vo) {
		this.sqlsession.update("reply_edit" , vo);
	}//댓글 수정

	@Override
	public void delReply(int rno) {
		this.sqlsession.update("reply_del" , rno);		
	}//댓글 삭제
	
	
}
