package com.patis.NM02.NM021038;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.BoardVO;

@Repository("nm021038DAO")
public class Nm021038DAOImpl implements I_Nm021038DAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String CALENDAR_NAMESPACE = "Calendar-Mapper";
	private static final String CALENDAR_APPLY_NAMESPACE = "Calendar_Apply-Mapper";

	@Override
	public List<BoardVO> getCalendarList(int paging) throws SQLException {
		return sqlSession.selectList(CALENDAR_NAMESPACE + ".GET_CALENDAR_LIST", paging);
	}
	
	@Override
	public List<BoardVO> getCalendarSearchList(Map<String, Object> params) throws SQLException {
		return sqlSession.selectList(CALENDAR_NAMESPACE + ".GET_CALENDAR_SEARCH_LIST", params);
	}

	@Override
	public BoardVO getCalendar(int b_no) throws SQLException {
		return sqlSession.selectOne(CALENDAR_NAMESPACE + ".GET_CALENDAR", b_no);
	}

	@Override
	public int getCalendarListCount() throws SQLException {
		return sqlSession.selectOne(CALENDAR_NAMESPACE + ".GET_CALENDAR_LIST_COUNT");
	}
	
	@Override
	public int getCalendarSearchListCount(Map<String, String> params) throws SQLException {
		return sqlSession.selectOne(CALENDAR_NAMESPACE + ".GET_CALENDAR_SEARCH_LIST_COUNT", params);
	}

	@Override
	public String getCalendarBoardType() throws SQLException {
		String boardType = sqlSession.selectOne(CALENDAR_NAMESPACE + ".GET_CALENDAR_BOARD_TYPE");
		if(boardType == null)
			boardType = CALENDAR_NAMESPACE.replace("-Mapper", "").toUpperCase();
		return boardType;
	}

	@Override
	public BoardVO getPrevCalendar(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(CALENDAR_NAMESPACE + ".GET_PREV_CALENDAR", params);
	}
	
	@Override
	public BoardVO getNextCalendar(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(CALENDAR_NAMESPACE + ".GET_NEXT_CALENDAR", params);
	}

	@Override
	public int modifyCalendarHitUp(int b_no) throws SQLException {
		return sqlSession.update(CALENDAR_NAMESPACE + ".MODIFY_CALENDAR_HIT_UP", b_no);
	}
	
	@Override
	public int setCalendar(BoardVO boardVO) throws SQLException {
		return sqlSession.insert(CALENDAR_NAMESPACE + ".SET_CALENDAR", boardVO);
	}

	@Override
	public void modifyCalendar(BoardVO boardVO) throws SQLException {
		sqlSession.update(CALENDAR_NAMESPACE + ".MODIFY_CALENDAR", boardVO);
	}

	@Override
	public void removeCalendar(int b_no) throws SQLException {
		sqlSession.delete(CALENDAR_NAMESPACE + ".REMOVE_CALENDAR", b_no);
	}
	
	
	
	
	@Override
	public List<BoardVO> getCalendarApplyList(int paging) throws SQLException {
		return sqlSession.selectList(CALENDAR_APPLY_NAMESPACE + ".GET_CALENDAR_APPLY_LIST", paging);
	}
	
	@Override
	public List<BoardVO> getCalendarApplySearchList(Map<String, Object> params) throws SQLException {
		return sqlSession.selectList(CALENDAR_APPLY_NAMESPACE + ".GET_CALENDAR_APPLY_SEARCH_LIST", params);
	}

	@Override
	public BoardVO getCalendarApply(int b_no) throws SQLException {
		return sqlSession.selectOne(CALENDAR_APPLY_NAMESPACE + ".GET_CALENDAR_APPLY", b_no);
	}

	@Override
	public int getCalendarApplyListCount() throws SQLException {
		return sqlSession.selectOne(CALENDAR_APPLY_NAMESPACE + ".GET_CALENDAR_APPLY_LIST_COUNT");
	}
	
	@Override
	public int getCalendarApplySearchListCount(Map<String, String> params) throws SQLException {
		return sqlSession.selectOne(CALENDAR_APPLY_NAMESPACE + ".GET_CALENDAR_APPLY_SEARCH_LIST_COUNT", params);
	}

	@Override
	public String getCalendarApplyBoardType() throws SQLException {
		String boardType = sqlSession.selectOne(CALENDAR_APPLY_NAMESPACE + ".GET_CALENDAR_APPLY_BOARD_TYPE");
		if(boardType == null)
			boardType = CALENDAR_APPLY_NAMESPACE.replace("-Mapper", "").toUpperCase();
		return boardType;
	}

	@Override
	public BoardVO getPrevCalendarApply(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(CALENDAR_APPLY_NAMESPACE + ".GET_PREV_CALENDAR_APPLY", params);
	}
	
	@Override
	public BoardVO getNextCalendarApply(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(CALENDAR_APPLY_NAMESPACE + ".GET_NEXT_CALENDAR_APPLY", params);
	}

	@Override
	public int modifyCalendarApplyHitUp(int b_no) throws SQLException {
		return sqlSession.update(CALENDAR_APPLY_NAMESPACE + ".MODIFY_CALENDAR_APPLY_HIT_UP", b_no);
	}
	
	@Override
	public int setCalendarApply(BoardVO boardVO) throws SQLException {
		return sqlSession.insert(CALENDAR_APPLY_NAMESPACE + ".SET_CALENDAR_APPLY", boardVO);
	}

	@Override
	public void modifyCalendarApply(BoardVO boardVO) throws SQLException {
		sqlSession.update(CALENDAR_APPLY_NAMESPACE + ".MODIFY_CALENDAR_APPLY", boardVO);
	}

	@Override
	public void removeCalendarApply(int b_no) throws SQLException {
		sqlSession.delete(CALENDAR_APPLY_NAMESPACE + ".REMOVE_CALENDAR_APPLY", b_no);
	}

}
