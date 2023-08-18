package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.UserAddrVO;

@Repository
public class UserAddrDAOImpl implements UserAddrDAO	{//JPA + mybatis 구동

	@Autowired
	private UserAddrRepository userAddrRepo; //JPA 실행을 위한 자동 의존성 주입
	
	@Autowired
	private SqlSession sqlSession; //mybatis 구동을 위한 자동의존성 주입(DI : Dependency Injection)

	@Override
	public void insertUserAddr(UserAddrVO useraddr) {
		this.userAddrRepo.save(useraddr); // jpa로 이름과 주소를 저장	
		//this.sqlSession.insert("useraddr_in", useraddr); //mybatis로 이름과 주소 저장
	}
	
}
