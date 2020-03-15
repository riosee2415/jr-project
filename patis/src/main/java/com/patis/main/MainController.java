package com.patis.main;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.patis.admin.AD01.I_Ad010001Service;
import com.patis.middleware.I_MiddlewareService;
import com.patis.model.CommonVO;

@Controller
public class MainController {
	
	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;
	
	@Resource(name = "ad010001Service")
	private I_Ad010001Service ad010001Service;
	
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public String main(Model model) throws Exception {
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		return "main";
	}
	
	
	@RequestMapping(value="/connectRecord.do", method=RequestMethod.GET)
	@ResponseBody
	public String connectRecord	(InetAddress ip, HttpServletRequest req) {
		
		String os = req.getHeader("User-Agent");
		os = os.split(" ")[1];
		os = os.replace("(", "");
		
		String ipAdress = "000.000.000.000";
		String currentDate = "9999/99/99";
		
		try {
			ip = InetAddress.getLocalHost(); 
			ipAdress = ip.getHostAddress(); 
		}catch(Exception e) {
			System.out.println(e);
		}
		
		SimpleDateFormat format = new SimpleDateFormat ("yyyy/MM/dd");
		Date time = new Date();
		currentDate = format.format(time);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("ipAdress", ipAdress);
		params.put("currentDate", currentDate);
		params.put("os", os);
		
		int result = ad010001Service.lookupConnectReport(params);
		
		if(result == 1) {
			return "";
		} else {
			int isAdd = ad010001Service.addConnectReport(params);
			return "";
		}
		
	}
	
}
