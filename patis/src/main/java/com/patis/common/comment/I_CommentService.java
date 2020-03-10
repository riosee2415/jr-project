package com.patis.common.comment;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.patis.model.CommentsVO;

public interface I_CommentService {

	List<CommentsVO> getCommentList(Map<String, Object> params) throws SQLException;
	
	void setComment(CommentsVO comments) throws SQLException;
	
	void modifyComment(CommentsVO comments) throws SQLException;
	
	void removeComment(int co_no) throws SQLException;
	
}
