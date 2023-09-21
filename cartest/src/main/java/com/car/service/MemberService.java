package com.car.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.car.dao.MemberRepository;
import com.car.vo.CarMemberVO;
import com.car.vo.MemberVO;
import com.car.vo.SocialVO;

public interface MemberService {
	
	
	@Autowired
    private MemberRepository memberRepo;
	
	
	public CarMemberVO save(CarMemberVO CarMemVo) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        Role role = new Role();
        role.setId(1l);
        user.getRoles().add(role);
        return userRepository.save(user);
    }
	
	
	

	CarMemberVO idCheck(String id);

	void insertMember(CarMemberVO cm);

	CarMemberVO loginCheck(String m_id);

	void insertKakao(SocialVO kakaoUser);

	SocialVO serchkakao(String userEmail);

	CarMemberVO serchUserEmail(String m_email);

	
	
	


	
	


	

}
