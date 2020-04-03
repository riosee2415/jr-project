package com.patis.NM02.NM020524;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.BoardVO;

@Repository("nm020524DAO")
public class Nm020524DAOImpl implements I_Nm020524DAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "Community-Mapper";

	@Override
	public List<BoardVO> getCommunityList(int paging) throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".GET_COMMUNITY_LIST", paging);
	}
	
	@Override
	public List<BoardVO> getCommunitySearchList(Map<String, Object> params) throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".GET_COMMUNITY_SEARCH_LIST", params);
	}

	@Override
	public BoardVO getCommunity(int b_no) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_COMMUNITY", b_no);
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
	public BoardVO getPrevCommunity(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_PREV_COMMUNITY", params);
	}
	
	@Override
	public BoardVO getNextCommunity(Map<String, Object> params) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_NEXT_COMMUNITY", params);
	}

	@Override
	public int modifyHitUp(int b_no) throws SQLException {
		return sqlSession.update(NAMESPACE + ".MODIFY_HIT_UP", b_no);
	}
	
	@Override
	public int setCommunity(BoardVO boardVO) throws SQLException {
		return sqlSession.insert(NAMESPACE + ".SET_COMMUNITY", boardVO);
	}

	@Override
	public void modifyCommunity(BoardVO boardVO) throws SQLException {
		sqlSession.update(NAMESPACE + ".MODIFY_COMMUNITY", boardVO);
	}

	@Override
	public void removeCommunity(int b_no) throws SQLException {
		sqlSession.delete(NAMESPACE + ".REMOVE_COMMUNITY", b_no);
	}

	@Override
	public void setCommunityReply(BoardVO boardVO) throws SQLException {
		sqlSession.update(NAMESPACE + ".setCommunityReply", boardVO);
	}

	@Override
	public void modifyCommunityReply(BoardVO boardVO) throws SQLException {
		sqlSession.update(NAMESPACE + ".modifyCommunityReply", boardVO);
	}

	@Override
	public void removeCommunityReply(int b_no) throws SQLException {
		sqlSession.update(NAMESPACE + ".removeCommunityReply", b_no);
	}

}
