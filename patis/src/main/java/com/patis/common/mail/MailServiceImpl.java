package com.patis.common.mail;

import java.io.StringWriter;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.patis.common.employee.I_EmployeeDAO;
import com.patis.model.BoardVO;
import com.patis.model.EmpVO;
import com.patis.model.MailVO;

@Service("mailService")
public class MailServiceImpl implements I_MailService {

	@Resource(name="mailSender")
	private JavaMailSender mailSender;

	@Resource(name="velocityEngine")
	private VelocityEngine velocityEngine;
	
	@Resource(name="mailDAO") 
	private I_MailDAO mailDAO;	
	
	@Resource(name="employeeDAO")
	private I_EmployeeDAO employeeDAO;
	
	@Override
	public void sendEmail(MailVO mailVO, Template template, VelocityContext context) {
		final MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				StringWriter stringWriter = new StringWriter();
				template.merge(context, stringWriter);
				
				helper.setFrom(mailVO.getMailFrom());
				helper.setTo(mailVO.getMailTo());
				helper.setSubject(mailVO.getMailSubject()); 
				helper.setText(stringWriter.toString(), true);
			}
		};
		mailSender.send(preparator);
	}

	@Override
	public List<EmpVO> getEmpListForMail(String BOARD_TYPE) throws SQLException {
		return mailDAO.getEmpListForMail(BOARD_TYPE);
	}

	@Override
	public String getBoardNameForMail(String BOARD_TYPE) throws SQLException {
		return getBoardNameForMail(BOARD_TYPE);
	}
	
	public void sendBoardWriteMail(BoardVO boardVO, HttpServletRequest request) throws SQLException {
		List<EmpVO> empList = mailDAO.getEmpListForMail(boardVO.getB_TYPE());
		String boardName = mailDAO.getBoardNameForMail(boardVO.getB_TYPE());
		
		for(EmpVO emp : empList) {
			MailVO mailVO = new MailVO();
			mailVO.setDefaultSetting();
			mailVO.setMailTo(emp.getUSER_EMAIL());
			mailVO.setMailSubject("중랑구청 도시재생과 홈페이지 알림");
			
			VelocityContext context = new VelocityContext();
			context.put("serverName", request.getServerName().equals("localhost") ? request.getServerName() + ":" + request.getServerPort() : request.getServerName());
			context.put("boardName", boardName);
			
			Template template = velocityEngine.getTemplate("/velocity/boardWrite.vm", "UTF-8");
			sendEmail(mailVO, template, context);
		}
	}

	@Override
	public void sendFindPwMail(String userId, HttpServletRequest request) throws Exception {
		EmpVO emp = employeeDAO.getUserInfo(userId);
		MailVO mailVO = new MailVO();
		mailVO.setDefaultSetting();
		mailVO.setMailTo(emp.getUSER_EMAIL());
		mailVO.setMailSubject("중랑구청 비밀번호 찾기 인증코드");
		
		VelocityContext context = new VelocityContext();
		context.put("serverName", request.getServerName().equals("localhost") ? request.getServerName() + ":" + request.getServerPort() : request.getServerName());
		context.put("emailKey", emp.getUSER_EMAIL_KEY());
		
		Template template = velocityEngine.getTemplate("/velocity/findPw.vm", "UTF-8");
		sendEmail(mailVO, template, context);
	}
}
