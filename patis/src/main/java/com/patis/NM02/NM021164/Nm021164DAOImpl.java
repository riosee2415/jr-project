package com.patis.NM02.NM021164;

import java.sql.SQLException;
import java.util.List;

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
	public BoardVO getCollusion(int b_no) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_COLLUSION", b_no);
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
	public BoardVO getPrevCollusion(int b_no) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_PREV_COLLUSION", b_no);
	}
	
	@Override
	public BoardVO getNextCollusion(int b_no) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_NEXT_COLLUSION", b_no);
	}

	@Override
	public int modifyHitUp(int b_no) throws SQLException {
		return sqlSession.update(NAMESPACE + ".MODIFY_HIT_UP", b_no);
	}

}
