package com.patis.admin.AD0102;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 4leaf.ysh
 * @SCREEN : 접속기록 관리 페이지(/loginReport.do)
 *
 */

@Controller
public class Ad0102Controller {
	
	
	@RequestMapping(value = "/loginReport.do", method = RequestMethod.GET)
	public String sendScreen() {
		
		return "loginReport";
	}
}
