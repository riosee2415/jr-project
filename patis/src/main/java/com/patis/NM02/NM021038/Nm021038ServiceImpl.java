package com.patis.NM02.NM021038;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.BoardVO;

@Service("nm021038Service")
public class Nm021038ServiceImpl implements I_Nm021038Service{
	
	@Resource(name = "nm021038DAO")
	private  I_Nm021038DAO nm021038DAO;

	@Override
	public List<BoardVO> getCalendarList(int paging) throws SQLException {
		return nm021038DAO.getCalendarList(paging);
	}

	@Override
	public List<BoardVO> getCalendarSearchList(Map<String, Object> params) throws SQLException {
		return nm021038DAO.getCalendarSearchList(params);
	}

	@Override
	public BoardVO getCalendar(int b_no) throws SQLException {
		return nm021038DAO.getCalendar(b_no);
	}

	@Override
	public int getCalendarListCount() throws SQLException {
		return nm021038DAO.getCalendarListCount();
	}

	@Override
	public int getCalendarSearchListCount(Map<String, String> params) throws SQLException {
		return nm021038DAO.getCalendarSearchListCount(params);
	}

	@Override
	public String getCalendarBoardType() throws SQLException {
		return nm021038DAO.getCalendarBoardType();
	}

	@Override
	public BoardVO getPrevCalendar(Map<String, Object> params) throws SQLException {
		return nm021038DAO.getPrevCalendar(params);
	}

	@Override
	public BoardVO getNextCalendar(Map<String, Object> params) throws SQLException {
		return nm021038DAO.getNextCalendar(params);
	}

	@Override
	public int modifyCalendarHitUp(int b_no) throws SQLException {
		return nm021038DAO.modifyCalendarHitUp(b_no);
	}

	@Override
	public int setCalendar(BoardVO boardVO) throws SQLException {
		return nm021038DAO.setCalendar(boardVO);
	}

	@Override
	public void modifyCalendar(BoardVO boardVO) throws SQLException {
		nm021038DAO.modifyCalendar(boardVO);
	}

	@Override
	public void removeCalendar(int b_no) throws SQLException {
		nm021038DAO.removeCalendar(b_no);
	}
	
	
	
	
	@Override
	public List<BoardVO> getCalendarApplyList(int paging) throws SQLException {
		return nm021038DAO.getCalendarApplyList(paging);
	}

	@Override
	public List<BoardVO> getCalendarApplySearchList(Map<String, Object> params) throws SQLException {
		return nm021038DAO.getCalendarApplySearchList(params);
	}

	@Override
	public BoardVO getCalendarApply(int b_no) throws SQLException {
		return nm021038DAO.getCalendarApply(b_no);
	}

	@Override
	public int getCalendarApplyListCount() throws SQLException {
		return nm021038DAO.getCalendarApplyListCount();
	}

	@Override
	public int getCalendarApplySearchListCount(Map<String, String> params) throws SQLException {
		return nm021038DAO.getCalendarApplySearchListCount(params);
	}

	@Override
	public String getCalendarApplyBoardType() throws SQLException {
		return nm021038DAO.getCalendarApplyBoardType();
	}

	@Override
	public BoardVO getPrevCalendarApply(Map<String, Object> params) throws SQLException {
		return nm021038DAO.getPrevCalendarApply(params);
	}

	@Override
	public BoardVO getNextCalendarApply(Map<String, Object> params) throws SQLException {
		return nm021038DAO.getNextCalendarApply(params);
	}

	@Override
	public int modifyCalendarApplyHitUp(int b_no) throws SQLException {
		return nm021038DAO.modifyCalendarApplyHitUp(b_no);
	}

	@Override
	public int setCalendarApply(BoardVO boardVO) throws SQLException {
		return nm021038DAO.setCalendarApply(boardVO);
	}

	@Override
	public void modifyCalendarApply(BoardVO boardVO) throws SQLException {
		nm021038DAO.modifyCalendarApply(boardVO);
	}

	@Override
	public void removeCalendarApply(int b_no) throws SQLException {
		nm021038DAO.removeCalendarApply(b_no);
	}


}
