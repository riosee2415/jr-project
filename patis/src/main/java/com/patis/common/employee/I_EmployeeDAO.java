package com.patis.common.employee;

import java.util.Map;

import com.patis.model.EmpVO;

public interface I_EmployeeDAO {

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
	int joinUs(Map<String, String> params);
	
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 22.
	 * @RETURN : int
	 * @DESC   : 로그인 진행
	 */
	EmpVO mainLogin(Map<String, String> params) throws Exception;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 22.
	 * @RETURN : int
	 * @DESC   : 정상 로그인 시, 로그인 시도를 0으로 변경한다.
	 */
	int LOGIN_TRY_TO_ZERO(String input_id) throws Exception;
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : 2020. 3. 22.
	 * @RETURN : EmpVO
	 * @DESC   : 마이페이지 접속 시 현재 로그인 된 사용자의 데이터를 얻어온다.
	 */
	EmpVO getUserInfoByMypage(String input_id) throws Exception;
}
