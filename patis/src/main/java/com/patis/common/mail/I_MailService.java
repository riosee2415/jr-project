package com.patis.common.mail;

import java.sql.SQLException;
import java.util.List;

import com.patis.model.BoardVO;
import com.patis.model.EmpVO;
import com.patis.model.MailVO;

public interface I_MailService {

	public void sendEmail(MailVO mailVO);
	
	public List<EmpVO> getEmpListForMail(String BOARD_TYPE) throws SQLException;
	
	public String getBoardNameForMail(String BOARD_TYPE) throws SQLException;
	
	public void sendBoardWriteMail(BoardVO boardVO) throws SQLException;
	
}
