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

import com.patis.NM02.NM020832.I_Nm020832Service;
import com.patis.NM02.NM021164.I_Nm021164Service;
import com.patis.admin.AD01.I_Ad010001Service;
import com.patis.middleware.I_MiddlewareService;
import com.patis.model.BoardVO;
import com.patis.model.CommonVO;
import com.patis.model.PopupVO;

@Controller
public class MainController {
	
	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;
	
	@Resource(name = "ad010001Service")
	private I_Ad010001Service ad010001Service;
	
	@Resource(name = "nm020832Service")
	private I_Nm020832Service nm020832Service;
	
	@Resource(name = "nm021164Service")
	private I_Nm021164Service nm021164Service;
	
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public String main(Model model) throws Exception {
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		Map<String, Object> boardData01 = new HashMap<String, Object>();
		Map<String, Object> boardData02 = new HashMap<String, Object>();
		
		List<BoardVO> boardList01 = nm020832Service.getNoticeMainList();
		List<BoardVO> boardList02 = nm021164Service.getCollusionMainList();
		
		List<PopupVO> popupList = middlewareService.getUsedPopup();
		
		String btype01 = nm020832Service.getNoticeBoardType();
		String btype02 = nm021164Service.getBoardType();
		
		boardData01.put("list", boardList01);
		boardData02.put("list", boardList02);
		
		boardData01.put("btype", btype01);
		boardData02.put("btype", btype02);
		
		boardData01.put("parent", "8");
		boardData02.put("parent", "11");
		
		boardData01.put("code", "32");
		boardData02.put("code", "64");
		
		model.addAttribute("boardData01", boardData01);
		model.addAttribute("boardData02", boardData02);
		model.addAttribute("popupList", popupList);
		
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
