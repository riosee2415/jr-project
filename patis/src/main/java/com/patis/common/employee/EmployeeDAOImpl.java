package com.patis.common.employee;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.EmpVO;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements I_EmployeeDAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "Employee-Mapper";

	@Override
	public int dupleCheckId(String joinId) {
		return sqlSession.selectOne(NAMESPACE + ".DUPLE_CHECK_ID", joinId);
	}

	@Override
	public int joinUs(Map<String, String> params) {
		return sqlSession.insert(NAMESPACE + ".SET_EMP", params);
	}

	@Override
	public EmpVO mainLogin(Map<String, String> params) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".LOGIN_USER", params);
	}

	@Override
	public int LOGIN_TRY_TO_ZERO(String input_id) throws Exception {
		return sqlSession.update(NAMESPACE + ".MODIFY_LOGIN_TRY", input_id);
	}

	@Override
	public EmpVO getUserInfoByMypage(String input_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".GET_MYPAGE_INFO", input_id);
	}

	@Override
	public int updateUserInfoMyPage(Map<String, String> params) {
		return sqlSession.update(NAMESPACE + ".MODIFY_USER_INFO", params);
	}

	@Override
	public String findIdType1(Map<String, String> params) {
		return sqlSession.selectOne(NAMESPACE + ".GET_FIND_ID_TYPE1", params);
	}

}
