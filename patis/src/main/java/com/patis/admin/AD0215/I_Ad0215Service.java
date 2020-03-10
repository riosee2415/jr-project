package com.patis.admin.AD0215;

import java.util.List;
import java.util.Map;

import com.patis.model.BoardVO;
import com.patis.model.CommentsVO;

public interface I_Ad0215Service {
	
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
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : Mar 9, 2020
	 * @RETURN : int
	 * @DES    : 공지사항 여부 수정
	 */
	int chagneNoticeStatus(int status, int no);
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : Mar 9, 2020
	 * @RETURN : int
	 * @DES    : 삭제처리
	 */
	int deleteOne(int no);
	
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : Mar 8, 2020
	 * @RETURN : List<BoardVO>
	 * @DES    : 데이터를 검색하여 리턴 
	 */
	List<BoardVO> getSearch(String serachVal, String searchType);

	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : 2020. 3. 10.
	 * @RETURN : List<CommentsVO>
	 * @DESC   : 
	 */
	List<CommentsVO> getCommentsById(Map map);
}
