package com.patis.NM02.NM0204131;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.patis.model.BoardVO;

public interface I_Nm0204131Service {
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 도시재생 관계법령 게시판 목록 조회(페이징)
	 */
	List<BoardVO> getStatuteList(int paging) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : List<BoardVO>
	 * @DESC   : 도시재생 관계법령 게시판 목록 조회(검색)
	 */
	List<BoardVO> getStatuteSearchList(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : BoardVO
	 * @DESC   : 도시재생 관계법령 게시판 상세 조회
	 */
	BoardVO getStatute(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 도시재생 관계법령 게시판 개수 조회
	 */
	int getListCount() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 도시재생 관계법령 게시판 개수 조회 (검색)
	 */
	int getSearchListCount(Map<String, String> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : String
	 * @DESC   : 도시재생 관계법령 게시판 B_TYPE 조회
	 */
	String getBoardType() throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 도시재생 관계법령 게시판 이전글 조회
	 */
	BoardVO getPrevStatute(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 도시재생 관계법령 게시판 다음글 조회
	 */
	BoardVO getNextStatute(Map<String, Object> params) throws SQLException;
	
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 도시재생 관계법령 게시판 조회수 증가
	 */
	int modifyHitUp(int b_no) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : int
	 * @DESC   : 도시재생 관계법령  게시판 글 작성
	 */
	int setStatute(BoardVO boardVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : void
	 * @DESC   : 도시재생 관계법령  게시판 글 수정
	 */
	void modifyStatute(BoardVO boardVO) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 16, 2020
	 * @RETURN : void
	 * @DESC   : 도시재생 관계법령  게시판 글 삭제
	 */
	void removeStatute(int b_no) throws SQLException;
}
