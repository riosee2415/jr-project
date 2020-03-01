package com.patis.middleware;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.CommonVO;

@Service("middlewareService")
public class MiddlewareServiceImpl implements I_MiddlewareDAO {

	@Resource(name="middlewareDAO")
	private MiddlewareDAOImpl middlewareDAO;
	
	@Override
	public List<CommonVO> selectCommonList() throws SQLException {
		return middlewareDAO.selectCommonList();
	}

}
