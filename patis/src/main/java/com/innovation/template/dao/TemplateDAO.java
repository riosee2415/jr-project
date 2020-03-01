package com.innovation.template.dao;

import java.sql.SQLException;
import java.util.List;

import com.innovation.template.domain.TemplateVO;

public interface TemplateDAO {

	List<TemplateVO> selectTemplateList() throws SQLException;

	TemplateVO selectTemplateByNo(int templateNo) throws SQLException;

	void insertTemplate(TemplateVO template) throws SQLException;

	void updateTemplate(TemplateVO template) throws SQLException;

	void deleteTemplate(int templateNo) throws SQLException;
}
