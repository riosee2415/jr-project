package com.patis.main;

import java.util.List;

import javax.annotation.Resource;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.patis.middleware.I_MiddlewareService;
import com.patis.middleware.MiddlewareServiceImpl;
import com.patis.model.CommonVO;

@Controller
public class MainController {
	
	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;
	
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
	
}
