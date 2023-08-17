package net.daum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.daum.dao.MessageDAO;
import net.daum.dao.PointDAO;
import net.daum.vo.MessageVO;

@Service
public class MessageServiceImpl implements MessageService {

	//다른 서비스와 차이점은  AOP를통한 트랜잭션을 적용하기 위해 2개의 DAO로 나눠진다

	@Autowired
	private MessageDAO messageDao;
	
	@Autowired
	private PointDAO pointDao;

	//Insert 포인터 점수 10점 UPDATE => AOP 트랜잭션 적용부분 
	@Transactional
	@Override
	public void insertMessage(MessageVO vo) {
		this.messageDao.insertM(vo); 
		this.pointDao.updatePoint(vo.getSender(),10); 
		//메세지를 보낸 사람에게 포인트 점수 +10
		//인자값이 2개 전달됨 -> DAOImpl에서 mapper로 넘길 때 오류날수도
		//해결 => MAP 컬렉션 사용
	}
	
	
	
}
