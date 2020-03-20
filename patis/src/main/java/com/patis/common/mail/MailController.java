package com.patis.common.mail;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.patis.model.BoardVO;

@Controller
public class MailController {

	@Resource(name="mailService")
	private I_MailService mailService;
	
	@ResponseBody
	@RequestMapping(value="/sendBoardWriteMail.do")
	public void sendBoardWriteMail(@RequestParam("b_type") String b_type) throws SQLException {
		BoardVO boardVO = new BoardVO();
		boardVO.setB_TYPE(b_type);
		mailService.sendBoardWriteMail(boardVO);
	}
}
