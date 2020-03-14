package com.patis.admin.AD0203;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.Accept_typeVO;
import com.patis.model.BoardVO;
import com.patis.model.CommentsVO;
import com.patis.model.CommonVO;

@Service("ad0203Service")
public class Ad0203ServiceImpl implements I_Ad0203Service{
	
	@Resource(name = "ad0203DAO")
	private I_Ad0203DAO ad0203DAO;

	@Override
	public int getListCount(Map<String, String> params) {
		return ad0203DAO.getListCount(params);
	}

	@Override
	public List<BoardVO> getBoardData(int paging) {
		return ad0203DAO.getBoardData(paging);
	}

	@Override
	public int chagneNoticeStatus(int status, int no) {
		return ad0203DAO.chagneNoticeStatus(status, no);
	}

	@Override
	public int deleteOne(int no) {
		return ad0203DAO.deleteOne(no);
	}

	@Override
	public List<BoardVO> getSearch(Map<String, Object> params) {
		return ad0203DAO.getSearch(params);
	}

	@Override
	public List<CommentsVO> getCommentsById(int p_no) {
		return ad0203DAO.getCommentsById(p_no);
	}

	@Override
	public int commentDelete(int co_no) {
		return ad0203DAO.commentDelete(co_no);
	}

	@Override
	public List<CommonVO> getRight() {
		return ad0203DAO.getRight();
	}

	@Override
	public Accept_typeVO currentRight() {
		return ad0203DAO.currentRight();
	}

	@Override
	public int UpdateRight(Map<String, Object> params) {
		return ad0203DAO.UpdateRight(params);
	}

}
