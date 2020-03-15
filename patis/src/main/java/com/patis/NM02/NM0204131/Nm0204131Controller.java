package com.patis.NM02.NM0204131;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.patis.common.file.I_FileService;
import com.patis.common.tempFile.I_TempFileService;
import com.patis.middleware.I_MiddlewareService;
import com.patis.model.Accept_typeVO;
import com.patis.model.BoardFileVO;
import com.patis.model.BoardTempFileVO;
import com.patis.model.BoardVO;
import com.patis.model.CommonVO;

/**
 * @author : 4LEAF.NJM
 * @SCREEN : 도시재생사업 소개 ->  도시재생 관계 법령(statute)
 *
 */
@Controller
public class Nm0204131Controller {
	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;

	@Resource(name="nm0204131Service")
	private I_Nm0204131Service nm0204131Service;
	
	@Resource(name="fileService")
	private I_FileService fileService;
	
	@Resource(name="tempFileService")
	private I_TempFileService tempFileService;
	
	@RequestMapping(value="/statute.do", method=RequestMethod.GET)
	public String sendScreen(Model model,
							 @RequestParam(value="s_type", defaultValue="")String searchType,
						 	 @RequestParam(value="s_keyword", defaultValue="")String searchKeyword) throws Exception{
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		String b_type = nm0204131Service.getBoardType();
		model.addAttribute("b_type", b_type);
		
		Accept_typeVO AcceptRight = middlewareService.getAcceptRight(b_type);
		model.addAttribute("AcceptRight", AcceptRight);
		
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchKeyword", searchKeyword);
		
		return "statute";
	}
	
	@RequestMapping(value="/statute.detail.do", method=RequestMethod.GET)
	public String sendDetailScreen(Model model, 
								   HttpSession session,
								   @RequestParam(value="parent")String parent,
								   @RequestParam(value="code")String code,
			 					   @RequestParam(value="b_no")int b_no,
			 					   @RequestParam(value="rownum")int rownum,
			 					   @RequestParam(value="s_type", defaultValue="")String searchType,
			 					   @RequestParam(value="s_keyword", defaultValue="")String searchKeyword,
			 					   RedirectAttributes rttr) throws Exception {
		
		String btype = nm0204131Service.getBoardType();
		
		Accept_typeVO AcceptRight = middlewareService.getAcceptRight(btype);
		model.addAttribute("AcceptRight", AcceptRight);
		
		if(session.getAttribute("loginRight") != null) {
			if(Integer.parseInt(session.getAttribute("loginRight").toString()) > Integer.parseInt(AcceptRight.getVIEW_RIGHT())) {
				rttr.addAttribute("parent", parent);
				rttr.addAttribute("code", code);
				rttr.addAttribute("s_type", searchType);
				rttr.addAttribute("s_keyword", searchKeyword);
				rttr.addFlashAttribute("msg", "사용자님은 해당 글을 볼 수 있는 권한이 없습니다.");
				return "redirect:/statute.do";
			}
		}
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		BoardVO data = nm0204131Service.getStatute(b_no);
		model.addAttribute("data", data);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("BOARD_TYPE", btype);
		params.put("BOARD_NO", b_no);
		
		List<BoardFileVO> fileList = fileService.getAttachFileList(params);
		model.addAttribute("fileList", fileList);
		
		params = new HashMap<String, Object>();
		params.put("rownum", rownum);
		params.put("searchType", searchType);
		params.put("searchKeyword", searchKeyword);
		
		BoardVO prevData = nm0204131Service.getPrevStatute(params);
		BoardVO nextData = nm0204131Service.getNextStatute(params);
		
		model.addAttribute("prevData", prevData);
		model.addAttribute("nextData", nextData);
		
		model.addAttribute("rownum", rownum);
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchKeyword", searchKeyword);
		
		return "statute.detail";
	}
	
