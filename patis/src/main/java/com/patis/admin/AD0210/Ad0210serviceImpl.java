package com.patis.admin.AD0210;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.Accept_typeVO;
import com.patis.model.BoardVO;
import com.patis.model.CommentsVO;
import com.patis.model.CommonVO;

@Service("ad0210Service")
public class Ad0210serviceImpl implements I_Ad0210Service{
	
	@Resource(name = "ad0210DAO")
	private I_Ad0210DAO ad0210DAO;

	@Override
	public int getListCount(Map<String, String> params) {
		return ad0210DAO.getListCount(params);
	}

	@Override
	public List<BoardVO> getBoardData(int paging) {
		return ad0210DAO.getBoardData(paging);
	}

	@Override
	public int chagneNoticeStatus(int status, int no) {
		return ad0210DAO.chagneNoticeStatus(status, no);
	}

	@Override
	public int deleteOne(int no) {
		return ad0210DAO.deleteOne(no);
	}

	@Override
	public List<BoardVO> getSearch(Map<String, Object> params) {
		return ad0210DAO.getSearch(params);
	}

	@Override
	public List<CommentsVO> getCommentsById(int p_no) {
		return ad0210DAO.getCommentsById(p_no);
	}

	@Override
	public int commentDelete(int co_no) {
		return ad0210DAO.commentDelete(co_no);
	}

	@Override
	public List<CommonVO> getRight() {
		return ad0210DAO.getRight();
	}

	@Override
	public Accept_typeVO currentRight() {
		return ad0210DAO.currentRight();
	}

	@Override
	public int UpdateRight(Map<String, Object> params) {
		return ad0210DAO.UpdateRight(params);
	}

}
