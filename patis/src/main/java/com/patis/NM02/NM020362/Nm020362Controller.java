package com.patis.NM02.NM020362;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.patis.middleware.I_MiddlewareService;
import com.patis.model.CommonVO;

/**
 * @author : 4LEAF.YSH
 * @SCREEN : 중랑의 도시재생 -> 도시재생 지역현황 (policy.loc)
 *
 */
@Controller
public class Nm020362Controller {
	
	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;

	@RequestMapping(value="/policy.loc.do", method=RequestMethod.GET)
	public String sendScreen(Model model) throws Exception{
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		
		return "policy.loc";
	}
}
