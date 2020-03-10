package com.patis.NM02.NM021164;

import java.sql.SQLException;
import java.util.List;

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
	public BoardVO getCollusion(int b_no) throws SQLException {
		return nm021164DAO.getCollusion(b_no);
	}

	@Override
	public int getListCount() throws SQLException {
		return nm021164DAO.getListCount();
	}

	@Override
	public String getBoardType() throws SQLException {
		return nm021164DAO.getBoardType();
	}

	@Override
	public BoardVO getPrevCollusion(int b_no) throws SQLException {
		return nm021164DAO.getPrevCollusion(b_no);
	}

	@Override
	public BoardVO getNextCollusion(int b_no) throws SQLException {
		return nm021164DAO.getNextCollusion(b_no);
	}
	
	@Override
	public int modifyHitUp(int b_no) throws SQLException {
		return nm021164DAO.modifyHitUp(b_no);
	}

}
