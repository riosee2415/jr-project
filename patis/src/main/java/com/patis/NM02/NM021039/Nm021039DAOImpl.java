package com.patis.NM02.NM021039;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.BoardVO;

@Repository("nm021039DAO")
public class Nm021039DAOImpl implements I_Nm021039DAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "Presentation-Mapper";

	@Override
	public List<BoardVO> getPresentationList(int paging) throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".GET_PRESENTATION_LIST", paging);
	}
	
	@Override
	public List<BoardVO> getPresentationSearchList(Map<String, Object> params) throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".GET_PRESENTATION_SEARCH_LIST", params);
	}

	@Override
	public BoardVO getPresentation(int b_no) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_PRESENTATION", b_no);
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
	public BoardVO getPrevPresentation(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_PREV_PRESENTATION", params);
	}
	
	@Override
	public BoardVO getNextPresentation(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_NEXT_PRESENTATION", params);
	}

	@Override
	public int modifyHitUp(int b_no) throws SQLException {
		return sqlSession.update(NAMESPACE + ".MODIFY_HIT_UP", b_no);
	}
	
	@Override
	public int setPresentation(BoardVO boardVO) throws SQLException {
		return sqlSession.insert(NAMESPACE + ".SET_PRESENTATION", boardVO);
	}

	@Override
	public void modifyPresentation(BoardVO boardVO) throws SQLException {
		sqlSession.update(NAMESPACE + ".MODIFY_PRESENTATION", boardVO);
	}

	@Override
	public void removePresentation(int b_no) throws SQLException {
		sqlSession.delete(NAMESPACE + ".REMOVE_PRESENTATION", b_no);
	}

}
