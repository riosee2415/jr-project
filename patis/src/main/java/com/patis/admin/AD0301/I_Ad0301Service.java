package com.patis.admin.AD0301;

import java.util.List;
import java.util.Map;

import com.patis.model.Accept_typeVO;

public interface I_Ad0301Service {
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 17.
	 * @RETURN : List<Accept_typeVO>
	 * @DESC   : 게시판 이름을 얻어온다.
	 */
	List<Accept_typeVO> getBoardName();

	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 17.
	 * @RETURN : Accept_typeVO
	 * @DESC   : 게시판 이름을 기준으로 게시판 데이터를 가져온다.
	 */
	Accept_typeVO getBoardAdminRightByName(String name);

	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 17.
	 * @RETURN : int
	 * @DESC   : 접근 권한을 수정한다.
	 */
	int boardAcceptRightModify(Map<String, Object> params);
}
