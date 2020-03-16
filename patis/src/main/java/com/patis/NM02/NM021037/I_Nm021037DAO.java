package com.patis.NM02.NM021037;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.patis.model.BoardVO;

public interface I_Nm021037DAO {
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 구청 게시판 목록 조회(페이징)
	 */
	List<BoardVO> getEduOfficeList(int paging) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 구청 게시판 목록 조회(검색)
	 */
	List<BoardVO> getEduOfficeSearchList(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 구청 게시판 상세 조회
	 */
	BoardVO getEduOffice(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 구청 게시판 개수 조회
	 */
	int getEduOfficeListCount() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 구청 게시판 개수 조회 (검색)
	 */
	int getEduOfficeSearchListCount(Map<String, String> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : String
	 * @DESC   : 구청 게시판 B_TYPE 조회
	 */
	String getEduOfficeBoardType() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 구청 게시판 이전글 조회
	 */
	BoardVO getPrevEduOffice(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 구청 게시판 다음글 조회
	 */
	BoardVO getNextEduOffice(Map<String, Object> params) throws SQLException;
	
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 구청 게시판 조회수 증가
	 */
	int modifyEduOfficeHitUp(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 구청  게시판 글 작성
	 */
	int setEduOffice(BoardVO boardVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : void
	 * @DESC   : 구청  게시판 글 수정
	 */
	void modifyEduOffice(BoardVO boardVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : void
	 * @DESC   : 구청  게시판 글 삭제
	 */
	void removeEduOffice(int b_no) throws SQLException;
	
	
	
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 현장지원센터 게시판 목록 조회(페이징)
	 */
	List<BoardVO> getEduSupportList(int paging) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 현장지원센터 게시판 목록 조회(검색)
	 */
	List<BoardVO> getEduSupportSearchList(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 현장지원센터 게시판 상세 조회
	 */
	BoardVO getEduSupport(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 현장지원센터 게시판 개수 조회
	 */
	int getEduSupportListCount() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 현장지원센터 게시판 개수 조회 (검색)
	 */
	int getEduSupportSearchListCount(Map<String, String> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : String
	 * @DESC   : 현장지원센터 게시판 B_TYPE 조회
	 */
	String getEduSupportBoardType() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 현장지원센터 게시판 이전글 조회
	 */
	BoardVO getPrevEduSupport(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 현장지원센터 게시판 다음글 조회
	 */
	BoardVO getNextEduSupport(Map<String, Object> params) throws SQLException;
	
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 현장지원센터 게시판 조회수 증가
	 */
	int modifyEduSupportHitUp(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 현장지원센터  게시판 글 작성
	 */
	int setEduSupport(BoardVO boardVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : void
	 * @DESC   : 현장지원센터  게시판 글 수정
	 */
	void modifyEduSupport(BoardVO boardVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : void
	 * @DESC   : 현장지원센터  게시판 글 삭제
	 */
	void removeEduSupport(int b_no) throws SQLException;
}
