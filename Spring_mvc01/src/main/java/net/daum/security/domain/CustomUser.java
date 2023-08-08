package net.daum.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import net.daum.vo.MemberVO;

public class CustomUser extends User {//스프링 시큐리티 인증관리자에 필요한 클래스->security-conte
	//xt.xml

	private MemberVO member;
	
    public CustomUser(String username,String password,
    		Collection<? extends GrantedAuthority> authorities) {
    	//GrantedAuthority 상속받은 자손타입으로만 제네릭 타입 형변환을 허용하면서 권한 목록을 구함.
    	super(username,password,authorities);
    }//생성자 오버로딩
	
    public CustomUser(MemberVO vo) {
    	super(vo.getUserid(),vo.getUserpw(),vo.getAuthList().stream()
    			.map(auth->new SimpleGrantedAuthority(auth.getAuth())).collect(
    					Collectors.toList()));
    	//검색된 아이디,비번,권한목록으로 스트림 객체를 생성한 다음 정보를 수집해서 SimpleGrantedAuthority
    	//생성자를 호출해서 값을 전달
    	this.member=vo;
    }
}
