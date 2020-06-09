package com.patis.middleware;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.Accept_typeVO;
import com.patis.model.CommonVO;
import com.patis.model.PopupVO;

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

	@Override
	public List<CommonVO> getDetailMenu() throws SQLException {
		return middlewareDAO.getDetailMenu();
	}

	@Override
	public void printLog(String text) {
		System.out.println("▒▒▒▒▒▒▒[system]▒▒▒▒▒▒▒ :: " + text);
	}

	@Override
	public Accept_typeVO getAcceptRight(String BOARD_TYPE) throws SQLException {
		return middlewareDAO.getAcceptRight(BOARD_TYPE);
	}

	@Override
	public List<CommonVO> getComboData(String code) throws SQLException {
		return middlewareDAO.getComboData(code);
	}

	@Override
	public List<PopupVO> getUsedPopup() {
		return middlewareDAO.getUsedPopup();
	}

}
