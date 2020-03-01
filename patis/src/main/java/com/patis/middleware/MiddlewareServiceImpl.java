package com.patis.middleware;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.CommonVO;

@Service("middlewareService")
public class MiddlewareServiceImpl implements I_MiddlewareService {

	@Resource(name="middlewareDAO")
	private I_MiddlewareDAO middlewareDAO;
	
	@Override
	public List<CommonVO> selectCommonList() throws SQLException {
		return middlewareDAO.selectCommonList();
	}

	@Override
	public List<CommonVO> getMenu() throws SQLException {
		
		return middlewareDAO.getMenu();
	}

	@Override
	public List<CommonVO> getSubMenu() throws SQLException {
		
		return middlewareDAO.getSubMenu();
	}

	
	

}
