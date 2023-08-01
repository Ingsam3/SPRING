package com.naver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.dao.BoardDAO;
import com.naver.dao.ReplyDAO;
import com.naver.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	
	@Autowired
	private ReplyDAO replyDao;
	@Autowired
	private BoardDAO boardDao;
	//스프링 AOP 를 통한 트랜잭션 적용대상  =>댓글이 추가되면 댓글 카운트 1증가
	@Transactional //데이터 일관성 유지(불일치선 현상 제거)
	@Override
	public void addreply(ReplyVO vo) {
		this.replyDao.addreply(vo);		
		this.boardDao.updateReplyCnt(vo.getBno(),1);
		//새로운 댓글이 달리면 replycnt 컬럼에 댓글 개수 하나 1 증가 - 
		//게시판 번호를 기준으로 replycnt를 수정
	}

	@Override
	public List<ReplyVO> listReply(int bno) {
		return this.replyDao.listReply(bno);
	}

	@Override
	public void updateReply(ReplyVO vo) {
		this.replyDao.updateReply(vo);		
	}
	//스프링 AOP 를 통한 트랜잭션 적용대상 =>댓글이 삭제되면 댓글 카운트 1감소
	@Transactional
	@Override
	public void delReply(int rno) {
		int bno = this.replyDao.getBno(rno);
		//댓글 삭제 되기 전 댓글 번호를 기준으로 게시판 번호값을 수함
		this.replyDao.delReply(rno);		
		this.boardDao.updateReplyCnt(bno, -1); //댓글 하나 삭제되면 댓글 개수 1감소
	}
}
