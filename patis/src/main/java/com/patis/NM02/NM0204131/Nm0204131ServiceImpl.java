package com.patis.NM02.NM0204131;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.BoardVO;

@Service("nm0204131Service")
public class Nm0204131ServiceImpl implements I_Nm0204131Service{
	
	@Resource(name = "nm0204131DAO")
	private  I_Nm0204131DAO nm0204131DAO;

	@Override
	public List<BoardVO> getStatuteList(int paging) throws SQLException {
		return nm0204131DAO.getStatuteList(paging);
	}

	@Override
	public BoardVO getStatute(int b_no) throws SQLException {
		return nm0204131DAO.getStatute(b_no);
	}
	
	@Override
	public int getListCount() throws SQLException {
		return nm0204131DAO.getListCount();
	}

	@Override
	public String getBoardType() throws SQLException {
		return nm0204131DAO.getBoardType();
	}
	
	@Override
	public BoardVO getPrevStatute(int b_no) throws SQLException {
		return nm0204131DAO.getPrevStatute(b_no);
	}

	@Override
	public BoardVO getNextStatute(int b_no) throws SQLException {
		return nm0204131DAO.getNextStatute(b_no);
	}

	@Override
	public int modifyHitUp(int b_no) throws SQLException {
		return nm0204131DAO.modifyHitUp(b_no);
	}

}
