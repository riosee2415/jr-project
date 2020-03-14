package com.patis.admin.AD0202;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.Accept_typeVO;
import com.patis.model.BoardVO;
import com.patis.model.CommentsVO;
import com.patis.model.CommonVO;

@Service("ad0202Service")
public class Ad0202ServiceImpl implements I_Ad0202Service{
	
	@Resource(name = "ad0202DAO")
	private I_Ad0202DAO ad0202DAO;

	@Override
	public int getListCount(Map<String, String> params) {
		return ad0202DAO.getListCount(params);
	}

	@Override
	public List<BoardVO> getBoardData(int paging) {
		return ad0202DAO.getBoardData(paging);
	}

	@Override
	public int chagneNoticeStatus(int status, int no) {
		return ad0202DAO.chagneNoticeStatus(status, no);
	}

	@Override
	public int deleteOne(int no) {
		return ad0202DAO.deleteOne(no);
	}

	@Override
	public List<BoardVO> getSearch(Map<String, Object> params) {
		return ad0202DAO.getSearch(params);
	}

	@Override
	public List<CommentsVO> getCommentsById(int p_no) {
		return ad0202DAO.getCommentsById(p_no);
	}

	@Override
	public int commentDelete(int co_no) {
		return ad0202DAO.commentDelete(co_no);
	}

	@Override
	public List<CommonVO> getRight() {
		return ad0202DAO.getRight();
	}

	@Override
	public Accept_typeVO currentRight() {
		return ad0202DAO.currentRight();
	}

	@Override
	public int UpdateRight(Map<String, Object> params) {
		return ad0202DAO.UpdateRight(params);
	}

}
