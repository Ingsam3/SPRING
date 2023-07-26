package com.naver.service;

import java.util.List;

import com.naver.vo.ReplyVO;

public interface ReplyService {

	void addreply(ReplyVO vo);

	List<ReplyVO> listReply(int bno);

	void updateReply(ReplyVO vo);

	void delReply(int rno);

}
