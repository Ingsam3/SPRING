package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.MessageVO;

@Repository//model DAO 인식
public class MessageDAOImp implements MessageDAO {
	@Autowired
	private SqlSession sqlsession;

	@Override
	public void insertM(MessageVO vo) {
		this.sqlsession.insert("message_in", vo);
		//message_in : message.xml 매퍼태그에서 설정할 유일한 아이디명
	}//메세지 추가
}
