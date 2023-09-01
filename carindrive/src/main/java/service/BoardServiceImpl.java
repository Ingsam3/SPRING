package com.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dao.BoardDAO;
import com.car.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDao;

	@Override
	public void insertBoard(BoardVO b) {
		this.boardDao.insertBoard(b);
	}

	@Override
	public int getTotalCount() {
		return boardDao.getTotalCount();
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO b) {
		return this.boardDao.getBoardList(b);
	}

	@Override
	public BoardVO getBoardCont(int bno) {
		return this.boardDao.getBoardCont(bno);
	}

	@Override
	public BoardVO getBoardCont2(int bno) {
		return this.boardDao.getBoardCont(bno);
	}

	@Override
	public void editBoard(BoardVO eb) {
		this.boardDao.editBoard(eb);
	}

	@Override
	public void delBoard(int bno) {
		this.boardDao.delBoard(bno);
	}
}
