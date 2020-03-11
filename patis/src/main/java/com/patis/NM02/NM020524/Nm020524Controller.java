package com.patis.NM02.NM020524;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.patis.NM02.NM021164.I_Nm021164Service;
import com.patis.middleware.I_MiddlewareService;
import com.patis.model.BoardVO;
import com.patis.model.CommonVO;

/**
 * @author : 4LEAF.YSH
 * @SCREEN : 도시재생 공모사업 ->  공모사업 신청(collusion.apply)
 *
 */
@Controller
public class Nm020524Controller {
	
	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;

	@Resource(name="nm020524Service")
	private I_Nm020524Service nm020524Service;
	
	@Resource(name="nm021164Service")
	private I_Nm021164Service nm021164Service;
	
	@RequestMapping(value="/community.do", method=RequestMethod.GET)
	public String sendScreen(Model model) throws Exception{
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		return "community";
	}
	
	@RequestMapping(value="/community.write.do", method=RequestMethod.GET)
	public String communityWrite(Model model,
								 @RequestParam(value="mode", defaultValue="WRITE")String mode,
								 @RequestParam(value="b_no", required=false)Integer b_no) throws Exception{
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		if(mode.equals("MODIFY")) {
			// BoardVO data = nm020524Service.getCommunity(b_no);
			// model.addAttribute("data", data);
		}
		
		String b_type = nm021164Service.getBoardType(); // 수정 필요
		model.addAttribute("b_type", b_type);
		
		model.addAttribute("mode", mode);
		
		return "community.write";
	}
	
	@RequestMapping(value="/community.write.do", method=RequestMethod.POST)
	public String communityWriteProcess(Model model,
		 						 @RequestParam(value="parent")String parent,
		 						 @RequestParam(value="code")String code,
								 @RequestParam(value="mode")String mode,
								 @RequestParam(value="b_type")String b_type,
								 @RequestParam(value="b_no", required=false)Integer b_no,
								 @RequestParam(value="b_title")String b_title,
								 @RequestParam(value="b_description")String b_description,
								 @RequestParam(value="b_author")String b_author,
								 RedirectAttributes rttr) throws Exception{
		
		BoardVO boardVO = new BoardVO();
		boardVO.setB_TYPE(b_type);
		boardVO.setB_TITLE(b_title);
		boardVO.setB_DESCRIPTION(b_description);
		boardVO.setB_AUTHOR(b_author);
		
		System.out.println(boardVO);
		if(mode.equals("WRITE")) {
			nm020524Service.setCommunity(boardVO);
			rttr.addFlashAttribute("msg", "게시글이 등록되었습니다.");
		} else {
			boardVO.setB_NO(b_no);
		}
		
		rttr.addAttribute("parent", parent);
		rttr.addAttribute("code", code);
		
		return "redirect:/community.do";
	}

}
