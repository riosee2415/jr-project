package com.patis.admin.AD0215;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.BoardVO;

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

}
