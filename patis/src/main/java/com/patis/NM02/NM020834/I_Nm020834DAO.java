package com.patis.NM02.NM020834;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.patis.model.BoardVO;

public interface I_Nm020834DAO {
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Apr 21, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 구청 게시판 목록 조회(메인)
	 */
	List<BoardVO> getYardOfficeMainList() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 구청 게시판 목록 조회(페이징)
	 */
	List<BoardVO> getYardOfficeList(int paging) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 구청 게시판 목록 조회(검색)
	 */
	List<BoardVO> getYardOfficeSearchList(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 구청 게시판 상세 조회
	 */
	BoardVO getYardOffice(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 구청 게시판 개수 조회
	 */
	int getYardOfficeListCount() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 구청 게시판 개수 조회 (검색)
	 */
	int getYardOfficeSearchListCount(Map<String, String> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : String
	 * @DESC   : 구청 게시판 B_TYPE 조회
	 */
	String getYardOfficeBoardType() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 구청 게시판 이전글 조회
	 */
	BoardVO getPrevYardOffice(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 구청 게시판 다음글 조회
	 */
	BoardVO getNextYardOffice(Map<String, Object> params) throws SQLException;
	
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 구청 게시판 조회수 증가
	 */
	int modifyYardOfficeHitUp(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 구청  게시판 글 작성
	 */
	int setYardOffice(BoardVO boardVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : void
	 * @DESC   : 구청  게시판 글 수정
	 */
	void modifyYardOffice(BoardVO boardVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : void
	 * @DESC   : 구청  게시판 글 삭제
	 */
	void removeYardOffice(int b_no) throws SQLException;
	
	
	
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 현장지원센터 게시판 목록 조회(페이징)
	 */
	List<BoardVO> getYardSupportList(int paging) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 현장지원센터 게시판 목록 조회(검색)
	 */
	List<BoardVO> getYardSupportSearchList(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 현장지원센터 게시판 상세 조회
	 */
	BoardVO getYardSupport(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 현장지원센터 게시판 개수 조회
	 */
	int getYardSupportListCount() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 현장지원센터 게시판 개수 조회 (검색)
	 */
	int getYardSupportSearchListCount(Map<String, String> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : String
	 * @DESC   : 현장지원센터 게시판 B_TYPE 조회
	 */
	String getYardSupportBoardType() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 현장지원센터 게시판 이전글 조회
	 */
	BoardVO getPrevYardSupport(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 현장지원센터 게시판 다음글 조회
	 */
	BoardVO getNextYardSupport(Map<String, Object> params) throws SQLException;
	
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 현장지원센터 게시판 조회수 증가
	 */
	int modifyYardSupportHitUp(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 현장지원센터  게시판 글 작성
	 */
	int setYardSupport(BoardVO boardVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : void
	 * @DESC   : 현장지원센터  게시판 글 수정
	 */
	void modifyYardSupport(BoardVO boardVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : void
	 * @DESC   : 현장지원센터  게시판 글 삭제
	 */
	void removeYardSupport(int b_no) throws SQLException;
	
}
