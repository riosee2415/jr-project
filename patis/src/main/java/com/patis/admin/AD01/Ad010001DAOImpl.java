package com.patis.admin.AD01;

import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.net.URLCodec;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.EmpVO;
import com.patis.util.AES256Util;

@Repository("ad010001DAO")
public class Ad010001DAOImpl implements I_Ad010001DAO{
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "Admin-Mapper";

	@Override
	public int adminLoginCheck(Map info) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".ID_CHECK", info);
	}

	@Override
	public int adminLoginCheck2(Map info) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".ID_PASS_CHECK", info);
	}

	@Override
	public int saveLoginData(Map info) throws SQLException {
		return sqlSession.insert(NAMESPACE + ".SAVE_LOGIN_LOG", info);
	}

	@Override
	public EmpVO getEmpInfo(Map info) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_EMP_INFO", info);
	}

	@Override
	public EmpVO getEmpSecretInfo(Map info) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".GET_EMP_SECRET_INFO", info);
	}

}
