package com.patis.admin.AD0103;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String sendScreen(@RequestParam("mc") String mc, @RequestParam("sc") String sc, HttpSession session,
	Model model ){
		
		boolean flag = false;
		int right = 0;

		if (session.getAttribute("loginRight") == null) {
			try {
				List<CommonVO> menuList = middlewareService.getMenu();
				model.addAttribute("menuList", menuList);
				List<CommonVO> subMenuList = middlewareService.getSubMenu();
				model.addAttribute("subMenuList", subMenuList);
				List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
				model.addAttribute("DetailMenuList", DetailMenuList);
			} catch (Exception e) {
				System.out.println(e);
			}

		} else {
			right = Integer.parseInt((String) session.getAttribute("loginRight"));
		}

		if (right == 1 || right == 2 || right == 3) {
			middlewareService.printLog("관리자 또는 운영자 권한으로 로그인 되었습니다.");
			
			
			
			flag = true;

		}

		if (flag) {
			return "useControll";
		} else {
			return "main";

		}
		
		
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
	
	
	@RequestMapping(value = "/updateUserInfo.do", method = RequestMethod.GET)
	public String updateUserInfo(@RequestParam("userId")String userId
								,@RequestParam("userDept")String userDept
								,@RequestParam("userGroup")String userGroup
								,@RequestParam("userRight")String userRight
								,@RequestParam("userTel")String userTel
								,@RequestParam("userMobile")String userMobile
								,@RequestParam("userEmail")String userEmail
								,@RequestParam("userZonecode")String userZonecode
								,@RequestParam("userAddr1")String userAddr1
								,@RequestParam("userAddr2")String userAddr2
								,RedirectAttributes redirect) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("userId", userId);
		params.put("userDept", userDept);
		params.put("userGroup", userGroup);
		params.put("userRight", Integer.parseInt(userRight));
		params.put("userTel", userTel);
		params.put("userMobile", userMobile);
		params.put("userEmail", userEmail);
		params.put("userZonecode", userZonecode);
		params.put("userAddr1", userAddr1);
		params.put("userAddr2", userAddr2);
		
		int result = ad0103Service.updateUserInfo(params);
		
		redirect.addAttribute("userId", userId);
		
		return "redirect:/getUserById.do";
	}
	

	@RequestMapping(value = "/searchUserInfo.do", method = RequestMethod.GET)
	public String searchUserInfo(@RequestParam("searchType")String searchType
								,@RequestParam("searchValue")String searchValue
								,Model model) {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("searchType", searchType);
		params.put("searchValue", searchValue);
		
		List<EmpVO> list = ad0103Service.searchUserInfo(params);
		
		model.addAttribute("userList", list);

		return "ajax/adAllUser";
	}
	
	

	@RequestMapping(value = "/deleteUserInfo.do", method = RequestMethod.GET)
	public String deleteUserInfo(@RequestParam("userId")String userId
								,Model model) {
		
		int result = ad0103Service.deleteUser(userId);

		return "useControll";
	}
	
	
	
	
}
