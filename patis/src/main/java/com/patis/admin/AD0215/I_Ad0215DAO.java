package com.patis.admin.AD0215;

import java.util.List;

import com.patis.model.BoardVO;

public interface I_Ad0215DAO {
	
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : Mar 8, 2020
	 * @RETURN : List<BoardVO>
	 * @DES    : 데이터를 카운팅 하여 리턴
	 */
	List<BoardVO> getBoardData(int paging);

	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : Mar 8, 2020
	 * @RETURN : int
	 * @DES    : 데이터를 카운팅 하여 리턴
	 */
	int getListCount();

}
