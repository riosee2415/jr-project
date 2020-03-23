package com.patis.common.mail;

import java.sql.SQLException;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import com.patis.model.BoardVO;
import com.patis.model.EmpVO;
import com.patis.model.MailVO;

public interface I_MailService {

	public void sendEmail(MailVO mailVO, Template template, VelocityContext context);
	
	public List<EmpVO> getEmpListForMail(String BOARD_TYPE) throws SQLException;
	
	public String getBoardNameForMail(String BOARD_TYPE) throws SQLException;
	
	public void sendBoardWriteMail(BoardVO boardVO) throws SQLException;
	
	public void sendFindPwMail(String userId) throws Exception;
	
}
