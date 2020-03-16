package com.patis.admin.AD0103;

import java.util.List;

import com.patis.model.EmpVO;

public interface I_Ad0103DAO {

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
}
