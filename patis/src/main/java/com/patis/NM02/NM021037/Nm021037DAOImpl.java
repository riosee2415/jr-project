package com.patis.NM02.NM021037;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.BoardVO;

@Repository("nm021037DAO")
public class Nm021037DAOImpl implements I_Nm021037DAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String EDU_OFFICE_NAMESPACE = "Edu_Office-Mapper";
	private static final String EDU_SUPPORT_NAMESPACE = "Edu_Support-Mapper";

	@Override
	public List<BoardVO> getEduOfficeList(int paging) throws SQLException {
		return sqlSession.selectList(EDU_OFFICE_NAMESPACE + ".GET_EDU_OFFICE_LIST", paging);
	}
	
	@Override
	public List<BoardVO> getEduOfficeSearchList(Map<String, Object> params) throws SQLException {
		return sqlSession.selectList(EDU_OFFICE_NAMESPACE + ".GET_EDU_OFFICE_SEARCH_LIST", params);
	}

	@Override
	public BoardVO getEduOffice(int b_no) throws SQLException {
		return sqlSession.selectOne(EDU_OFFICE_NAMESPACE + ".GET_EDU_OFFICE", b_no);
	}

	@Override
	public int getEduOfficeListCount() throws SQLException {
		return sqlSession.selectOne(EDU_OFFICE_NAMESPACE + ".GET_EDU_OFFICE_LIST_COUNT");
	}
	
	@Override
	public int getEduOfficeSearchListCount(Map<String, String> params) throws SQLException {
		return sqlSession.selectOne(EDU_OFFICE_NAMESPACE + ".GET_EDU_OFFICE_SEARCH_LIST_COUNT", params);
	}

	@Override
	public String getEduOfficeBoardType() throws SQLException {
		String boardType = sqlSession.selectOne(EDU_OFFICE_NAMESPACE + ".GET_EDU_OFFICE_BOARD_TYPE");
		if(boardType == null)
			boardType = EDU_OFFICE_NAMESPACE.replace("-Mapper", "").toUpperCase();
		return boardType;
	}

	@Override
	public BoardVO getPrevEduOffice(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(EDU_OFFICE_NAMESPACE + ".GET_PREV_EDU_OFFICE", params);
	}
	
	@Override
	public BoardVO getNextEduOffice(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(EDU_OFFICE_NAMESPACE + ".GET_NEXT_EDU_OFFICE", params);
	}

	@Override
	public int modifyEduOfficeHitUp(int b_no) throws SQLException {
		return sqlSession.update(EDU_OFFICE_NAMESPACE + ".MODIFY_EDU_OFFICE_HIT_UP", b_no);
	}
	
	@Override
	public int setEduOffice(BoardVO boardVO) throws SQLException {
		return sqlSession.insert(EDU_OFFICE_NAMESPACE + ".SET_EDU_OFFICE", boardVO);
	}

	@Override
	public void modifyEduOffice(BoardVO boardVO) throws SQLException {
		sqlSession.update(EDU_OFFICE_NAMESPACE + ".MODIFY_EDU_OFFICE", boardVO);
	}

	@Override
	public void removeEduOffice(int b_no) throws SQLException {
		sqlSession.delete(EDU_OFFICE_NAMESPACE + ".REMOVE_EDU_OFFICE", b_no);
	}
	
	
	
	
	@Override
	public List<BoardVO> getEduSupportList(int paging) throws SQLException {
		return sqlSession.selectList(EDU_SUPPORT_NAMESPACE + ".GET_EDU_SUPPORT_LIST", paging);
	}
	
	@Override
	public List<BoardVO> getEduSupportSearchList(Map<String, Object> params) throws SQLException {
		return sqlSession.selectList(EDU_SUPPORT_NAMESPACE + ".GET_EDU_SUPPORT_SEARCH_LIST", params);
	}

	@Override
	public BoardVO getEduSupport(int b_no) throws SQLException {
		return sqlSession.selectOne(EDU_SUPPORT_NAMESPACE + ".GET_EDU_SUPPORT", b_no);
	}

	@Override
	public int getEduSupportListCount() throws SQLException {
		return sqlSession.selectOne(EDU_SUPPORT_NAMESPACE + ".GET_EDU_SUPPORT_LIST_COUNT");
	}
	
	@Override
	public int getEduSupportSearchListCount(Map<String, String> params) throws SQLException {
		return sqlSession.selectOne(EDU_SUPPORT_NAMESPACE + ".GET_EDU_SUPPORT_SEARCH_LIST_COUNT", params);
	}

	@Override
	public String getEduSupportBoardType() throws SQLException {
		String boardType = sqlSession.selectOne(EDU_SUPPORT_NAMESPACE + ".GET_EDU_SUPPORT_BOARD_TYPE");
		if(boardType == null)
			boardType = EDU_SUPPORT_NAMESPACE.replace("-Mapper", "").toUpperCase();
		return boardType;
	}

	@Override
	public BoardVO getPrevEduSupport(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(EDU_SUPPORT_NAMESPACE + ".GET_PREV_EDU_SUPPORT", params);
	}
	
	@Override
	public BoardVO getNextEduSupport(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(EDU_SUPPORT_NAMESPACE + ".GET_NEXT_EDU_SUPPORT", params);
	}

	@Override
	public int modifyEduSupportHitUp(int b_no) throws SQLException {
		return sqlSession.update(EDU_SUPPORT_NAMESPACE + ".MODIFY_EDU_SUPPORT_HIT_UP", b_no);
	}
	
	@Override
	public int setEduSupport(BoardVO boardVO) throws SQLException {
		return sqlSession.insert(EDU_SUPPORT_NAMESPACE + ".SET_EDU_SUPPORT", boardVO);
	}

	@Override
	public void modifyEduSupport(BoardVO boardVO) throws SQLException {
		sqlSession.update(EDU_SUPPORT_NAMESPACE + ".MODIFY_EDU_SUPPORT", boardVO);
	}

	@Override
	public void removeEduSupport(int b_no) throws SQLException {
		sqlSession.delete(EDU_SUPPORT_NAMESPACE + ".REMOVE_EDU_SUPPORT", b_no);
	}

}
