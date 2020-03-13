package com.patis.common.comment;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.patis.model.CommentsVO;

public interface I_CommentDAO {

	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 12, 2020
	 * @RETURN : List<CommentsVO>
	 * @DESC   : 댓글 목록 조회
	 */
	List<CommentsVO> getCommentList(Map<String, Object> params) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 12, 2020
	 * @RETURN : void
	 * @DESC   : 댓글 등록
	 */
	void setComment(CommentsVO comments) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 12, 2020
	 * @RETURN : void
	 * @DESC   : 댓글 변경
	 */
	void modifyComment(CommentsVO comments) throws SQLException;
	
	/**
	 * @AUTHOR : 4LEAF.NJM
	 * @DATE   : Mar 12, 2020
	 * @RETURN : void
	 * @DESC   : 댓글 삭제
	 */
	void removeComment(int co_no) throws SQLException;
	
}
