package com.patis.NM02.NM021038;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.patis.model.BoardVO;

public interface I_Nm021038DAO {
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 교육 연간일정표 게시판 목록 조회(페이징)
	 */
	List<BoardVO> getCalendarList(int paging) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 교육 연간일정표 게시판 목록 조회(검색)
	 */
	List<BoardVO> getCalendarSearchList(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 교육 연간일정표 게시판 상세 조회
	 */
	BoardVO getCalendar(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 교육 연간일정표 게시판 개수 조회
	 */
	int getCalendarListCount() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 교육 연간일정표 게시판 개수 조회 (검색)
	 */
	int getCalendarSearchListCount(Map<String, String> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : String
	 * @DESC   : 교육 연간일정표 게시판 B_TYPE 조회
	 */
	String getCalendarBoardType() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 교육 연간일정표 게시판 이전글 조회
	 */
	BoardVO getPrevCalendar(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 교육 연간일정표 게시판 다음글 조회
	 */
	BoardVO getNextCalendar(Map<String, Object> params) throws SQLException;
	
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 교육 연간일정표 게시판 조회수 증가
	 */
	int modifyCalendarHitUp(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 교육 연간일정표  게시판 글 작성
	 */
	int setCalendar(BoardVO boardVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : void
	 * @DESC   : 교육 연간일정표  게시판 글 수정
	 */
	void modifyCalendar(BoardVO boardVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : void
	 * @DESC   : 교육 연간일정표  게시판 글 삭제
	 */
	void removeCalendar(int b_no) throws SQLException;
	
	
	
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 교육 일정등록 및 신청 게시판 목록 조회(페이징)
	 */
	List<BoardVO> getCalendarApplyList(int paging) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 교육 일정등록 및 신청 게시판 목록 조회(검색)
	 */
	List<BoardVO> getCalendarApplySearchList(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 교육 일정등록 및 신청 게시판 상세 조회
	 */
	BoardVO getCalendarApply(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 교육 일정등록 및 신청 게시판 개수 조회
	 */
	int getCalendarApplyListCount() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 교육 일정등록 및 신청 게시판 개수 조회 (검색)
	 */
	int getCalendarApplySearchListCount(Map<String, String> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : String
	 * @DESC   : 교육 일정등록 및 신청 게시판 B_TYPE 조회
	 */
	String getCalendarApplyBoardType() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 교육 일정등록 및 신청 게시판 이전글 조회
	 */
	BoardVO getPrevCalendarApply(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 교육 일정등록 및 신청 게시판 다음글 조회
	 */
	BoardVO getNextCalendarApply(Map<String, Object> params) throws SQLException;
	
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 교육 일정등록 및 신청 게시판 조회수 증가
	 */
	int modifyCalendarApplyHitUp(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 교육 일정등록 및 신청  게시판 글 작성
	 */
	int setCalendarApply(BoardVO boardVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : void
	 * @DESC   : 교육 일정등록 및 신청  게시판 글 수정
	 */
	void modifyCalendarApply(BoardVO boardVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : void
	 * @DESC   : 교육 일정등록 및 신청  게시판 글 삭제
	 */
	void removeCalendarApply(int b_no) throws SQLException;
}
