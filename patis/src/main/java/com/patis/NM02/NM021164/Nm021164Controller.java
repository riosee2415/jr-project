package com.patis.NM02.NM021164;

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
 * @SCREEN : 도시재생 공모사업 ->  공모사업 신청(collusion.apply)
 *
 */
@Controller
public class Nm021164Controller {
	
	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;

	@RequestMapping(value="/collusion.apply.do", method=RequestMethod.GET)
	public String sendScreen(Model model) throws Exception{
		
//		List<CommonVO> menuList = middlewareService.getMenu();
//		model.addAttribute("menuList", menuList);
//		List<CommonVO> subMenuList = middlewareService.getSubMenu();
//		model.addAttribute("subMenuList", subMenuList);
//		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
//		model.addAttribute("DetailMenuList", DetailMenuList);
		
		return "collusion.apply";
	}

}
