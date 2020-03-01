package com.innovation.template.service;

import java.sql.SQLException;
import java.util.List;

import com.innovation.template.domain.TemplateVO;

public interface TemplateService {

	List<TemplateVO> getTemplateList() throws SQLException;
	
	TemplateVO getTemplateById(int templateNo) throws SQLException;
	
	void insertTemplate(TemplateVO template) throws SQLException;
	
	void modifyTemplate(TemplateVO template) throws SQLException;
	
	void removeTemplate(int templateNo) throws SQLException;
	
}
