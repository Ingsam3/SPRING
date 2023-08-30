package net.daum.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.daum.vo.ZipCodeVO;

public interface ZipCodeRepository extends JpaRepository<ZipCodeVO, Integer> {

}
