package com.patis.NM02.NM021164;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.BoardVO;

@Repository("nm021164DAO")
public class Nm021164DAOImpl implements I_Nm021164DAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "Collusion-Mapper";

	@Override
	public List<BoardVO> getCollusionList(int paging) throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".GET_COLLUSION_LIST", paging);
	}
	
	@Override
	public List<BoardVO> getCollusionSearchList(Map<String, Object> params) throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".GET_COLLUSION_SEARCH_LIST", params);
	}

	@Override
	public BoardVO getCollusion(int b_no) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_COLLUSION", b_no);
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
	public BoardVO getPrevCollusion(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_PREV_COLLUSION", params);
	}
	
	@Override
	public BoardVO getNextCollusion(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_NEXT_COLLUSION", params);
	}

	@Override
	public int modifyHitUp(int b_no) throws SQLException {
		return sqlSession.update(NAMESPACE + ".MODIFY_HIT_UP", b_no);
	}
	
	@Override
	public int setCollusion(BoardVO boardVO) throws SQLException {
		return sqlSession.insert(NAMESPACE + ".SET_COLLUSION", boardVO);
	}

	@Override
	public void modifyCollusion(BoardVO boardVO) throws SQLException {
		sqlSession.update(NAMESPACE + ".MODIFY_COLLUSION", boardVO);
	}

	@Override
	public void removeCollusion(int b_no) throws SQLException {
		sqlSession.delete(NAMESPACE + ".REMOVE_COLLUSION", b_no);
	}

}
