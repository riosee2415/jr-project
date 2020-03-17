package com.patis.admin.AD0208;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.Accept_typeVO;
import com.patis.model.BoardVO;
import com.patis.model.CommentsVO;
import com.patis.model.CommonVO;

@Service("ad0208Service")
public class Ad0208serviceImpl implements I_Ad0208Service{
	
	@Resource(name = "ad0208DAO")
	private I_Ad0208DAO ad0208DAO;

	@Override
	public int getListCount(Map<String, String> params) {
		return ad0208DAO.getListCount(params);
	}

	@Override
	public List<BoardVO> getBoardData(int paging) {
		return ad0208DAO.getBoardData(paging);
	}

	@Override
	public int chagneNoticeStatus(int status, int no) {
		return ad0208DAO.chagneNoticeStatus(status, no);
	}

	@Override
	public int deleteOne(int no) {
		return ad0208DAO.deleteOne(no);
	}

	@Override
	public List<BoardVO> getSearch(Map<String, Object> params) {
		return ad0208DAO.getSearch(params);
	}

	@Override
	public List<CommentsVO> getCommentsById(int p_no) {
		return ad0208DAO.getCommentsById(p_no);
	}

	@Override
	public int commentDelete(int co_no) {
		return ad0208DAO.commentDelete(co_no);
	}

	@Override
	public List<CommonVO> getRight() {
		return ad0208DAO.getRight();
	}

	@Override
	public Accept_typeVO currentRight() {
		return ad0208DAO.currentRight();
	}

	@Override
	public int UpdateRight(Map<String, Object> params) {
		return ad0208DAO.UpdateRight(params);
	}

	@Override
	public int getAdminControllRight() {
		return ad0208DAO.getAdminControllRight();
	}

}
