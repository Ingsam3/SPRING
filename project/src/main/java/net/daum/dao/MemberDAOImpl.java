package net.daum.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.MemberVO;
import net.daum.vo.ZipCodeVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession; //mybatis 쿼리문 수행
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private ZipCodeRepository zipcodeRepo;

	@Override
	public MemberVO idCheck(String id) {
		//return this.sqlSession.selectOne("m_idcheck",id);
		
        System.out.println(" \n ==============> 아이디 중복 검색(JPA)");
        Optional<MemberVO> result = this.memberRepo.findById(id);
        MemberVO member;
        if(result.isPresent()) {//아이디에 해당하는 회원정보가 있다면 참
        	member = result.get();//MemberVO 엔티티 타입 객체를 구함
        }else {//회원정보가 없다면
        	member = null;
        }
		return member;
	}//아이디 중복 검색

	@Override
	public List<ZipCodeVO> zipFind(String dong) {
		//return this.sqlSession.selectList("m_zip",dong);
		
		System.out.println(" \n ==============> 우편주소 검색(JPA)");
		List<ZipCodeVO> zlist = this.zipcodeRepo.findByGil(dong);
		return zlist;
	}//우편주소 검색

	@Override
	public void insertMember(MemberVO m) {
		//this.sqlSession.insert("m_in", m);	
		
		System.out.println(" \n ===========>회원 저장(JPA)");
		m.setMem_state(1);//가입 회원일 때 1 저장
		this.memberRepo.save(m);
	}//회원저장
}




