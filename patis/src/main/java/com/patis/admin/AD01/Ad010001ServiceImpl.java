package com.patis.admin.AD01;

import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.patis.model.EmpVO;

@Service("ad010001Service")
public class Ad010001ServiceImpl implements I_Ad010001Service{

	
	@Resource(name = "ad010001DAO")
	private  I_Ad010001DAO ad010001DAO;
	
	@Override
	public int adminLoginCheck(Map info) throws SQLException {
		return ad010001DAO.adminLoginCheck(info);
	}

	@Override
	public int adminLoginCheck2(Map info) throws SQLException {
		return ad010001DAO.adminLoginCheck2(info);
	}

	@Override
	public int saveLoginData(Map info) throws SQLException {
		return ad010001DAO.saveLoginData(info);
	}

	@Override
	public EmpVO getEmpInfo(Map info) throws SQLException {
		return ad010001DAO.getEmpInfo(info);
	}

}
