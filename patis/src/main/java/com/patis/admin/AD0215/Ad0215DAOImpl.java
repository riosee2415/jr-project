package com.patis.admin.AD0215;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.BoardVO;
import com.patis.model.CommentsVO;

@Repository("ad0215DAO")
public class Ad0215DAOImpl implements I_Ad0215DAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "AdminCollusion-Mapper";

	@Override
	public int getListCount() {
		return sqlSession.selectOne(NAMESPACE + ".GET_COUNT");
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
	public List<BoardVO> getSearch(String serachVal, String searchType) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("serachVal", serachVal);
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		if(searchType.equals("제목")) {
			list =  sqlSession.selectList(NAMESPACE + ".GET_SEARCH_TITLE", map);
		} else if(searchType.equals("작성자")) {
			list =  sqlSession.selectList(NAMESPACE + ".GET_SEARCH_AUTHOR", map);
		}
		
		return list;
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

}
