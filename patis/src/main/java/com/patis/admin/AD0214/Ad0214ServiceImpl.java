package com.patis.admin.AD0214;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.Accept_typeVO;
import com.patis.model.BoardVO;
import com.patis.model.CommentsVO;
import com.patis.model.CommonVO;

@Service("ad0214Service")
public class Ad0214ServiceImpl implements I_Ad0214Service{
	
	@Resource(name = "ad0214DAO")
	private I_Ad0214DAO ad0214DAO;

	@Override
	public int getListCount(Map<String, String> params) {
		return ad0214DAO.getListCount(params);
	}

	@Override
	public List<BoardVO> getBoardData(int paging) {
		return ad0214DAO.getBoardData(paging);
	}

	@Override
	public int chagneNoticeStatus(int status, int no) {
		return ad0214DAO.chagneNoticeStatus(status, no);
	}

	@Override
	public int deleteOne(int no) {
		return ad0214DAO.deleteOne(no);
	}

	@Override
	public List<BoardVO> getSearch(Map<String, Object> params) {
		return ad0214DAO.getSearch(params);
	}

	@Override
	public List<CommentsVO> getCommentsById(int p_no) {
		return ad0214DAO.getCommentsById(p_no);
	}

	@Override
	public int commentDelete(int co_no) {
		return ad0214DAO.commentDelete(co_no);
	}

	@Override
	public List<CommonVO> getRight() {
		return ad0214DAO.getRight();
	}

	@Override
	public Accept_typeVO currentRight() {
		return ad0214DAO.currentRight();
	}

	@Override
	public int UpdateRight(Map<String, Object> params) {
		return ad0214DAO.UpdateRight(params);
	}

	@Override
	public int getAdminControllRight() {
		return ad0214DAO.getAdminControllRight();
	}

}
