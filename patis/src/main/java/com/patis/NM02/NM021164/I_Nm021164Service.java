package com.patis.NM02.NM021164;

import java.sql.SQLException;
import java.util.List;

import com.patis.model.BoardVO;

public interface I_Nm021164Service {
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 9, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 공모사업 신청 게시판 목록 조회(페이징)
	 */
	List<BoardVO> getCollusionList(int paging) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 9, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 공모사업 신청 게시판 상세 조회
	 */
	BoardVO getCollusion(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 9, 2020
	 * @RETURN : int
	 * @DESC   : 공모사업 신청 게시판 개수 조회
	 */
	int getListCount() throws SQLException;
}
