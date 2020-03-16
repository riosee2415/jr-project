package com.patis.NM02.NM021037;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.BoardVO;

@Service("nm021037Service")
public class Nm021037ServiceImpl implements I_Nm021037Service{
	
	@Resource(name = "nm021037DAO")
	private  I_Nm021037DAO nm021037DAO;

	@Override
	public List<BoardVO> getEduOfficeList(int paging) throws SQLException {
		return nm021037DAO.getEduOfficeList(paging);
	}

	@Override
	public List<BoardVO> getEduOfficeSearchList(Map<String, Object> params) throws SQLException {
		return nm021037DAO.getEduOfficeSearchList(params);
	}

	@Override
	public BoardVO getEduOffice(int b_no) throws SQLException {
		return nm021037DAO.getEduOffice(b_no);
	}

	@Override
	public int getEduOfficeListCount() throws SQLException {
		return nm021037DAO.getEduOfficeListCount();
	}

	@Override
	public int getEduOfficeSearchListCount(Map<String, String> params) throws SQLException {
		return nm021037DAO.getEduOfficeSearchListCount(params);
	}

	@Override
	public String getEduOfficeBoardType() throws SQLException {
		return nm021037DAO.getEduOfficeBoardType();
	}

	@Override
	public BoardVO getPrevEduOffice(Map<String, Object> params) throws SQLException {
		return nm021037DAO.getPrevEduOffice(params);
	}

	@Override
	public BoardVO getNextEduOffice(Map<String, Object> params) throws SQLException {
		return nm021037DAO.getNextEduOffice(params);
	}

	@Override
	public int modifyEduOfficeHitUp(int b_no) throws SQLException {
		return nm021037DAO.modifyEduOfficeHitUp(b_no);
	}

	@Override
	public int setEduOffice(BoardVO boardVO) throws SQLException {
		return nm021037DAO.setEduOffice(boardVO);
	}

	@Override
	public void modifyEduOffice(BoardVO boardVO) throws SQLException {
		nm021037DAO.modifyEduOffice(boardVO);
	}

	@Override
	public void removeEduOffice(int b_no) throws SQLException {
		nm021037DAO.removeEduOffice(b_no);
	}
	
	
	
	
	@Override
	public List<BoardVO> getEduSupportList(int paging) throws SQLException {
		return nm021037DAO.getEduSupportList(paging);
	}

	@Override
	public List<BoardVO> getEduSupportSearchList(Map<String, Object> params) throws SQLException {
		return nm021037DAO.getEduSupportSearchList(params);
	}

	@Override
	public BoardVO getEduSupport(int b_no) throws SQLException {
		return nm021037DAO.getEduSupport(b_no);
	}

	@Override
	public int getEduSupportListCount() throws SQLException {
		return nm021037DAO.getEduSupportListCount();
	}

	@Override
	public int getEduSupportSearchListCount(Map<String, String> params) throws SQLException {
		return nm021037DAO.getEduSupportSearchListCount(params);
	}

	@Override
	public String getEduSupportBoardType() throws SQLException {
		return nm021037DAO.getEduSupportBoardType();
	}

	@Override
	public BoardVO getPrevEduSupport(Map<String, Object> params) throws SQLException {
		return nm021037DAO.getPrevEduSupport(params);
	}

	@Override
	public BoardVO getNextEduSupport(Map<String, Object> params) throws SQLException {
		return nm021037DAO.getNextEduSupport(params);
	}

	@Override
	public int modifyEduSupportHitUp(int b_no) throws SQLException {
		return nm021037DAO.modifyEduSupportHitUp(b_no);
	}

	@Override
	public int setEduSupport(BoardVO boardVO) throws SQLException {
		return nm021037DAO.setEduSupport(boardVO);
	}

	@Override
	public void modifyEduSupport(BoardVO boardVO) throws SQLException {
		nm021037DAO.modifyEduSupport(boardVO);
	}

	@Override
	public void removeEduSupport(int b_no) throws SQLException {
		nm021037DAO.removeEduSupport(b_no);
	}


}
