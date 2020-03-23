package com.patis.admin.AD01;

import java.sql.SQLException;
import java.util.Map;

import com.patis.model.EmpVO;

public interface I_Ad010001Service {
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : Mar 4, 2020
	 * @RETURN : int
	 * @DESC   : 관리자 로그인 기능 체크 (아이디 체크)
	 */
	int adminLoginCheck(Map<String, String> info) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : Mar 4, 2020
	 * @RETURN : int
	 * @DESC   : 관리자 로그인 기능 체크 (아이디 비밀번호 체크)
	 */
	int adminLoginCheck2(Map<String, String> info) throws SQLException;

	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : Mar 4, 2020
	 * @RETURN : int
	 * @DESC   : 로그인이 성공하면 로그인 기록을 데이터베이스에 저장한다.
	 */
	int saveLoginData(Map<String, String> info) throws SQLException;
	
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : Mar 4, 2020
	 * @RETURN : EmpVO
	 * @DESC   : 로그인에 성공한 유저 데이터를 데이터베이스에서 가져온다.
	 */
	EmpVO getEmpInfo(Map<String, String> info) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 15.
	 * @RETURN : int
	 * @DESC   : IP주소와 날짜를 기준으로 접속 기록이 있는지 조회한다.
	 */
	int lookupConnectReport(Map<String, String> params);
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 15.
	 * @RETURN : int
	 * @DESC   : 접속기록이 없는 경우, 새로운 접속기록을 기록한다.
	 */
	int addConnectReport(Map<String, String> params);
	
	
	
}
