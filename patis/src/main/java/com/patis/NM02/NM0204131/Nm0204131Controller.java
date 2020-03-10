package com.patis.NM02.NM0204131;

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
 * @SCREEN : 도시재생사업 소개 ->  도시재생 관계 법령(statute)
 *
 */
@Controller
public class Nm0204131Controller {
	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;

	@Resource(name="nm0204131Service")
	private I_Nm0204131Service nm0204131Service;
	
	@RequestMapping(value="/statute.do", method=RequestMethod.GET)
	public String sendScreen(Model model) throws Exception{
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		int page = nm0204131Service.getListCount();
		page = page / 10;
		model.addAttribute("page", page % 10 == 0 ? page : page + 1);
		
		String b_type = nm0204131Service.getBoardType();
		model.addAttribute("b_type", b_type);
		
		return "statute";
	}
	
	@RequestMapping(value="/statute.detail.do", method=RequestMethod.GET)
	public String sendDetailScreen(Model model,
			 					   @RequestParam(value="b_no")int b_no) throws Exception {
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		nm0204131Service.modifyHitUp(b_no);
		
		BoardVO data = nm0204131Service.getStatute(b_no);
		model.addAttribute("data", data);
		
		BoardVO prevData = nm0204131Service.getPrevStatute(b_no);
		BoardVO nextData = nm0204131Service.getNextStatute(b_no);
		model.addAttribute("prevData", prevData);
		model.addAttribute("nextData", nextData);
		
		return "statute.detail";
	}
	
	@RequestMapping(value = "/nm0204131Init.do", method = RequestMethod.GET)
	public String ajaxPaging(Model model,
						   @RequestParam("page")int page) throws Exception {
		
		List<BoardVO> statuteList = nm0204131Service.getStatuteList((page-1)*10);
		model.addAttribute("boardList", statuteList);
	
		
		return "ajax/nm0204131Init";
	}
}
