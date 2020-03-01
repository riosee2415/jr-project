package com.patis.NM02.NM020465;

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
 * @SCREEN : 도시재상사업 소개 ->  도시재생 관계 법령(statute)
 *
 */
@Controller
public class Nm020465Controller {
	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;

	@RequestMapping(value="/statute.do", method=RequestMethod.GET)
	public String sendScreen(Model model) throws Exception{
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		
		return "statute";
	}
}
