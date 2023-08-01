package com.naver.dao;

import java.util.List;

import com.naver.vo.ReplyVO;

public interface ReplyDAO {

	void addreply(ReplyVO vo);

	List<ReplyVO> listReply(int bno);

	void updateReply(ReplyVO vo);

	void delReply(int rno);

	int getBno(int rno);

}
