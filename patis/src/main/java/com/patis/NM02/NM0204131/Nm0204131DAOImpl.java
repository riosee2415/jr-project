package com.patis.NM02.NM0204131;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.BoardVO;

@Repository("nm0204131DAO")
public class Nm0204131DAOImpl implements I_Nm0204131DAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "Statute-Mapper";

	@Override
	public List<BoardVO> getStatuteList(int paging) throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".GET_STATUTE_LIST", paging);
	}
	
	@Override
	public List<BoardVO> getStatuteSearchList(Map<String, Object> params) throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".GET_STATUTE_SEARCH_LIST", params);
	}

	@Override
	public BoardVO getStatute(int b_no) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_STATUTE", b_no);
	}

	@Override
	public int getListCount() throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_LIST_COUNT");
	}
	
	@Override
	public int getSearchListCount(Map<String, String> params) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_SEARCH_LIST_COUNT", params);
	}

	@Override
	public String getBoardType() throws SQLException {
		String boardType = sqlSession.selectOne(NAMESPACE + ".GET_BOARD_TYPE");
		if(boardType == null)
			boardType = NAMESPACE.replace("-Mapper", "").toUpperCase();
		return boardType;
	}

	@Override
	public BoardVO getPrevStatute(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_PREV_STATUTE", params);
	}
	
	@Override
	public BoardVO getNextStatute(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_NEXT_STATUTE", params);
	}

	@Override
	public int modifyHitUp(int b_no) throws SQLException {
		return sqlSession.update(NAMESPACE + ".MODIFY_HIT_UP", b_no);
	}
	
	@Override
	public int setStatute(BoardVO boardVO) throws SQLException {
		return sqlSession.insert(NAMESPACE + ".SET_STATUTE", boardVO);
	}

	@Override
	public void modifyStatute(BoardVO boardVO) throws SQLException {
		sqlSession.update(NAMESPACE + ".MODIFY_STATUTE", boardVO);
	}

	@Override
	public void removeStatute(int b_no) throws SQLException {
		sqlSession.delete(NAMESPACE + ".REMOVE_STATUTE", b_no);
	}

}
