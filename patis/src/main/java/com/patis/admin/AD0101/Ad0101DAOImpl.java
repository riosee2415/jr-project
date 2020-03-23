package com.patis.admin.AD0101;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.LoginLogVO;

@Repository("ad0101DAO")
public class Ad0101DAOImpl implements I_Ad0101DAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "LoginLog-Mapper";

	@Override
	public List<LoginLogVO> getLogData(int paging) {
		return sqlSession.selectList(NAMESPACE + ".GET_LOGINLOG", paging);
	}

	@Override
	public int getListCount() {
		return sqlSession.selectOne(NAMESPACE + ".GET_COUNT");
	}
	
	@Override
	public String getTodayLoginData(String today) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".GET_LOGIN_DATA_TODAY", today);
	}

	@Override
	public List<LoginLogVO> getTodayDetailLoginData(String today) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".GET_DETAIL_LOGIN_DATA_TODAY", today);
	}

	@Override
	public List<LoginLogVO> getSearchDetailLoginData(Map<String, String> params) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".GET_SEARCH_DETAIL_LOGIN_DATA_TODAY", params);
	}

	@Override
	public String getSearchLoginData(Map<String, String> params) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".GET_LOGIN_DATA_SEARCH", params);
	} 

}
