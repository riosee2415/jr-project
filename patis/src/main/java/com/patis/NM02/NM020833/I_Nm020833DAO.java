package com.patis.NM02.NM020833;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.patis.model.BoardVO;

public interface I_Nm020833DAO {
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 보도자료 게시판 목록 조회(페이징)
	 */
	List<BoardVO> getReleaseList(int paging) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 보도자료 게시판 목록 조회(검색)
	 */
	List<BoardVO> getReleaseSearchList(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 보도자료 게시판 상세 조회
	 */
	BoardVO getRelease(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 보도자료 게시판 개수 조회
	 */
	int getListCount() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 보도자료 게시판 개수 조회 (검색)
	 */
	int getSearchListCount(Map<String, String> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : String
	 * @DESC   : 보도자료 게시판 B_TYPE 조회
	 */
	String getBoardType() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 보도자료 게시판 이전글 조회
	 */
	BoardVO getPrevRelease(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 보도자료 게시판 다음글 조회
	 */
	BoardVO getNextRelease(Map<String, Object> params) throws SQLException;
	
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 보도자료 게시판 조회수 증가
	 */
	int modifyHitUp(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 보도자료  게시판 글 작성
	 */
	int setRelease(BoardVO boardVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : void
	 * @DESC   : 보도자료  게시판 글 수정
	 */
	void modifyRelease(BoardVO boardVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : void
	 * @DESC   : 보도자료  게시판 글 삭제
	 */
	void removeRelease(int b_no) throws SQLException;
}
