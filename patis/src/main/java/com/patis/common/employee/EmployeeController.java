package com.patis.common.employee;

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

@Controller
public class EmployeeController {

	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;
	
	@Resource(name = "employeeService")
	private I_EmployeeService employeeService;
	
	@RequestMapping(value="/join-step-1.do", method=RequestMethod.GET)
	public String login(Model model) throws Exception {
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		return "join-step-1";
	}
	
	
	@RequestMapping(value="/join-step-2.do", method=RequestMethod.POST)
	public String joinStart(Model model) throws Exception {
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		return "join-step-2";
	}
	
	
	@RequestMapping(value="/join-step-3.do", method=RequestMethod.POST)
	public String agree(Model model) throws Exception {
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		return "join-step-3";
	}
	
	@RequestMapping(value="/phonePop.do", method=RequestMethod.GET)
	public String phonePop(Model model) throws Exception {
		
		
		return "phonePop";
	}
	
	
	
	@RequestMapping(value="/idDupleCheckAjax.do", method=RequestMethod.POST)
	@ResponseBody
	public String idDupleCheckAjax(@RequestParam("joinId")String joinId ,Model model) throws Exception {
			
		int result = employeeService.dupleCheckId(joinId);
		
		System.out.println(result);
		System.out.println(result);
		System.out.println(result);
		System.out.println(result);
		System.out.println(result);
		System.out.println(result);
		
		return result + "";
	}
	
}
