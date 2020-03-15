package com.patis.NM02.NM020833;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.BoardVO;

@Service("nm020833Service")
public class Nm020833ServiceImpl implements I_Nm020833Service{
	
	@Resource(name = "nm020833DAO")
	private  I_Nm020833DAO nm020833DAO;

	@Override
	public List<BoardVO> getReleaseList(int paging) throws SQLException {
		return nm020833DAO.getReleaseList(paging);
	}
	
	@Override
	public List<BoardVO> getReleaseSearchList(Map<String, Object> params) throws SQLException {
		return nm020833DAO.getReleaseSearchList(params);
	}

	@Override
	public BoardVO getRelease(int b_no) throws SQLException {
		return nm020833DAO.getRelease(b_no);
	}

	@Override
	public int getListCount() throws SQLException {
		return nm020833DAO.getListCount();
	}
	
	@Override
	public int getSearchListCount(Map<String, String> params) throws SQLException {
		return nm020833DAO.getSearchListCount(params);
	}

	@Override
	public String getBoardType() throws SQLException {
		return nm020833DAO.getBoardType();
	}

	@Override
	public BoardVO getPrevRelease(Map<String, Object> params) throws SQLException {
		return nm020833DAO.getPrevRelease(params);
	}

	@Override
	public BoardVO getNextRelease(Map<String, Object> params) throws SQLException {
		return nm020833DAO.getNextRelease(params);
	}
	
	@Override
	public int modifyHitUp(int b_no) throws SQLException {
		return nm020833DAO.modifyHitUp(b_no);
	}
	
	@Override
	public int setRelease(BoardVO boardVO) throws SQLException {
		return nm020833DAO.setRelease(boardVO);
	}

	@Override
	public void modifyRelease(BoardVO boardVO) throws SQLException {
		nm020833DAO.modifyRelease(boardVO);
	}

	@Override
	public void removeRelease(int b_no) throws SQLException {
		nm020833DAO.removeRelease(b_no);
	}

}
