package net.daum.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.UserAddrVO;


public interface UserAddrDAO {

	void insertUserAddr(UserAddrVO useraddr);

}
