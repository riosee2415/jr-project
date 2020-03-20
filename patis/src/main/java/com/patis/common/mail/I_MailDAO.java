package com.patis.common.mail;

import java.sql.SQLException;
import java.util.List;

import com.patis.model.EmpVO;

public interface I_MailDAO {

	public List<EmpVO> getEmpListForMail(String BOARD_TYPE) throws SQLException;
	
	public String getBoardNameForMail(String BOARD_TYPE) throws SQLException;
}
