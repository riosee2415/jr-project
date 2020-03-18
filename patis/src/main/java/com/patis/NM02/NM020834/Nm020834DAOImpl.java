package com.patis.NM02.NM020834;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.BoardVO;

@Repository("nm020834DAO")
public class Nm020834DAOImpl implements I_Nm020834DAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String YARD_OFFICE_NAMESPACE = "Yard_Office-Mapper";
	private static final String YARD_SUPPORT_NAMESPACE = "Yard_Support-Mapper";

	@Override
	public List<BoardVO> getYardOfficeList(int paging) throws SQLException {
		return sqlSession.selectList(YARD_OFFICE_NAMESPACE + ".GET_YARD_OFFICE_LIST", paging);
	}
	
	@Override
	public List<BoardVO> getYardOfficeSearchList(Map<String, Object> params) throws SQLException {
		return sqlSession.selectList(YARD_OFFICE_NAMESPACE + ".GET_YARD_OFFICE_SEARCH_LIST", params);
	}

	@Override
	public BoardVO getYardOffice(int b_no) throws SQLException {
		return sqlSession.selectOne(YARD_OFFICE_NAMESPACE + ".GET_YARD_OFFICE", b_no);
	}

	@Override
	public int getYardOfficeListCount() throws SQLException {
		return sqlSession.selectOne(YARD_OFFICE_NAMESPACE + ".GET_YARD_OFFICE_LIST_COUNT");
	}
	
	@Override
	public int getYardOfficeSearchListCount(Map<String, String> params) throws SQLException {
		return sqlSession.selectOne(YARD_OFFICE_NAMESPACE + ".GET_YARD_OFFICE_SEARCH_LIST_COUNT", params);
	}

	@Override
	public String getYardOfficeBoardType() throws SQLException {
		String boardType = sqlSession.selectOne(YARD_OFFICE_NAMESPACE + ".GET_YARD_OFFICE_BOARD_TYPE");
		if(boardType == null)
			boardType = YARD_OFFICE_NAMESPACE.replace("-Mapper", "").toUpperCase();
		return boardType;
	}

	@Override
	public BoardVO getPrevYardOffice(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(YARD_OFFICE_NAMESPACE + ".GET_PREV_YARD_OFFICE", params);
	}
	
	@Override
	public BoardVO getNextYardOffice(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(YARD_OFFICE_NAMESPACE + ".GET_NEXT_YARD_OFFICE", params);
	}

	@Override
	public int modifyYardOfficeHitUp(int b_no) throws SQLException {
		return sqlSession.update(YARD_OFFICE_NAMESPACE + ".MODIFY_YARD_OFFICE_HIT_UP", b_no);
	}
	
	@Override
	public int setYardOffice(BoardVO boardVO) throws SQLException {
		return sqlSession.insert(YARD_OFFICE_NAMESPACE + ".SET_YARD_OFFICE", boardVO);
	}

	@Override
	public void modifyYardOffice(BoardVO boardVO) throws SQLException {
		sqlSession.update(YARD_OFFICE_NAMESPACE + ".MODIFY_YARD_OFFICE", boardVO);
	}

	@Override
	public void removeYardOffice(int b_no) throws SQLException {
		sqlSession.delete(YARD_OFFICE_NAMESPACE + ".REMOVE_YARD_OFFICE", b_no);
	}
	

	
	
	@Override
	public List<BoardVO> getYardSupportList(int paging) throws SQLException {
		return sqlSession.selectList(YARD_SUPPORT_NAMESPACE + ".GET_YARD_SUPPORT_LIST", paging);
	}
	
	@Override
	public List<BoardVO> getYardSupportSearchList(Map<String, Object> params) throws SQLException {
		return sqlSession.selectList(YARD_SUPPORT_NAMESPACE + ".GET_YARD_SUPPORT_SEARCH_LIST", params);
	}

	@Override
	public BoardVO getYardSupport(int b_no) throws SQLException {
		return sqlSession.selectOne(YARD_SUPPORT_NAMESPACE + ".GET_YARD_SUPPORT", b_no);
	}

	@Override
	public int getYardSupportListCount() throws SQLException {
		return sqlSession.selectOne(YARD_SUPPORT_NAMESPACE + ".GET_YARD_SUPPORT_LIST_COUNT");
	}
	
	@Override
	public int getYardSupportSearchListCount(Map<String, String> params) throws SQLException {
		return sqlSession.selectOne(YARD_SUPPORT_NAMESPACE + ".GET_YARD_SUPPORT_SEARCH_LIST_COUNT", params);
	}

	@Override
	public String getYardSupportBoardType() throws SQLException {
		String boardType = sqlSession.selectOne(YARD_SUPPORT_NAMESPACE + ".GET_YARD_SUPPORT_BOARD_TYPE");
		if(boardType == null)
			boardType = YARD_SUPPORT_NAMESPACE.replace("-Mapper", "").toUpperCase();
		return boardType;
	}

	@Override
	public BoardVO getPrevYardSupport(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(YARD_SUPPORT_NAMESPACE + ".GET_PREV_YARD_SUPPORT", params);
	}
	
	@Override
	public BoardVO getNextYardSupport(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(YARD_SUPPORT_NAMESPACE + ".GET_NEXT_YARD_SUPPORT", params);
	}

	@Override
	public int modifyYardSupportHitUp(int b_no) throws SQLException {
		return sqlSession.update(YARD_SUPPORT_NAMESPACE + ".MODIFY_YARD_SUPPORT_HIT_UP", b_no);
	}
	
	@Override
	public int setYardSupport(BoardVO boardVO) throws SQLException {
		return sqlSession.insert(YARD_SUPPORT_NAMESPACE + ".SET_YARD_SUPPORT", boardVO);
	}

	@Override
	public void modifyYardSupport(BoardVO boardVO) throws SQLException {
		sqlSession.update(YARD_SUPPORT_NAMESPACE + ".MODIFY_YARD_SUPPORT", boardVO);
	}

	@Override
	public void removeYardSupport(int b_no) throws SQLException {
		sqlSession.delete(YARD_SUPPORT_NAMESPACE + ".REMOVE_YARD_SUPPORT", b_no);
	}

}
