package net.daum.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.BbsVO;
import net.daum.vo.PageVO;

@Repository
public class AdminBbsDAOImpl implements AdminBbsDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private AdminBbsRepository adminBbsRepo;

	@Override
	public int getListCount(PageVO p) {
		return this.sqlSession.selectOne("abbs_count",p);
	}//관리자 자료실 목록

	@Override
	public List<BbsVO> getadminBbsList(PageVO p) {
		
		return this.sqlSession.selectList("abbs_list",p);
	}//관리자 자료실 검색 전 후 목록

	@Override
	public void adminInsertBbs(BbsVO b) {
		//this.sqlSession.insert("abbs_in",b);
		
		//JPA
		System.out.println("\n =============>JPA 자료실 저장");
		int bbs_no = this.sqlSession.selectOne("bbsNoSeq_Find");
		//시퀀스로부터 번호값 구함
		b.setBbs_no(bbs_no);// 자료실 번호 저장
		b.setBbs_ref(bbs_no);//글 그룹 번호 저장
		
		this.adminBbsRepo.save(b);// JPA 로 저장
		
	}//관리자 자료실 저장

	@Override
	public BbsVO getadminBbsCont(int no) {
		
		//return this.sqlSession.selectOne("abbs_cont",no);
		
		//JPA
		System.out.println("\n =============>JPA 관리자 자료실 조회수 증가 안 되는 "
				+ "상세 정보 보기와 수정폼");
		BbsVO bc = this.adminBbsRepo.getReferenceById(no);
		//번호에 해당하는 레코드를 검색해서 엔티티빈 타입으로 반환
		
		return bc;
		
	}//관리자 자료실 상세정보와 수정폼 보기
	
	
	
}
