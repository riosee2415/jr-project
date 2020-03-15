package com.patis.NM02.NM020835;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.BoardVO;

@Repository("nm020835DAO")
public class Nm020835DAOImpl implements I_Nm020835DAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "Hire-Mapper";

	@Override
	public List<BoardVO> getHireList(int paging) throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".GET_HIRE_LIST", paging);
	}
	
	@Override
	public List<BoardVO> getHireSearchList(Map<String, Object> params) throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".GET_HIRE_SEARCH_LIST", params);
	}

	@Override
	public BoardVO getHire(int b_no) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_HIRE", b_no);
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
	public BoardVO getPrevHire(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_PREV_HIRE", params);
	}
	
	@Override
	public BoardVO getNextHire(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_NEXT_HIRE", params);
	}

	@Override
	public int modifyHitUp(int b_no) throws SQLException {
		return sqlSession.update(NAMESPACE + ".MODIFY_HIT_UP", b_no);
	}
	
	@Override
	public int setHire(BoardVO boardVO) throws SQLException {
		return sqlSession.insert(NAMESPACE + ".SET_HIRE", boardVO);
	}

	@Override
	public void modifyHire(BoardVO boardVO) throws SQLException {
		sqlSession.update(NAMESPACE + ".MODIFY_HIRE", boardVO);
	}

	@Override
	public void removeHire(int b_no) throws SQLException {
		sqlSession.delete(NAMESPACE + ".REMOVE_HIRE", b_no);
	}

}
