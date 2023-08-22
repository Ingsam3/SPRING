package net.daum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.daum.dao.BbsDAO;
import net.daum.vo.BbsVO;

@Service
public class BbsServiceImpl implements BbsService {

	/* 스프링 MVC에서 서비스의 역할)
	 *  1.컨트롤러와 모델 DAO를 연결하는 중간 매개체 역할
	 *  2.고객의 추가요구 사항을 반영하는 곳
	 *  3.스프링의 AOP를 통한 트랜잭션 적용함으로써 데이터 불일치 현상을 제거=>데이터 일관성 유지  
	 */
	
	@Autowired
	private BbsDAO bbsDao;

	@Override
	public void insertBbs(BbsVO b) {
	  this.bbsDao.insertBbs(b);			
	}	
}
