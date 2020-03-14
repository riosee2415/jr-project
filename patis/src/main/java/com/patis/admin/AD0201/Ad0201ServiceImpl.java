package com.patis.admin.AD0201;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.Accept_typeVO;
import com.patis.model.BoardVO;
import com.patis.model.CommentsVO;
import com.patis.model.CommonVO;

@Service("ad0201Service")
public class Ad0201ServiceImpl implements I_Ad0201Service{
	
	@Resource(name = "ad0201DAO")
	private I_Ad0201DAO ad0201DAO;

	@Override
	public int getListCount(Map<String, String> params) {
		return ad0201DAO.getListCount(params);
	}

	@Override
	public List<BoardVO> getBoardData(int paging) {
		return ad0201DAO.getBoardData(paging);
	}

	@Override
	public int chagneNoticeStatus(int status, int no) {
		return ad0201DAO.chagneNoticeStatus(status, no);
	}

	@Override
	public int deleteOne(int no) {
		return ad0201DAO.deleteOne(no);
	}

	@Override
	public List<BoardVO> getSearch(Map<String, Object> params) {
		return ad0201DAO.getSearch(params);
	}

	@Override
	public List<CommentsVO> getCommentsById(int p_no) {
		return ad0201DAO.getCommentsById(p_no);
	}

	@Override
	public int commentDelete(int co_no) {
		return ad0201DAO.commentDelete(co_no);
	}

	@Override
	public List<CommonVO> getRight() {
		return ad0201DAO.getRight();
	}

	@Override
	public Accept_typeVO currentRight() {
		return ad0201DAO.currentRight();
	}

	@Override
	public int UpdateRight(Map<String, Object> params) {
		return ad0201DAO.UpdateRight(params);
	}

}
