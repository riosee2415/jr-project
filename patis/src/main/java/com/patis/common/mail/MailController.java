package com.patis.common.mail;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.patis.common.employee.I_EmployeeService;
import com.patis.model.BoardVO;

@Controller
public class MailController {

	@Resource(name="mailService")
	private I_MailService mailService;
	
	@Resource(name="employeeService")
	private I_EmployeeService employeeService;
	
	@ResponseBody
	@RequestMapping(value="/sendBoardWriteMail.do")
	public void sendBoardWriteMail(@RequestParam("b_type") String b_type, HttpServletRequest request) throws SQLException {
		BoardVO boardVO = new BoardVO();
		boardVO.setB_TYPE(b_type);
		mailService.sendBoardWriteMail(boardVO, request);
	}
	
	@ResponseBody
	@RequestMapping(value="/sendFindPwMail.do")
	public void sendFindPwMail(   @RequestParam("id") String userId
								, @RequestParam("birth") String userReg
								, @RequestParam("email") String userEmail
								, HttpServletRequest request) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", userId);
		params.put("userReg", userReg);
		params.put("userEmail", userEmail);
		
		String empId = employeeService.findPwType1(params);
		
		if(empId != null) {
			employeeService.modifyEmailKey(userId, request);
		}
	}
}
