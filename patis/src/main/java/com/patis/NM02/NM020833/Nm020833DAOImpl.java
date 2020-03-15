package com.patis.NM02.NM020833;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.BoardVO;

@Repository("nm020833DAO")
public class Nm020833DAOImpl implements I_Nm020833DAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "Release-Mapper";

	@Override
	public List<BoardVO> getReleaseList(int paging) throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".GET_RELEASE_LIST", paging);
	}
	
	@Override
	public List<BoardVO> getReleaseSearchList(Map<String, Object> params) throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".GET_RELEASE_SEARCH_LIST", params);
	}

	@Override
	public BoardVO getRelease(int b_no) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_RELEASE", b_no);
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
	public BoardVO getPrevRelease(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_PREV_RELEASE", params);
	}
	
	@Override
	public BoardVO getNextRelease(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_NEXT_RELEASE", params);
	}

	@Override
	public int modifyHitUp(int b_no) throws SQLException {
		return sqlSession.update(NAMESPACE + ".MODIFY_HIT_UP", b_no);
	}
	
	@Override
	public int setRelease(BoardVO boardVO) throws SQLException {
		return sqlSession.insert(NAMESPACE + ".SET_RELEASE", boardVO);
	}

	@Override
	public void modifyRelease(BoardVO boardVO) throws SQLException {
		sqlSession.update(NAMESPACE + ".MODIFY_RELEASE", boardVO);
	}

	@Override
	public void removeRelease(int b_no) throws SQLException {
		sqlSession.delete(NAMESPACE + ".REMOVE_RELEASE", b_no);
	}

}
