package net.daum.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAOImpl implements PointDAO {

	
	@Autowired
	private SqlSession sqlSession;
	@Override
	public void updatePoint(String sender, int point) {
		/*
		 DAOImpl에서 ma=ybatis 매퍼 태그로 복수개의 파라미터 값을 전달 할 때는
		  java.util 패키지의 Map 자료구조 사용
		 * */		
		
		Map<String, Object> pm=new HashMap<>();
		pm.put("sender", sender);
		// 왼쪽 문자열 키이름에 오른쪽의 보낸 사람을 저장 mbatis 매퍼태그에서 키이름을 참조해서 값을 가져온다
		pm.put("point", point);
		
		this.sqlSession.update("pointUP",pm);
		//mybatis에서 update() 메서드로 레코드를 수정한다
		//up은 mybatis point.xml에서 설정할 유일한 아이디명
		
	}//메세지 보낸 사포람한테 포인터 점수 +10 업데이트

}
