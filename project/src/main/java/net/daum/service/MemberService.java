package net.daum.service;

import java.util.List;

import net.daum.vo.MemberVO;
import net.daum.vo.ZipCodeVO;

public interface MemberService {

	MemberVO idCheck(String id);

	List<ZipCodeVO> zipFind(String dong);

	void insertMember(MemberVO m);

}
