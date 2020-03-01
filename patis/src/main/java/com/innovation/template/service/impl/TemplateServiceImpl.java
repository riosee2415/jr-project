package com.innovation.template.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovation.template.dao.TemplateDAO;
import com.innovation.template.domain.TemplateVO;
import com.innovation.template.service.TemplateService;

@Service
public class TemplateServiceImpl implements TemplateService {

	@Autowired
	private TemplateDAO templateDAO;
	
	@Override
	public List<TemplateVO> getTemplateList() throws SQLException {
		return templateDAO.selectTemplateList();
	}

	@Override
	public TemplateVO getTemplateById(int templateNo) throws SQLException {
		return templateDAO.selectTemplateByNo(templateNo);
	}

	@Override
	public void insertTemplate(TemplateVO template) throws SQLException {
		templateDAO.insertTemplate(template);
	}

	@Override
	public void modifyTemplate(TemplateVO template) throws SQLException {
		templateDAO.updateTemplate(template);
	}

	@Override
	public void removeTemplate(int templateNo) throws SQLException {
		templateDAO.deleteTemplate(templateNo);
	}

}
