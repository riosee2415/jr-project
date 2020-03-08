package com.patis.NM02.NM021164;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.patis.middleware.I_MiddlewareService;
import com.patis.model.BoardVO;
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

	@Resource(name="nm021164Service")
	private I_Nm021164Service nm021164Service;
	
	@RequestMapping(value="/collusion.apply.do", method=RequestMethod.GET)
	public String sendScreen(Model model) throws Exception{
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		int page = nm021164Service.getListCount();
		page = page / 10;
		model.addAttribute("page", page+1);
		
		return "collusion.apply";
	}
	
	@RequestMapping(value="/collusion.apply.detail.do", method=RequestMethod.GET)
	public String sendDetailScreen(Model model,
			 					   @RequestParam(value="b_no")int b_no) throws Exception {
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		nm021164Service.modifyHitUp(b_no);
		
		BoardVO data = nm021164Service.getCollusion(b_no);
		model.addAttribute("data", data);
		
		BoardVO prevData = nm021164Service.getPrevCollusion(b_no);
		BoardVO nextData = nm021164Service.getNextCollusion(b_no);
		model.addAttribute("prevData", prevData);
		model.addAttribute("nextData", nextData);
		
		return "collusion.apply.detail";
	}
	
	@RequestMapping(value = "/nm021164Init.do", method = RequestMethod.GET)
	public String ajaxPaging(Model model,
						   @RequestParam("page")int page) throws Exception {
		
		List<BoardVO> collusionList = nm021164Service.getCollusionList((page-1)*10);
		model.addAttribute("collusionList", collusionList);
	
		return "ajax/nm021164Init";
	}

}
