package com.patis.admin.AD0102;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.ConnectRecordVO;

@Repository("ad0102DAO")
public class Ad0102DAOImpl implements I_Ad0102DAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "AdminConnectReport-Mapper";

	@Override
	public String getTodayConnectData(String today) {
		return sqlSession.selectOne(NAMESPACE + ".GET_CONNECT_DATA_TODAY", today);
	}

	@Override
	public String getSearchConnectData(Map<String, String> params) {
		return sqlSession.selectOne(NAMESPACE + ".GET_CONNECT_DATA_SEARCH", params);
	}

	@Override
	public List<ConnectRecordVO> getTodayDetailConnectData(String today) {
		return sqlSession.selectList(NAMESPACE + ".GET_DETAIL_CONNECT_DATA_TODAY", today);
	}

	@Override
	public List<ConnectRecordVO> getSearchDetailConnectData(Map<String, String> params) {
		return sqlSession.selectList(NAMESPACE + ".GET_SEARCH_DETAIL_CONNECT_DATA_TODAY", params);
	} 

}
