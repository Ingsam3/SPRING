package net.daum.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.daum.dao.MemberMapper;
import net.daum.security.domain.CustomUser;
import net.daum.vo.MemberVO;

//스프링 시큐리티 자동 로그인과 관련된 클래스
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		
		//전달되어진 아이디값을 출력
		System.out.println("전달되어진 아이디 : " + username);
		
		//아이디를 기준으로 DB로 부터 회원정보 검색
		MemberVO vo = memberMapper.readMember(username);
		
		//DB로 부터 가져온 회원정보 출력
		System.out.println("DB로 부터 가져온 회원정보 출력 : "+vo);
		return vo == null ? null : new CustomUser(vo);
	}
}
