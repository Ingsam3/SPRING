package net.daum.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.daum.vo.BbsVO;

public interface AdminBbsRepository extends JpaRepository<BbsVO, Integer> {

}
