package com.patis.admin.AD0206;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.Accept_typeVO;
import com.patis.model.BoardVO;
import com.patis.model.CommentsVO;
import com.patis.model.CommonVO;

@Service("ad0206Service")
public class Ad0206ServiceImpl implements I_Ad0206Service{
	
	@Resource(name = "ad0206DAO")
	private I_Ad0206DAO ad0206DAO;

	@Override
	public int getListCount(Map<String, String> params) {
		return ad0206DAO.getListCount(params);
	}

	@Override
	public List<BoardVO> getBoardData(int paging) {
		return ad0206DAO.getBoardData(paging);
	}

	@Override
	public int chagneNoticeStatus(int status, int no) {
		return ad0206DAO.chagneNoticeStatus(status, no);
	}

	@Override
	public int deleteOne(int no) {
		return ad0206DAO.deleteOne(no);
	}

	@Override
	public List<BoardVO> getSearch(Map<String, Object> params) {
		return ad0206DAO.getSearch(params);
	}

	@Override
	public List<CommentsVO> getCommentsById(int p_no) {
		return ad0206DAO.getCommentsById(p_no);
	}

	@Override
	public int commentDelete(int co_no) {
		return ad0206DAO.commentDelete(co_no);
	}

	@Override
	public List<CommonVO> getRight() {
		return ad0206DAO.getRight();
	}

	@Override
	public Accept_typeVO currentRight() {
		return ad0206DAO.currentRight();
	}

	@Override
	public int UpdateRight(Map<String, Object> params) {
		return ad0206DAO.UpdateRight(params);
	}

}
