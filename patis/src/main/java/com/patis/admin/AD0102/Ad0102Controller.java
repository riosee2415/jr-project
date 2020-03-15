package com.patis.admin.AD0102;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author 4leaf.ysh
 * @SCREEN : 접속기록 관리 페이지(/loginReport.do)
 *
 */

@Controller
public class Ad0102Controller {
	
	@Resource(name = "ad0102Service")
	private I_Ad0102Service ad0102Service;
	
	
	@RequestMapping(value = "/loginReport.do", method = RequestMethod.GET)
	public String sendScreen() {
		
		return "loginReport";
	}
	
	
	@RequestMapping(value = "/getTodayConnectData.do", method = RequestMethod.GET)
	@ResponseBody
	public String getTodayConnectData(@RequestParam("today")String today) {
		
		String result = ad0102Service.getTodayConnectData(today);
		
		return result;
	}
	
}
