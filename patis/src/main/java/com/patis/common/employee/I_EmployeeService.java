package com.patis.common.employee;

import java.util.Map;

import com.patis.model.EmpVO;

public interface I_EmployeeService {

	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 20.
	 * @RETURN : int
	 * @DESC   : 아이디 중복체크 검증
	 */
	int dupleCheckId(String joinId);
	
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 20.
	 * @RETURN : int
	 * @DESC   : 회원가입 진행
	 */
	int joinUs(Map<String, String> params) throws Exception;
	
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 22.
	 * @RETURN : int
	 * @DESC   : 로그인 진행
	 */
	EmpVO mainLogin(Map<String, String> params) throws Exception;
} 
