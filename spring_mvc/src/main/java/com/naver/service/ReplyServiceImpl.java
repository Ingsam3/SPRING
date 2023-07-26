package com.naver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.dao.ReplyDAO;
import com.naver.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	
	@Autowired
	private ReplyDAO replyDao;

	@Override
	public void addreply(ReplyVO vo) {
		this.replyDao.addreply(vo);		
	}

	@Override
	public List<ReplyVO> listReply(int bno) {
		return this.replyDao.listReply(bno);
	}

	@Override
	public void updateReply(ReplyVO vo) {
		this.replyDao.updateReply(vo);		
	}

	@Override
	public void delReply(int rno) {
		this.replyDao.delReply(rno);		
	}
}