	@ResponseBody
	@RequestMapping(value = "/statute.hitUp.do", method = RequestMethod.POST, produces="application/json")
	public Map<String, Object> ajaxHitUp(Model model,
						 @RequestParam("b_no")int b_no) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		int result = nm0204131Service.modifyHitUp(b_no);
		data.put("result", result);
		
		return data;
	}
	
	@RequestMapping(value="/statute.write.do", method=RequestMethod.GET)
	public String statuteWrite(Model model,
								 HttpSession session,
								 RedirectAttributes rttr,
								 @RequestParam(value="parent")String parent,
							     @RequestParam(value="code")String code,
								 @RequestParam(value="mode", defaultValue="WRITE")String mode,
								 @RequestParam(value="b_no", required=false)Integer b_no,
								 @RequestParam(value="rownum", required=false)Integer rownum,
								 @RequestParam(value="s_type", defaultValue="")String searchType,
		 					     @RequestParam(value="s_keyword", defaultValue="")String searchKeyword) throws Exception{
		
		String b_type = nm0204131Service.getBoardType();
		
		Accept_typeVO AcceptRight = middlewareService.getAcceptRight(b_type);
		model.addAttribute("AcceptRight", AcceptRight);
		
		if(session.getAttribute("loginRight") != null) {
			if(Integer.parseInt(session.getAttribute("loginRight").toString()) > Integer.parseInt(AcceptRight.getWRITE_RIGHT())) {
				rttr.addAttribute("parent", parent);
				rttr.addAttribute("code", code);
				rttr.addAttribute("s_type", searchType);
				rttr.addAttribute("s_keyword", searchKeyword);
				rttr.addFlashAttribute("msg", "사용자님은 해당 게시판에 작성할 수 있는 권한이 없습니다.");
				return "redirect:/statute.do";
			}
		}
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		String file_key = UUID.randomUUID().toString();
		model.addAttribute("file_key", file_key);
		
		if(mode.equals("MODIFY")) {
			BoardVO data = nm0204131Service.getStatute(b_no);
			model.addAttribute("data", data);
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("BOARD_TYPE", b_type);
			params.put("BOARD_NO", b_no);
			
			List<BoardFileVO> fileList = fileService.getAttachFileList(params);
			model.addAttribute("fileList", fileList);
		} 
		model.addAttribute("mode", mode);
		model.addAttribute("b_type", b_type);
		model.addAttribute("rownum", rownum);
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchKeyword", searchKeyword);
		
		return "statute.write";
	}
	
	@RequestMapping(value="/statute.write.do", method=RequestMethod.POST)
	public String statuteWriteProcess(@RequestParam(value="parent")String parent,
				 						@RequestParam(value="code")String code,
										@RequestParam(value="mode")String mode,
										@RequestParam(value="b_type")String b_type,
										@RequestParam(value="rownum", required=false)Integer rownum,
										@RequestParam(value="b_no", required=false)Integer b_no,
										@RequestParam(value="b_title")String b_title,
										@RequestParam(value="b_description")String b_description,
										@RequestParam(value="b_author")String b_author,
										@RequestParam(value="b_author_none")String b_author_none,
										@RequestParam(value="file_key")String file_key,
										@RequestParam(value="remove_file")String removeFile,
										@RequestParam(value="s_type", defaultValue="")String searchType,
				 					    @RequestParam(value="s_keyword", defaultValue="")String searchKeyword,
										RedirectAttributes rttr) throws Exception{
		String url = "";
		int boardNo = 0;
	
		if(b_description.indexOf(',') == 0) {
			b_description = b_description.substring(1, b_description.length());
		}
		BoardVO boardVO = new BoardVO();
		boardVO.setB_TYPE(b_type);
		boardVO.setB_TITLE(b_title);
		boardVO.setB_DESCRIPTION(b_description);
		boardVO.setB_AUTHOR(b_author);
		boardVO.setB_AUTHOR_NONE(b_author_none);
		
		if(mode.equals("WRITE")) {
			nm0204131Service.setStatute(boardVO);
			boardNo = boardVO.getB_NO();
			
			rttr.addFlashAttribute("msg", "게시글이 등록되었습니다.");
			url = "redirect:/statute.do";
		} else {
			boardNo = b_no;
			boardVO.setB_NO(b_no);
			nm0204131Service.modifyStatute(boardVO);
			
			if(!removeFile.equals("")) {
				String[] removeFiles = removeFile.split(",");
				for(String fileNo : removeFiles) {
					fileService.removeFile(Integer.parseInt(fileNo));
				}
			}
			rttr.addAttribute("b_no", b_no);
			rttr.addAttribute("rownum", rownum);
			rttr.addAttribute("s_type", searchType);
			rttr.addAttribute("s_keyword", searchKeyword);
			rttr.addFlashAttribute("msg", "게시글이 변경되었습니다.");
			url = "redirect:/statute.detail.do";
		}
		List<BoardTempFileVO> tempFileList = tempFileService.getTempFileListByKey(file_key);
		for(BoardTempFileVO tempFileVO : tempFileList) {
			BoardFileVO fileVO = new BoardFileVO();
			fileVO.setFILE_O_PATH(tempFileVO.getTFILE_O_PATH());
			fileVO.setFILE_V_PATH(tempFileVO.getTFILE_V_PATH());
			fileVO.setBOARD_TYPE(b_type);
			fileVO.setBOARD_NO(boardNo);
			fileVO.setATTACH_YN(tempFileVO.getATTACH_YN());
			fileService.setFile(fileVO);
		}
		tempFileService.removeTempFile(file_key);
		
		rttr.addAttribute("parent", parent);
		rttr.addAttribute("code", code);
		
		return url;
	}
	
	@RequestMapping(value="/statute.remove.do", method=RequestMethod.POST)
	public String statuteRemoveProcess(@RequestParam(value="parent")String parent,
										 @RequestParam(value="code")String code,
										 @RequestParam(value="b_no")Integer b_no,
										 @RequestParam(value="s_type", defaultValue="")String searchType,
										 @RequestParam(value="s_keyword", defaultValue="")String searchKeyword,
										 RedirectAttributes rttr) throws Exception {
		
		nm0204131Service.removeStatute(b_no);
		
		rttr.addFlashAttribute("msg", "게시글이 삭제 처리 되었습니다.");
		
		rttr.addAttribute("parent", parent);
		rttr.addAttribute("code", code);
		rttr.addAttribute("s_type", searchType);
		rttr.addAttribute("s_keyword", searchKeyword);
		
		return "redirect:/statute.do";
	}
	@RequestMapping(value = "/nm0204131Init.do", method = RequestMethod.GET)
	public String ajaxInit(Model model,
			               @RequestParam("paging") int paging,
			               @RequestParam(value="search_type", defaultValue="") String searchType,
			               @RequestParam(value="search_keyword", defaultValue="") String searchKeyword) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("paging", Integer.toString((paging-1) * 10));
		params.put("searchType", searchType);
		params.put("searchKeyword", searchKeyword);
		
		List<BoardVO> statuteList = nm0204131Service.getStatuteSearchList(params);
		model.addAttribute("boardList", statuteList);
		
		return "ajax/nm0204131Init";
	}
	
	@RequestMapping(value = "/nm0204131Paging.do", method = RequestMethod.GET)
	public String ajaxPaging(Model model,  
							 @RequestParam(value="search_type", defaultValue="") String searchType,
				             @RequestParam(value="search_keyword", defaultValue="") String searchKeyword) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("searchType", searchType);
		params.put("searchKeyword", searchKeyword);
		
		int page = nm0204131Service.getSearchListCount(params);
		page = page % 10 == 0 ? page / 10 : page / 10 + 1;
		model.addAttribute("page", page);
		
		return "ajax/pagination";
	}
}
