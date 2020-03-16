package com.patis.middleware;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.Accept_typeVO;
import com.patis.model.CommonVO;

@Repository("middlewareDAO")
public class MiddlewareDAOImpl implements I_MiddlewareDAO {

	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String COMMON_NAMESPACE = "Common-Mapper";
	private static final String ACCEPT_NAMESPACE = "AcceptRight-Mapper";
	
	@Override
	public List<CommonVO> selectCommonList() throws SQLException {
		return sqlSession.selectList(COMMON_NAMESPACE + ".selectCommonList");
	}

	@Override
	public List<CommonVO> getMenu() throws SQLException {
		return sqlSession.selectList(COMMON_NAMESPACE + ".GET_MENU");
	}

	@Override
	public List<CommonVO> getSubMenu() throws SQLException {
		return sqlSession.selectList(COMMON_NAMESPACE + ".GET_SUB_MENU");
	}

	@Override
	public List<CommonVO> getDetailMenu() throws SQLException {
		return sqlSession.selectList(COMMON_NAMESPACE + ".GET_DETAIL_MENU");
	}

	@Override
	public Accept_typeVO getAcceptRight(String BOARD_TYPE) throws SQLException {
		return sqlSession.selectOne(ACCEPT_NAMESPACE + ".GET_ACCEPT_RIGHT", BOARD_TYPE);
	}

	@Override
	public List<CommonVO> getComboData(String code) throws SQLException {
		return sqlSession.selectList(COMMON_NAMESPACE + ".GET_COMBO_DATA", code);
	}

}
