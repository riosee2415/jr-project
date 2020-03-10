package com.patis.common.comment;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.patis.model.CommentsVO;

@Repository("commentService")
public class CommentServiceImpl implements I_CommentService {
	
	@Resource(name="commentDAO")
	private I_CommentDAO commentDAO;
	
	@Override
	public List<CommentsVO> getCommentList(Map<String, Object> params) throws SQLException {
		return commentDAO.getCommentList(params);
	}

	@Override
	public void setComment(CommentsVO comments) throws SQLException {
		commentDAO.setComment(comments);
	}

	@Override
	public void modifyComment(CommentsVO comments) throws SQLException {
		commentDAO.modifyComment(comments);
	}

	@Override
	public void removeComment(int co_no) throws SQLException {
		commentDAO.removeComment(co_no);
	}

	
}
