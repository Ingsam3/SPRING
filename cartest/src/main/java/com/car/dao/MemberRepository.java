package com.car.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.vo.MemberVO;

public interface MemberRepository extends JpaRepository<MemberVO, Integer> {

}
