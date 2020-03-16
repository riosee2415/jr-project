package com.patis.admin.AD0103;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.patis.middleware.I_MiddlewareService;
import com.patis.model.CommonVO;
import com.patis.model.EmpVO;

@Controller
public class Ad0103Controller {
	
	@Resource(name = "middlewareService")
	private I_MiddlewareService middlewareService;
	
	@Resource(name = "ad0103Service")
	private I_Ad0103Service ad0103Service;
	
	
	@RequestMapping(value = "/userControll.do", method = RequestMethod.GET)
	public String sendScreen() {
		
		return "useControll";
	}
	
	@RequestMapping(value = "/getAllUser.do", method = RequestMethod.GET)
	public String getAllUser(Model model) {
		
		List<EmpVO> list = ad0103Service.getAllUser();
		
		model.addAttribute("userList", list);

		return "ajax/adAllUser";
	}
	
	@RequestMapping(value = "/getUserById.do", method = RequestMethod.GET)
	public String getUserById(@RequestParam("userId")String userId, Model model) {
		
		EmpVO vo = ad0103Service.getUserById(userId);
		
		model.addAttribute("user", vo);

		return "ajax/adGetUser";
	}
	
	@RequestMapping(value = "/getComboData.do", method = RequestMethod.GET)
	public String getComboData(@RequestParam("code")String code, Model model) {
		
		List<CommonVO> list = new ArrayList<CommonVO>();
		
		try {
			list = middlewareService.getComboData(code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("combo", list);

		return "ajax/combo";
	}
}
