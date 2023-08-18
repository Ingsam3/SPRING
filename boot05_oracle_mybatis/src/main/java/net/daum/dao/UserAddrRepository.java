package net.daum.dao;

import org.springframework.data.repository.CrudRepository;

import net.daum.vo.UserAddrVO;

public interface UserAddrRepository extends CrudRepository<UserAddrVO, Integer> {

}
