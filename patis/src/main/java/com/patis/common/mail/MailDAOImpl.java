package com.patis.common.mail;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.patis.model.Accept_typeVO;
import com.patis.model.EmpVO;

@Repository("mailDAO")
public class MailDAOImpl implements I_MailDAO {

	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String EMP_NAMESPACE = "Employee-Mapper";
	private static final String ACCEPT_NAMESPACE = "AcceptRight-Mapper";
	
	@Override
	public List<EmpVO> getEmpListForMail(String BOARD_TYPE) throws SQLException {
		return sqlSession.selectList(EMP_NAMESPACE + ".GET_EMP_LIST_FOR_MAIL", BOARD_TYPE);
	}

	@Override
	public String getBoardNameForMail(String BOARD_TYPE) throws SQLException {
		Accept_typeVO acceptVO = sqlSession.selectOne(ACCEPT_NAMESPACE + ".GET_ACCEPT_RIGHT", BOARD_TYPE);
		return acceptVO.getBOARD_NAME();
	}

}
