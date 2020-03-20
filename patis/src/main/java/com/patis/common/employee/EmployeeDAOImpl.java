package com.patis.common.employee;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements I_EmployeeDAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "Employee-Mapper";

	@Override
	public int dupleCheckId(String joinId) {
		return sqlSession.selectOne(NAMESPACE + ".DUPLE_CHECK_ID", joinId);
	}

}
