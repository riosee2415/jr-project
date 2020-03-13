package com.patis.admin.AD0213;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.Accept_typeVO;
import com.patis.model.BoardVO;
import com.patis.model.CommentsVO;
import com.patis.model.CommonVO;

@Service("ad0213Service")
public class Ad0213serviceImpl implements I_Ad0213Service{
	
	@Resource(name = "ad0213DAO")
	private I_Ad0213DAO ad0213DAO;

	@Override
	public int getListCount(Map<String, String> params) {
		return ad0213DAO.getListCount(params);
	}

	@Override
	public List<BoardVO> getBoardData(int paging) {
		return ad0213DAO.getBoardData(paging);
	}

	@Override
	public int chagneNoticeStatus(int status, int no) {
		return ad0213DAO.chagneNoticeStatus(status, no);
	}

	@Override
	public int deleteOne(int no) {
		return ad0213DAO.deleteOne(no);
	}

	@Override
	public List<BoardVO> getSearch(Map<String, Object> params) {
		return ad0213DAO.getSearch(params);
	}

	@Override
	public List<CommentsVO> getCommentsById(int p_no) {
		return ad0213DAO.getCommentsById(p_no);
	}

	@Override
	public int commentDelete(int co_no) {
		return ad0213DAO.commentDelete(co_no);
	}

	@Override
	public List<CommonVO> getRight() {
		return ad0213DAO.getRight();
	}

	@Override
	public Accept_typeVO currentRight() {
		return ad0213DAO.currentRight();
	}

	@Override
	public int UpdateRight(Map<String, Object> params) {
		return ad0213DAO.UpdateRight(params);
	}

}
