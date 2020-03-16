package com.patis.admin.AD0103;

import java.util.List;

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

}
