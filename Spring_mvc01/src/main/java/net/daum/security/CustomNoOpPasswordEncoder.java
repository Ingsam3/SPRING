package net.daum.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomNoOpPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}//암호화 되기전 비번을 문자열로 반환

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return rawPassword.toString().equals(encodedPassword);
		//암호화 되기전 비번과 암호화 된 비번 내용물만 같은지 비교해서 같다면 true,다르다면 false
	}
}
