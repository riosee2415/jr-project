package com.patis.NM02.NM0204131;

import java.sql.SQLException;
import java.util.List;

import com.patis.model.BoardVO;

public interface I_Nm0204131Service {
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 9, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 도시재생 관계 법령 게시판 목록 조회(페이징)
	 */
	List<BoardVO> getStatuteList(int paging) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 9, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 도시재생 관계 법령 게시판 상세 조회
	 */
	BoardVO getStatute(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 9, 2020
	 * @RETURN : int
	 * @DESC   : 도시재생 관계 법령 게시판 개수 조회
	 */
	int getListCount() throws SQLException;
}
