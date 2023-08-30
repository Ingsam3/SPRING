package net.daum.dao;

import java.util.List;

import net.daum.vo.BbsVO;
import net.daum.vo.PageVO;

public interface AdminBbsDAO {

	int getListCount(PageVO p);
	List<BbsVO> getadminBbsList(PageVO p);
	void adminInsertBbs(BbsVO b);
	BbsVO getadminBbsCont(int no);
	void adminUpdateBbs(BbsVO b);
	void adminBbdDel(int no);

}
