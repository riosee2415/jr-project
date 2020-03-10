package com.patis.NM02.NM0204131;

import java.sql.SQLException;
import java.util.List;

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
	public BoardVO getStatute(int b_no) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_STATUTE", b_no);
	}
	
	@Override
	public int getListCount() throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_LIST_COUNT");
	}	
	
	@Override
	public String getBoardType() throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_BOARD_TYPE");
	}

	@Override
	public BoardVO getPrevStatute(int b_no) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_PREV_STATUTE", b_no);
	}

	@Override
	public BoardVO getNextStatute(int b_no) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_NEXT_STATUTE", b_no);
	}

	@Override
	public int modifyHitUp(int b_no) throws SQLException {
		return sqlSession.update(NAMESPACE + ".MODIFY_HIT_UP", b_no);
	}

}
