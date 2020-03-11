package com.patis.NM02.NM020524;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.BoardVO;

@Service("nm020524Service")
public class Nm020524ServiceImpl implements I_Nm020524Service{
	
	@Resource(name = "nm020524DAO")
	private  I_Nm020524DAO nm020524DAO;

	@Override
	public List<BoardVO> getCollusionList(int paging) throws SQLException {
		return nm020524DAO.getCollusionList(paging);
	}
	
	@Override
	public List<BoardVO> getCollusionSearchList(Map<String, Object> params) throws SQLException {
		return nm020524DAO.getCollusionSearchList(params);
	}

	@Override
	public BoardVO getCollusion(int b_no) throws SQLException {
		return nm020524DAO.getCollusion(b_no);
	}

	@Override
	public int getListCount() throws SQLException {
		return nm020524DAO.getListCount();
	}
	
	@Override
	public int getSearchListCount(Map<String, String> params) throws SQLException {
		return nm020524DAO.getSearchListCount(params);
	}

	@Override
	public String getBoardType() throws SQLException {
		return nm020524DAO.getBoardType();
	}

	@Override
	public BoardVO getPrevCollusion(Map<String, Object> params) throws SQLException {
		return nm020524DAO.getPrevCollusion(params);
	}

	@Override
	public BoardVO getNextCollusion(Map<String, Object> params) throws SQLException {
		return nm020524DAO.getNextCollusion(params);
	}
	
	@Override
	public int modifyHitUp(int b_no) throws SQLException {
		return nm020524DAO.modifyHitUp(b_no);
	}

	@Override
	public int setCommunity(BoardVO boardVO) throws SQLException {
		return nm020524DAO.setCommunity(boardVO);
	}

}
