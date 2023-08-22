package net.daum.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.daum.vo.BbsVO;

public interface BbsRepository extends JpaRepository<BbsVO, Integer> {
	/*
	 1. BbsRepository는 사용자 자료실을 JPa로 실행하기 위한 레포스토리이다
	 2. JpaRepository 인터페이스의 부모 인터페이스 중에서 PagingAndSortingReporitory에서 
	 	페이징과 정렬기능을 제공
	 	PagingAndSortingReporitory의 부모 인터페이스가 CrudeRepository이다
	 */
}
