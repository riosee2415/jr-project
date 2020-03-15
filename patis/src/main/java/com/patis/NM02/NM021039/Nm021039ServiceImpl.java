package com.patis.NM02.NM021039;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.BoardVO;

@Service("nm021039Service")
public class Nm021039ServiceImpl implements I_Nm021039Service{
	
	@Resource(name = "nm021039DAO")
	private  I_Nm021039DAO nm021039DAO;

	@Override
	public List<BoardVO> getPresentationList(int paging) throws SQLException {
		return nm021039DAO.getPresentationList(paging);
	}
	
	@Override
	public List<BoardVO> getPresentationSearchList(Map<String, Object> params) throws SQLException {
		return nm021039DAO.getPresentationSearchList(params);
	}

	@Override
	public BoardVO getPresentation(int b_no) throws SQLException {
		return nm021039DAO.getPresentation(b_no);
	}

	@Override
	public int getListCount() throws SQLException {
		return nm021039DAO.getListCount();
	}
	
	@Override
	public int getSearchListCount(Map<String, String> params) throws SQLException {
		return nm021039DAO.getSearchListCount(params);
	}

	@Override
	public String getBoardType() throws SQLException {
		return nm021039DAO.getBoardType();
	}

	@Override
	public BoardVO getPrevPresentation(Map<String, Object> params) throws SQLException {
		return nm021039DAO.getPrevPresentation(params);
	}

	@Override
	public BoardVO getNextPresentation(Map<String, Object> params) throws SQLException {
		return nm021039DAO.getNextPresentation(params);
	}
	
	@Override
	public int modifyHitUp(int b_no) throws SQLException {
		return nm021039DAO.modifyHitUp(b_no);
	}
	
	@Override
	public int setPresentation(BoardVO boardVO) throws SQLException {
		return nm021039DAO.setPresentation(boardVO);
	}

	@Override
	public void modifyPresentation(BoardVO boardVO) throws SQLException {
		nm021039DAO.modifyPresentation(boardVO);
	}

	@Override
	public void removePresentation(int b_no) throws SQLException {
		nm021039DAO.removePresentation(b_no);
	}

}
