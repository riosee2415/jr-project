package com.patis.admin.AD0103;

import java.util.List;
import java.util.Map;

import com.patis.model.CommonVO;
import com.patis.model.EmpVO;

public interface I_Ad0103Service {
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 16.
	 * @RETURN : List<EmpVO>
	 * @DESC   : 모든 사용자를 가져온다.
	 */
	List<EmpVO> getAllUser();
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 16.
	 * @RETURN : EmpVO
	 * @DESC   : 사용자 아이디를 기준으로  데이터를 가져온다.
	 */
	EmpVO getUserById(String userId);
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 17.
	 * @RETURN : int
	 * @DESC   : 사용자 정보를 받아 업데이트 한다.
	 */
	int updateUserInfo(Map<String, Object> params);

	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 17.
	 * @RETURN : List<EmpVO>
	 * @DESC   : 검색유형과 검색어를 입력받아 사용자정보를 조회한다.
	 */
	List<EmpVO> searchUserInfo(Map<String, String> params);
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 22.
	 * @RETURN : int
	 * @DESC   : 회원 탈퇴 진행
	 */
	int deleteUser(String userId);
}
