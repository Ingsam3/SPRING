package com.naver.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.naver.dao.MemberDAO;
import com.naver.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})

public class MemberDAOTest {
	@Autowired//자동 의존성 주입
	private MemberDAO memDao;
	
	@Test
	public void testMemberInsert() throws Exception{
		MemberVO mem = new MemberVO();
		
		mem.setUserid("ddd10");
		mem.setUserpw("9999");
		mem.setUsername("kim");
		mem.setEmail("kim@naver.com");
		
		this.memDao.insertMember(mem); //회원저장
	}
}
