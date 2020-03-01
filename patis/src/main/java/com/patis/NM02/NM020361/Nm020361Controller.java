package com.patis.NM02.NM020361;

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
 * @SCREEN : 以묐옉�쓽 �룄�떆�옱�깮 -> �룄�떆�옱�깮 �젙梨� (policy)
 *
 */
@Controller
public class Nm020361Controller {
	
	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;
	
	@RequestMapping(value="/policy.do", method=RequestMethod.GET)
	public String sendScreen(Model model) throws Exception{
		
//		List<CommonVO> menuList = middlewareService.getMenu();
//		model.addAttribute("menuList", menuList);
		
		return "policy";
	}
}
