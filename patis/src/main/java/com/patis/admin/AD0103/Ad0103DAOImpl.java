package com.patis.admin.AD0103;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.EmpVO;

@Repository("ad0103DAO")
public class Ad0103DAOImpl implements I_Ad0103DAO {

	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	private static final String NAMESPACE = "AdminUser-Mapper";

	@Override
	public List<EmpVO> getAllUser() {
		return sqlSession.selectList(NAMESPACE + ".GET_ALL_USER");
	}

	@Override
	public EmpVO getUserById(String userId) {
		return sqlSession.selectOne(NAMESPACE + ".GET_ALL_USER_ID", userId);
	}

	@Override
	public int updateUserInfo(Map<String, Object> params) {
		return sqlSession.update(NAMESPACE + ".MODIFI_USER_DATA", params);
	}

	@Override
	public List<EmpVO> searchUserInfo(Map<String, String> params) {
		return sqlSession.selectList(NAMESPACE + ".GET_SEARCH_USER_INFO", params);
	}

}
