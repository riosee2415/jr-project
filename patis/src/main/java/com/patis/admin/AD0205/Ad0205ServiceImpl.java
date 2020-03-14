package com.patis.admin.AD0205;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.Accept_typeVO;
import com.patis.model.BoardVO;
import com.patis.model.CommentsVO;
import com.patis.model.CommonVO;

@Service("ad0205Service")
public class Ad0205ServiceImpl implements I_Ad0205Service{
	
	@Resource(name = "ad0205DAO")
	private I_Ad0205DAO ad0205DAO;

	@Override
	public int getListCount(Map<String, String> params) {
		return ad0205DAO.getListCount(params);
	}

	@Override
	public List<BoardVO> getBoardData(int paging) {
		return ad0205DAO.getBoardData(paging);
	}

	@Override
	public int chagneNoticeStatus(int status, int no) {
		return ad0205DAO.chagneNoticeStatus(status, no);
	}

	@Override
	public int deleteOne(int no) {
		return ad0205DAO.deleteOne(no);
	}

	@Override
	public List<BoardVO> getSearch(Map<String, Object> params) {
		return ad0205DAO.getSearch(params);
	}

	@Override
	public List<CommentsVO> getCommentsById(int p_no) {
		return ad0205DAO.getCommentsById(p_no);
	}

	@Override
	public int commentDelete(int co_no) {
		return ad0205DAO.commentDelete(co_no);
	}

	@Override
	public List<CommonVO> getRight() {
		return ad0205DAO.getRight();
	}

	@Override
	public Accept_typeVO currentRight() {
		return ad0205DAO.currentRight();
	}

	@Override
	public int UpdateRight(Map<String, Object> params) {
		return ad0205DAO.UpdateRight(params);
	}

}
