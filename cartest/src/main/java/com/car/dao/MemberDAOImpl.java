package com.car.dao;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.car.vo.CarMemberVO;
import com.car.vo.MemberVO;
import com.car.vo.SocialVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

		@Autowired
		private MemberRepository memberRepo;
		
		@Autowired
		private SocialRepository socialRepo;
		
		@Autowired
		private SqlSession sqlSession;

		@Override
		public CarMemberVO idCheck(String id) {
			
			return this.sqlSession.selectOne("m_idcheck",id);
		}//아이디 중복 검색

		@Override
		public void insertMember(CarMemberVO cm) {
			this.sqlSession.insert("C_mem_in",cm);
			
		}//회원 저장

		
		@Override
		public CarMemberVO loginCheck(String m_id) {
			
			return this.sqlSession.selectOne("C_mem_login",m_id);
		}//로그인 유무 체크

		@Transactional
		public Integer insertSocial(SocialVO social) {
			try {
				socialRepo.save(social);
				return 1;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("회원가입");
			}
			return -1;
		}//소셜로그인 회원가입
		
		
		
		


	
}
