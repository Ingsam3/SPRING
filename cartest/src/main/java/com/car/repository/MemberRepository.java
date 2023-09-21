package com.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.vo.CarMemberVO;

public interface MemberRepository extends JpaRepository<CarMemberVO, Integer> {

	
	
}
