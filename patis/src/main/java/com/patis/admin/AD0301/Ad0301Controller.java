package com.patis.admin.AD0301;

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
import com.patis.model.Accept_typeVO;
import com.patis.model.CommonVO;

@Controller
public class Ad0301Controller {
	
	@Resource(name = "middlewareService")
	private I_MiddlewareService middlewareService;
	
	@Resource(name = "ad0301Service")
	private I_Ad0301Service ad0301Service;

	@RequestMapping(value = "/boardManager.do", method = RequestMethod.GET)
	public String sendScreen(@RequestParam("mc") String mc, @RequestParam("sc") String sc, HttpSession session,
			Model model) {
		
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

		if (right == 1 || right == 2) {
			middlewareService.printLog("관리자 권한으로 로그인 되었습니다.");
			
			
			
			flag = true;

		}

		if (flag) {
			return "boardManager";
		} else {
			return "main";

		}
		
	}
	
	@RequestMapping(value = "/getBoardAdminRight.do", method = RequestMethod.GET)
	public String getBoardAdminRight(Model model) {
		
		List<Accept_typeVO> list = ad0301Service.getBoardName();
		
		model.addAttribute("list", list);
		
		return "ajax/getBoardAdminRight";
	}
	
	
	@RequestMapping(value = "/getBoardAdminRightByName.do", method = RequestMethod.GET)
	public String getBoardAdminRightByName(@RequestParam("name")String name, Model model) {
		
		Accept_typeVO vo = ad0301Service.getBoardAdminRightByName(name);
		model.addAttribute("data", vo);
		
		return "ajax/getBoardAdminRightByName";
	}
	
	@RequestMapping(value = "/boardAcceptRightModify.do", method = RequestMethod.GET)
	public String boardAcceptRightModify(@RequestParam("name")String name
									, @RequestParam("right")String right
									, Model model
									, RedirectAttributes redirect) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("name", name);
		params.put("right", Integer.parseInt(right));
		
		int result = ad0301Service.boardAcceptRightModify(params);
		
		redirect.addAttribute("name", name);
		
		return "redirect:/getBoardAdminRightByName.do";
	}
	
}
