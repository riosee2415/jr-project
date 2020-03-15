package com.patis.NM02.NM020835;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.BoardVO;

@Service("nm020835Service")
public class Nm020835ServiceImpl implements I_Nm020835Service{
	
	@Resource(name = "nm020835DAO")
	private  I_Nm020835DAO nm020835DAO;

	@Override
	public List<BoardVO> getHireList(int paging) throws SQLException {
		return nm020835DAO.getHireList(paging);
	}
	
	@Override
	public List<BoardVO> getHireSearchList(Map<String, Object> params) throws SQLException {
		return nm020835DAO.getHireSearchList(params);
	}

	@Override
	public BoardVO getHire(int b_no) throws SQLException {
		return nm020835DAO.getHire(b_no);
	}

	@Override
	public int getListCount() throws SQLException {
		return nm020835DAO.getListCount();
	}
	
	@Override
	public int getSearchListCount(Map<String, String> params) throws SQLException {
		return nm020835DAO.getSearchListCount(params);
	}

	@Override
	public String getBoardType() throws SQLException {
		return nm020835DAO.getBoardType();
	}

	@Override
	public BoardVO getPrevHire(Map<String, Object> params) throws SQLException {
		return nm020835DAO.getPrevHire(params);
	}

	@Override
	public BoardVO getNextHire(Map<String, Object> params) throws SQLException {
		return nm020835DAO.getNextHire(params);
	}
	
	@Override
	public int modifyHitUp(int b_no) throws SQLException {
		return nm020835DAO.modifyHitUp(b_no);
	}
	
	@Override
	public int setHire(BoardVO boardVO) throws SQLException {
		return nm020835DAO.setHire(boardVO);
	}

	@Override
	public void modifyHire(BoardVO boardVO) throws SQLException {
		nm020835DAO.modifyHire(boardVO);
	}

	@Override
	public void removeHire(int b_no) throws SQLException {
		nm020835DAO.removeHire(b_no);
	}

}
