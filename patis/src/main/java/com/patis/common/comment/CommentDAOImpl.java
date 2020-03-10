package com.patis.common.comment;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.CommentsVO;

@Repository("commentDAO")
public class CommentDAOImpl implements I_CommentDAO {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "Comments-Mapper";

	@Override
	public List<CommentsVO> getCommentList(Map<String, Object> params) throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".GET_COMMENT_LIST", params);
	}

	@Override
	public void setComment(CommentsVO comments) throws SQLException {
		sqlSession.insert(NAMESPACE + ".SET_COMMENT", comments);
	}

	@Override
	public void modifyComment(CommentsVO comments) throws SQLException {
		sqlSession.update(NAMESPACE + ".MODIFY_COMMENT", comments);
	}

	@Override
	public void removeComment(int co_no) throws SQLException {
		sqlSession.update(NAMESPACE + ".REMOVE_COMMENT", co_no);
	}

	
}
