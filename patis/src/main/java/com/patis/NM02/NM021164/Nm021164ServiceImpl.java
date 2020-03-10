package com.patis.NM02.NM021164;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.BoardVO;

@Service("nm021164Service")
public class Nm021164ServiceImpl implements I_Nm021164Service{
	
	@Resource(name = "nm021164DAO")
	private  I_Nm021164DAO nm021164DAO;

	@Override
	public List<BoardVO> getCollusionList(int paging) throws SQLException {
		return nm021164DAO.getCollusionList(paging);
	}
	
	@Override
	public List<BoardVO> getCollusionSearchList(Map<String, Object> params) throws SQLException {
		return nm021164DAO.getCollusionSearchList(params);
	}

	@Override
	public BoardVO getCollusion(int b_no) throws SQLException {
		return nm021164DAO.getCollusion(b_no);
	}

	@Override
	public int getListCount() throws SQLException {
		return nm021164DAO.getListCount();
	}
	
	@Override
	public int getSearchListCount(Map<String, String> params) throws SQLException {
		return nm021164DAO.getSearchListCount(params);
	}

	@Override
	public String getBoardType() throws SQLException {
		return nm021164DAO.getBoardType();
	}

	@Override
	public BoardVO getPrevCollusion(Map<String, Object> params) throws SQLException {
		return nm021164DAO.getPrevCollusion(params);
	}

	@Override
	public BoardVO getNextCollusion(Map<String, Object> params) throws SQLException {
		return nm021164DAO.getNextCollusion(params);
	}
	
	@Override
	public int modifyHitUp(int b_no) throws SQLException {
		return nm021164DAO.modifyHitUp(b_no);
	}

}
