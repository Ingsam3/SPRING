package net.daum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.daum.dao.BoardExDAO;
import net.daum.vo.BoardDTO;

@Service
public class BoardExServiceImpl implements BoardExService {

	@Autowired
	private BoardExDAO BoardExDao;
	
	@Override
	public void boardEx_insert(BoardDTO b) {
		this.BoardExDao.boardEx_insert(b);
		
	}

}
