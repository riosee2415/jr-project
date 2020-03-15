package com.patis.admin.AD0102;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("ad0102DAO")
public class Ad0102DAOImpl implements I_Ad0102DAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "AdminConnectReport-Mapper";

	@Override
	public String getTodayConnectData(String today) {
		return sqlSession.selectOne(NAMESPACE + ".GET_CONNECT_DATA_TODAY", today);
	}

}
