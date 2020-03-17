package com.patis.admin.AD0209;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.Accept_typeVO;
import com.patis.model.BoardVO;
import com.patis.model.CommentsVO;
import com.patis.model.CommonVO;

@Service("ad0209Service")
public class Ad0209serviceImpl implements I_Ad0209Service{
	
	@Resource(name = "ad0209DAO")
	private I_Ad0209DAO ad0209DAO;

	@Override
	public int getListCount(Map<String, String> params) {
		return ad0209DAO.getListCount(params);
	}

	@Override
	public List<BoardVO> getBoardData(int paging) {
		return ad0209DAO.getBoardData(paging);
	}

	@Override
	public int chagneNoticeStatus(int status, int no) {
		return ad0209DAO.chagneNoticeStatus(status, no);
	}

	@Override
	public int deleteOne(int no) {
		return ad0209DAO.deleteOne(no);
	}

	@Override
	public List<BoardVO> getSearch(Map<String, Object> params) {
		return ad0209DAO.getSearch(params);
	}

	@Override
	public List<CommentsVO> getCommentsById(int p_no) {
		return ad0209DAO.getCommentsById(p_no);
	}

	@Override
	public int commentDelete(int co_no) {
		return ad0209DAO.commentDelete(co_no);
	}

	@Override
	public List<CommonVO> getRight() {
		return ad0209DAO.getRight();
	}

	@Override
	public Accept_typeVO currentRight() {
		return ad0209DAO.currentRight();
	}

	@Override
	public int UpdateRight(Map<String, Object> params) {
		return ad0209DAO.UpdateRight(params);
	}

	@Override
	public int getAdminControllRight() {
		return ad0209DAO.getAdminControllRight();
	}

}
