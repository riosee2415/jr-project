package com.patis.NM02.NM021164;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.patis.model.BoardVO;

public interface I_Nm021164DAO {
	
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
	 * @RETURN : List<BoardVO>
	 * @DESC   : 공모사업 신청 게시판 목록 조회(검색)
	 */
	List<BoardVO> getCollusionSearchList(Map<String, Object> params) throws SQLException;
	
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
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 9, 2020
	 * @RETURN : int
	 * @DESC   : 공모사업 신청 게시판 개수 조회 (검색)
	 */
	int getSearchListCount(Map<String, String> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 9, 2020
	 * @RETURN : String
	 * @DESC   : 공모사업 신청 게시판 B_TYPE 조회
	 */
	String getBoardType() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 9, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 공모사업 신청 게시판 이전글 조회
	 */
	BoardVO getPrevCollusion(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 9, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 공모사업 신청 게시판 다음글 조회
	 */
	BoardVO getNextCollusion(Map<String, Object> params) throws SQLException;
	
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 9, 2020
	 * @RETURN : int
	 * @DESC   : 공모사업 신청 게시판 조회수 증가
	 */
	int modifyHitUp(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 12, 2020
	 * @RETURN : int
	 * @DESC   : 공모사업 신청  게시판 글 작성
	 */
	int setCollusion(BoardVO boardVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 15, 2020
	 * @RETURN : void
	 * @DESC   : 공모사업 신청  게시판 글 수정
	 */
	void modifyCollusion(BoardVO boardVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 15, 2020
	 * @RETURN : void
	 * @DESC   : 공모사업 신청  게시판 글 삭제
	 */
	void removeCollusion(int b_no) throws SQLException;
}
