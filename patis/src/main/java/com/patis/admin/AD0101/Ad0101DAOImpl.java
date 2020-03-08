package com.patis.admin.AD0101;

import java.util.List;

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

}
