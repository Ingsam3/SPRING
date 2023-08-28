package net.daum.service;

import java.util.List;

import net.daum.vo.BbsVO;
import net.daum.vo.PageVO;

public interface AdminBbsService {

	int getListCount(PageVO p);

	List<BbsVO> getadminBbsList(PageVO p);

	void adminInsertBbs(BbsVO b);

	BbsVO getadminBbsCont(int no);

}
