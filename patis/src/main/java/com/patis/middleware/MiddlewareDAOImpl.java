package com.patis.middleware;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.CommonVO;

@Repository("middlewareDAO")
public class MiddlewareDAOImpl implements I_MiddlewareDAO {

	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "Common-Mapper";
	
	@Override
	public List<CommonVO> selectCommonList() throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".selectCommonList");
	}

	@Override
	public List<CommonVO> getMenu() throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".GET_MENU");
	}

	@Override
	public List<CommonVO> getSubMenu() throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".GET_SUB_MENU");
	}

}
