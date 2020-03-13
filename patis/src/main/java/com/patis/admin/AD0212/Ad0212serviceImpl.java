package com.patis.admin.AD0212;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.Accept_typeVO;
import com.patis.model.BoardVO;
import com.patis.model.CommentsVO;
import com.patis.model.CommonVO;

@Service("ad0212Service")
public class Ad0212serviceImpl implements I_Ad0212Service{
	
	@Resource(name = "ad0212DAO")
	private I_Ad0212DAO ad0212DAO;

	@Override
	public int getListCount(Map<String, String> params) {
		return ad0212DAO.getListCount(params);
	}

	@Override
	public List<BoardVO> getBoardData(int paging) {
		return ad0212DAO.getBoardData(paging);
	}

	@Override
	public int chagneNoticeStatus(int status, int no) {
		return ad0212DAO.chagneNoticeStatus(status, no);
	}

	@Override
	public int deleteOne(int no) {
		return ad0212DAO.deleteOne(no);
	}

	@Override
	public List<BoardVO> getSearch(Map<String, Object> params) {
		return ad0212DAO.getSearch(params);
	}

	@Override
	public List<CommentsVO> getCommentsById(int p_no) {
		return ad0212DAO.getCommentsById(p_no);
	}

	@Override
	public int commentDelete(int co_no) {
		return ad0212DAO.commentDelete(co_no);
	}

	@Override
	public List<CommonVO> getRight() {
		return ad0212DAO.getRight();
	}

	@Override
	public Accept_typeVO currentRight() {
		return ad0212DAO.currentRight();
	}

	@Override
	public int UpdateRight(Map<String, Object> params) {
		return ad0212DAO.UpdateRight(params);
	}

}
