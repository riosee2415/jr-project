package com.patis.NM02.NM021164;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String sendScreen(Model model,
							 @RequestParam(value="s_type", defaultValue="")String searchType,
						 	 @RequestParam(value="s_keyword", defaultValue="")String searchKeyword) throws Exception{
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		String b_type = nm021164Service.getBoardType();
		model.addAttribute("b_type", b_type);
		
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchKeyword", searchKeyword);
		
		return "collusion.apply";
	}
	
	@RequestMapping(value="/collusion.apply.detail.do", method=RequestMethod.GET)
	public String sendDetailScreen(Model model,
			 					   @RequestParam(value="b_no")int b_no,
			 					   @RequestParam(value="rownum")int rownum,
			 					   @RequestParam(value="s_type", defaultValue="")String searchType,
			 					   @RequestParam(value="s_keyword", defaultValue="")String searchKeyword) throws Exception {
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		BoardVO data = nm021164Service.getCollusion(b_no);
		model.addAttribute("data", data);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("rownum", rownum);
		params.put("searchType", searchType);
		params.put("searchKeyword", searchKeyword);
		
		BoardVO prevData = nm021164Service.getPrevCollusion(params);
		BoardVO nextData = nm021164Service.getNextCollusion(params);
		
		model.addAttribute("prevData", prevData);
		model.addAttribute("nextData", nextData);
		
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchKeyword", searchKeyword);
		
		return "collusion.apply.detail";
	}
	
	@ResponseBody
	@RequestMapping(value = "/collusion.apply.hitUp.do", method = RequestMethod.POST, produces="application/json")
	public Map<String, Object> ajaxHitUp(Model model,
						 @RequestParam("b_no")int b_no) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		int result = nm021164Service.modifyHitUp(b_no);
		data.put("result", result);
		
		return data;
	}
	
	@RequestMapping(value="/collusion.apply.write.do", method=RequestMethod.GET)
	public String collusionWrite(Model model,
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
		
		String b_type = nm021164Service.getBoardType();
		model.addAttribute("b_type", b_type);
		
		model.addAttribute("mode", mode);
		
		return "collusion.apply.write";
	}
	
	@RequestMapping(value="/collusion.apply.write.do", method=RequestMethod.POST)
	public String collusionWriteProcess(Model model,
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
		
		if(mode.equals("WRITE")) {
			nm021164Service.setCollusion(boardVO);
			rttr.addFlashAttribute("msg", "게시글이 등록되었습니다.");
		} else {
			boardVO.setB_NO(b_no);
		}
		
		rttr.addAttribute("parent", parent);
		rttr.addAttribute("code", code);
		
		return "redirect:/collusion.apply.do";
	}
	
	@RequestMapping(value = "/nm021164Init.do", method = RequestMethod.GET)
	public String ajaxInit(Model model,
			               @RequestParam("paging") int paging,
			               @RequestParam(value="search_type", defaultValue="") String searchType,
			               @RequestParam(value="search_keyword", defaultValue="") String searchKeyword) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("paging", Integer.toString((paging-1) * 10));
		params.put("searchType", searchType);
		params.put("searchKeyword", searchKeyword);
		
		List<BoardVO> collusionList = nm021164Service.getCollusionSearchList(params);
		model.addAttribute("boardList", collusionList);
		
		return "ajax/nm021164Init";
	}
	
	@RequestMapping(value = "/nm021164Paging.do", method = RequestMethod.GET)
	public String ajaxPaging(Model model,  
							 @RequestParam(value="search_type", defaultValue="") String searchType,
				             @RequestParam(value="search_keyword", defaultValue="") String searchKeyword) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("searchType", searchType);
		params.put("searchKeyword", searchKeyword);
		
		int page = nm021164Service.getSearchListCount(params);
		page = page % 10 == 0 ? page / 10 : page / 10 + 1;
		model.addAttribute("page", page);
		
		return "ajax/pagination";
	}

}
