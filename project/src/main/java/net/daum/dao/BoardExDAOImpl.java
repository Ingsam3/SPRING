package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.BoardDTO;

@Repository
public class BoardExDAOImpl implements BoardExDAO {
	
	@Autowired
	private SqlSession sqlsession;

	@Override
	public void boardEx_insert(BoardDTO b) {
		this.sqlsession.insert("boardEx_insert",b);
		
	}

}
