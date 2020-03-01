package com.innovation.template.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innovation.template.dao.TemplateDAO;
import com.innovation.template.domain.TemplateVO;

@Repository
public class TemplateDAOImpl implements TemplateDAO {

	private static final String NAMESPACE = "Template-Mapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<TemplateVO> selectTemplateList() throws SQLException {
		return sqlSession.selectList(NAMESPACE + ".selectTemplateList");
	}

	@Override
	public TemplateVO selectTemplateByNo(int templateNo) throws SQLException {
		return sqlSession.selectOne(NAMESPACE + ".selectTemplateByNo", templateNo);
	}

	@Override
	public void insertTemplate(TemplateVO template) throws SQLException {
		sqlSession.insert(NAMESPACE + ".insertTemplate", template);
	}

	@Override
	public void updateTemplate(TemplateVO template) throws SQLException {
		sqlSession.update(NAMESPACE + ".updateTemplate", template);
	}

	@Override
	public void deleteTemplate(int templateNo) throws SQLException {
		sqlSession.delete(NAMESPACE + ".deleteTemplate", templateNo);
	}

}
