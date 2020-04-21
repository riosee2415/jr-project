package com.patis.NM02.NM020834;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.BoardVO;

@Service("nm020834Service")
public class Nm020834ServiceImpl implements I_Nm020834Service{
	
	@Resource(name = "nm020834DAO")
	private  I_Nm020834DAO nm020834DAO;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Apr 21, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 구청 게시판 목록 조회(메인)
	 */
	public List<BoardVO> getYardOfficeMainList() throws SQLException {
		return nm020834DAO.getYardOfficeMainList();
	}
	
	@Override
	public List<BoardVO> getYardOfficeList(int paging) throws SQLException {
		return nm020834DAO.getYardOfficeList(paging);
	}

	@Override
	public List<BoardVO> getYardOfficeSearchList(Map<String, Object> params) throws SQLException {
		return nm020834DAO.getYardOfficeSearchList(params);
	}

	@Override
	public BoardVO getYardOffice(int b_no) throws SQLException {
		return nm020834DAO.getYardOffice(b_no);
	}

	@Override
	public int getYardOfficeListCount() throws SQLException {
		return nm020834DAO.getYardOfficeListCount();
	}

	@Override
	public int getYardOfficeSearchListCount(Map<String, String> params) throws SQLException {
		return nm020834DAO.getYardOfficeSearchListCount(params);
	}

	@Override
	public String getYardOfficeBoardType() throws SQLException {
		return nm020834DAO.getYardOfficeBoardType();
	}

	@Override
	public BoardVO getPrevYardOffice(Map<String, Object> params) throws SQLException {
		return nm020834DAO.getPrevYardOffice(params);
	}

	@Override
	public BoardVO getNextYardOffice(Map<String, Object> params) throws SQLException {
		return nm020834DAO.getNextYardOffice(params);
	}

	@Override
	public int modifyYardOfficeHitUp(int b_no) throws SQLException {
		return nm020834DAO.modifyYardOfficeHitUp(b_no);
	}

	@Override
	public int setYardOffice(BoardVO boardVO) throws SQLException {
		return nm020834DAO.setYardOffice(boardVO);
	}

	@Override
	public void modifyYardOffice(BoardVO boardVO) throws SQLException {
		nm020834DAO.modifyYardOffice(boardVO);
	}

	@Override
	public void removeYardOffice(int b_no) throws SQLException {
		nm020834DAO.removeYardOffice(b_no);
	}
	
	
	
	
	@Override
	public List<BoardVO> getYardSupportList(int paging) throws SQLException {
		return nm020834DAO.getYardSupportList(paging);
	}

	@Override
	public List<BoardVO> getYardSupportSearchList(Map<String, Object> params) throws SQLException {
		return nm020834DAO.getYardSupportSearchList(params);
	}

	@Override
	public BoardVO getYardSupport(int b_no) throws SQLException {
		return nm020834DAO.getYardSupport(b_no);
	}

	@Override
	public int getYardSupportListCount() throws SQLException {
		return nm020834DAO.getYardSupportListCount();
	}

	@Override
	public int getYardSupportSearchListCount(Map<String, String> params) throws SQLException {
		return nm020834DAO.getYardSupportSearchListCount(params);
	}

	@Override
	public String getYardSupportBoardType() throws SQLException {
		return nm020834DAO.getYardSupportBoardType();
	}

	@Override
	public BoardVO getPrevYardSupport(Map<String, Object> params) throws SQLException {
		return nm020834DAO.getPrevYardSupport(params);
	}

	@Override
	public BoardVO getNextYardSupport(Map<String, Object> params) throws SQLException {
		return nm020834DAO.getNextYardSupport(params);
	}

	@Override
	public int modifyYardSupportHitUp(int b_no) throws SQLException {
		return nm020834DAO.modifyYardSupportHitUp(b_no);
	}

	@Override
	public int setYardSupport(BoardVO boardVO) throws SQLException {
		return nm020834DAO.setYardSupport(boardVO);
	}

	@Override
	public void modifyYardSupport(BoardVO boardVO) throws SQLException {
		nm020834DAO.modifyYardSupport(boardVO);
	}

	@Override
	public void removeYardSupport(int b_no) throws SQLException {
		nm020834DAO.removeYardSupport(b_no);
	}
	
}
