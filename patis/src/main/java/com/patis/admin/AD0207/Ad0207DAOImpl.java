package com.patis.admin.AD0207;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.Accept_typeVO;
import com.patis.model.BoardVO;
import com.patis.model.CommentsVO;
import com.patis.model.CommonVO;

@Repository("ad0207DAO")
public class Ad0207DAOImpl implements I_Ad0207DAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "AdminYardOffice-Mapper";

	@Override
	public int getListCount(Map<String, String> params) {
		return sqlSession.selectOne(NAMESPACE + ".GET_COUNT", params);
	}

	@Override
	public List<BoardVO> getBoardData(int paging) {
		return sqlSession.selectList(NAMESPACE + ".GET_BOARD_DATA", paging);
	}

	@Override
	public int chagneNoticeStatus(int status, int no) {
		
		
		
		if(status == 0) {
			return sqlSession.update(NAMESPACE + ".MODIFY_NOTICE1", no);
		} else {
			return sqlSession.update(NAMESPACE + ".MODIFY_NOTICE2", no);
		}
	}

	@Override
	public int deleteOne(int no) {
		int result = sqlSession.update(NAMESPACE + ".REMOVE_DATA", no);
		
		return result;
	}

	@Override
	public List<BoardVO> getSearch(Map<String, Object> params) {
		return sqlSession.selectList(NAMESPACE + ".GET_SEARCH", params);
	}

	@Override
	public List<CommentsVO> getCommentsById(int p_no) {
		return sqlSession.selectList(NAMESPACE + ".GET_COMMENT_BY_ID", p_no);
	}

	@Override
	public int commentDelete(int co_no) {
		int result = sqlSession.update(NAMESPACE + ".REMOVE_COMMENT", co_no);
		
		return result;
	}

	@Override
	public List<CommonVO> getRight() {
		return sqlSession.selectList(NAMESPACE + ".GET_RIGHT");
	}


	@Override
	public Accept_typeVO currentRight() {
		return sqlSession.selectOne(NAMESPACE + ".GET_CURRENT_RIGHT");
	}

	@Override
	public int UpdateRight(Map<String, Object> params) {
		return sqlSession.update(NAMESPACE + ".MODIFY_RIGHT", params);
	}

	@Override
	public int getAdminControllRight() {
		return sqlSession.selectOne(NAMESPACE + ".GET_ADMIN_CONTROLL_RIGHT");
	}

}
