package com.patis.admin.AD0102;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.patis.model.ConnectRecordVO;


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
	
	
	@RequestMapping(value = "/getSearchConnectData.do", method = RequestMethod.GET)
	@ResponseBody
	public String getSearchConnectData(	@RequestParam("start")String start,
										@RequestParam("end")String end) {
			
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("start", start);
		params.put("end", end);
		
		String result = ad0102Service.getSearchConnectData(params);
		
		return result;
	}
	
	@RequestMapping(value = "/getTodayDetailConnectData.do", method = RequestMethod.GET)
	public String getTodayDetailConnectData(@RequestParam("today")String today, Model model) {
		
		List<ConnectRecordVO> list = ad0102Service.getTodayDetailConnectData(today);
		
		model.addAttribute("list", list);
		
		return "ajax/connectList";
	}
	
	@RequestMapping(value = "/getSearchDetailConnectData.do", method = RequestMethod.GET)
	public String getSearchDetailConnectData(	@RequestParam("start")String start,
											 	@RequestParam("end")String end, 
											 	Model model) {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("start", start);
		params.put("end", end);
		
		List<ConnectRecordVO> list = ad0102Service.getSearchDetailConnectData(params);
		
		model.addAttribute("list", list);
		
		return "ajax/connectList";
	}
}
