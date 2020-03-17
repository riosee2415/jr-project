package com.patis.admin.AD0211;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.Accept_typeVO;
import com.patis.model.BoardVO;
import com.patis.model.CommentsVO;
import com.patis.model.CommonVO;

@Service("ad0211Service")
public class Ad0211serviceImpl implements I_Ad0211Service{
	
	@Resource(name = "ad0211DAO")
	private I_Ad0211DAO ad0211DAO;

	@Override
	public int getListCount(Map<String, String> params) {
		return ad0211DAO.getListCount(params);
	}

	@Override
	public List<BoardVO> getBoardData(int paging) {
		return ad0211DAO.getBoardData(paging);
	}

	@Override
	public int chagneNoticeStatus(int status, int no) {
		return ad0211DAO.chagneNoticeStatus(status, no);
	}

	@Override
	public int deleteOne(int no) {
		return ad0211DAO.deleteOne(no);
	}

	@Override
	public List<BoardVO> getSearch(Map<String, Object> params) {
		return ad0211DAO.getSearch(params);
	}

	@Override
	public List<CommentsVO> getCommentsById(int p_no) {
		return ad0211DAO.getCommentsById(p_no);
	}

	@Override
	public int commentDelete(int co_no) {
		return ad0211DAO.commentDelete(co_no);
	}

	@Override
	public List<CommonVO> getRight() {
		return ad0211DAO.getRight();
	}

	@Override
	public Accept_typeVO currentRight() {
		return ad0211DAO.currentRight();
	}

	@Override
	public int UpdateRight(Map<String, Object> params) {
		return ad0211DAO.UpdateRight(params);
	}

	@Override
	public int getAdminControllRight() {
		return ad0211DAO.getAdminControllRight();
	}

}
