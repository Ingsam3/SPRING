package com.car.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.vo.SocialVO;

public interface SocialRepository extends JpaRepository<SocialVO, Integer> {

}
