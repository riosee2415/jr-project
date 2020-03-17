package com.patis.admin.AD0301;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.Accept_typeVO;

@Repository("ad0301DAO")
public class Ad0301DAOImpl implements I_Ad0301DAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "AcceptRight-Mapper";

	@Override
	public List<Accept_typeVO> getBoardName() {
		return sqlSession.selectList(NAMESPACE + ".GET_ALL_BOARD");
	}

	@Override
	public Accept_typeVO getBoardAdminRightByName(String name) {
		return sqlSession.selectOne(NAMESPACE + ".GET_BOARD_BY_NAME", name);
	}

	@Override
	public int boardAcceptRightModify(Map<String, Object> params) {
		return sqlSession.update(NAMESPACE + ".MODIFI_BOARD_ADMIN_RIGHT", params);
	}

}
