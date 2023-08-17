package net.daum.dao;

import org.springframework.data.repository.CrudRepository;

import net.daum.vo.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {

	
	//ID : private int fno; 의 int는 Integer로 표현
}
