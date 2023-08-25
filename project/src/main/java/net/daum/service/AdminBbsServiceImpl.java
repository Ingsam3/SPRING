package net.daum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.daum.dao.AdminBbsDAO;
import net.daum.vo.PageVO;

@Service
public class AdminBbsServiceImpl implements AdminBbsService {

	@Autowired
	private AdminBbsDAO adminBbsDao;

	@Override
	public int getListCount(PageVO p) {
		
		return this.adminBbsDao.getListCount(p);
	}
}
