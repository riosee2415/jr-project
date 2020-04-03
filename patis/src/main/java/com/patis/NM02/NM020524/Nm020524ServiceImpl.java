package com.patis.NM02.NM020524;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.NM02.NM020524.I_Nm020524DAO;
import com.patis.model.BoardVO;

@Service("nm020524Service")
public class Nm020524ServiceImpl implements I_Nm020524Service{
	
	@Resource(name = "nm020524DAO")
	private  I_Nm020524DAO nm020524DAO;

	@Override
	public List<BoardVO> getCommunityList(int paging) throws SQLException {
		return nm020524DAO.getCommunityList(paging);
	}
	
	@Override
	public List<BoardVO> getCommunitySearchList(Map<String, Object> params) throws SQLException {
		return nm020524DAO.getCommunitySearchList(params);
	}

	@Override
	public BoardVO getCommunity(int b_no) throws SQLException {
		return nm020524DAO.getCommunity(b_no);
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
	public BoardVO getPrevCommunity(Map<String, Object> params) throws SQLException {
		return nm020524DAO.getPrevCommunity(params);
	}

	@Override
	public BoardVO getNextCommunity(Map<String, Object> params) throws SQLException {
		return nm020524DAO.getNextCommunity(params);
	}
	
	@Override
	public int modifyHitUp(int b_no) throws SQLException {
		return nm020524DAO.modifyHitUp(b_no);
	}
	
	@Override
	public int setCommunity(BoardVO boardVO) throws SQLException {
		return nm020524DAO.setCommunity(boardVO);
	}

	@Override
	public void modifyCommunity(BoardVO boardVO) throws SQLException {
		nm020524DAO.modifyCommunity(boardVO);
	}

	@Override
	public void removeCommunity(int b_no) throws SQLException {
		nm020524DAO.removeCommunity(b_no);
	}

	@Override
	public void setCommunityReply(BoardVO boardVO) throws SQLException {
		nm020524DAO.setCommunityReply(boardVO);
	}

	@Override
	public void modifyCommunityReply(BoardVO boardVO) throws SQLException {
		 nm020524DAO.modifyCommunityReply(boardVO);
	}

	@Override
	public void removeCommunityReply(int b_no) throws SQLException {
		nm020524DAO.removeCommunityReply(b_no);
	}

}
