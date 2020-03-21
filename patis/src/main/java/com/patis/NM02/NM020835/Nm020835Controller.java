package com.patis.NM02.NM020835;

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
 * @SCREEN : 알림마당 -> 채용공고(hire)
 *
 */
@Controller
public class Nm020835Controller {
	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;

	@Resource(name="nm020835Service")
	private I_Nm020835Service nm020835Service;
	
	@Resource(name="fileService")
	private I_FileService fileService;
	
	@Resource(name="tempFileService")
	private I_TempFileService tempFileService;
	
	@RequestMapping(value="/hire.do", method=RequestMethod.GET)
	public String sendScreen(Model model,
							 @RequestParam(value="s_type", defaultValue="")String searchType,
						 	 @RequestParam(value="s_keyword", defaultValue="")String searchKeyword) throws Exception{

		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		String b_type = nm020835Service.getBoardType();
		model.addAttribute("b_type", b_type);
		
		Accept_typeVO AcceptRight = middlewareService.getAcceptRight(b_type);
		model.addAttribute("AcceptRight", AcceptRight);
		
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchKeyword", searchKeyword);
		
		return "hire";
	}
	
	@RequestMapping(value="/hire.detail.do", method=RequestMethod.GET)
	public String sendDetailScreen(Model model, 
								   HttpSession session,
								   @RequestParam(value="parent")String parent,
								   @RequestParam(value="code")String code,
			 					   @RequestParam(value="b_no")int b_no,
			 					   @RequestParam(value="rownum")int rownum,
			 					   @RequestParam(value="s_type", defaultValue="")String searchType,
			 					   @RequestParam(value="s_keyword", defaultValue="")String searchKeyword,
			 					   RedirectAttributes rttr) throws Exception {
		
		String btype = nm020835Service.getBoardType();
		
		Accept_typeVO AcceptRight = middlewareService.getAcceptRight(btype);
		model.addAttribute("AcceptRight", AcceptRight);
		
		if(session.getAttribute("loginRight") != null) {
			if(Integer.parseInt(session.getAttribute("loginRight").toString()) > Integer.parseInt(AcceptRight.getVIEW_RIGHT())) {
				rttr.addAttribute("parent", parent);
				rttr.addAttribute("code", code);
				rttr.addAttribute("s_type", searchType);
				rttr.addAttribute("s_keyword", searchKeyword);
				rttr.addFlashAttribute("msg", "사용자님은 해당 글을 볼 수 있는 권한이 없습니다.");
				return "redirect:/hire.do";
			}
		}
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		BoardVO data = nm020835Service.getHire(b_no);
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
		
		BoardVO prevData = nm020835Service.getPrevHire(params);
		BoardVO nextData = nm020835Service.getNextHire(params);
		
		model.addAttribute("prevData", prevData);
		model.addAttribute("nextData", nextData);
		
		model.addAttribute("rownum", rownum);
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchKeyword", searchKeyword);
		
		return "hire.detail";
	}
	
	@ResponseBody
	@RequestMapping(value = "/hire.hitUp.do", method = RequestMethod.POST, produces="application/json")
	public Map<String, Object> ajaxHitUp(Model model,
						 @RequestParam("b_no")int b_no) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		int result = nm020835Service.modifyHitUp(b_no);
		data.put("result", result);
		
		return data;
	}
	
	@RequestMapping(value="/hire.write.do", method=RequestMethod.GET)
	public String hireWrite(Model model,
								 HttpSession session,
								 RedirectAttributes rttr,
								 @RequestParam(value="parent")String parent,
							     @RequestParam(value="code")String code,
								 @RequestParam(value="mode", defaultValue="WRITE")String mode,
								 @RequestParam(value="b_no", required=false)Integer b_no,
								 @RequestParam(value="rownum", required=false)Integer rownum,
								 @RequestParam(value="s_type", defaultValue="")String searchType,
		 					     @RequestParam(value="s_keyword", defaultValue="")String searchKeyword) throws Exception{
		
		String b_type = nm020835Service.getBoardType();
		
		Accept_typeVO AcceptRight = middlewareService.getAcceptRight(b_type);
		model.addAttribute("AcceptRight", AcceptRight);
		
		if(session.getAttribute("loginRight") != null) {
			if(Integer.parseInt(session.getAttribute("loginRight").toString()) > Integer.parseInt(AcceptRight.getWRITE_RIGHT())) {
				rttr.addAttribute("parent", parent);
				rttr.addAttribute("code", code);
				rttr.addAttribute("s_type", searchType);
				rttr.addAttribute("s_keyword", searchKeyword);
				rttr.addFlashAttribute("msg", "사용자님은 해당 게시판에 작성할 수 있는 권한이 없습니다.");
				return "redirect:/hire.do";
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
			BoardVO data = nm020835Service.getHire(b_no);
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
		
		return "hire.write";
	}
	
	@RequestMapping(value="/hire.write.do", method=RequestMethod.POST)
	public String hireWriteProcess(@RequestParam(value="parent")String parent,
				 						@RequestParam(value="code")String code,
										@RequestParam(value="mode")String mode,
										@RequestParam(value="b_type")String b_type,
										@RequestParam(value="rownum", required=false)Integer rownum,
										@RequestParam(value="b_no", required=false)Integer b_no,
										@RequestParam(value="b_title")String b_title,
										@RequestParam(value="b_description")String b_description,
										@RequestParam(value="b_author")String b_author,
										@RequestParam(value="b_author_none", defaultValue="", required=false)String b_author_none,
										@RequestParam(value="file_key")String file_key,
										@RequestParam(value="remove_file")String removeFile,
										@RequestParam(value="s_type", defaultValue="")String searchType,
				 					    @RequestParam(value="s_keyword", defaultValue="")String searchKeyword,
										RedirectAttributes rttr) throws Exception{
		String url = "";
		int boardNo = 0;
	
		String[] tags = b_description.split("<p");
		b_description = "";
		
		for(String tag : tags) {
			if(tag.contains("</p>")) {
				b_description += "<p" + tag.substring(0, tag.indexOf("</p>")) + "</p>";
			} 
		}
		
		BoardVO boardVO = new BoardVO();
		boardVO.setB_TYPE(b_type);
		boardVO.setB_TITLE(b_title);
		boardVO.setB_DESCRIPTION(b_description);
		boardVO.setB_AUTHOR(b_author);
		boardVO.setB_AUTHOR_NONE(b_author_none);
		
		if(mode.equals("WRITE")) {
			nm020835Service.setHire(boardVO);
			boardNo = boardVO.getB_NO();
			
			rttr.addFlashAttribute("msg", "게시글이 등록되었습니다.");
			url = "redirect:/hire.do";
		} else {
			boardNo = b_no;
			boardVO.setB_NO(b_no);
			nm020835Service.modifyHire(boardVO);
			
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
			url = "redirect:/hire.detail.do";
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
	
	@RequestMapping(value="/hire.remove.do", method=RequestMethod.POST)
	public String hireRemoveProcess(@RequestParam(value="parent")String parent,
										 @RequestParam(value="code")String code,
										 @RequestParam(value="b_no")Integer b_no,
										 @RequestParam(value="s_type", defaultValue="")String searchType,
										 @RequestParam(value="s_keyword", defaultValue="")String searchKeyword,
										 RedirectAttributes rttr) throws Exception {
		
		nm020835Service.removeHire(b_no);
		
		rttr.addFlashAttribute("msg", "게시글이 삭제 처리 되었습니다.");
		
		rttr.addAttribute("parent", parent);
		rttr.addAttribute("code", code);
		rttr.addAttribute("s_type", searchType);
		rttr.addAttribute("s_keyword", searchKeyword);
		
		return "redirect:/hire.do";
	}
	@RequestMapping(value = "/nm020835Init.do", method = RequestMethod.GET)
	public String ajaxInit(Model model,
			               @RequestParam("paging") int paging,
			               @RequestParam(value="search_type", defaultValue="") String searchType,
			               @RequestParam(value="search_keyword", defaultValue="") String searchKeyword) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("paging", Integer.toString((paging-1) * 10));
		params.put("searchType", searchType);
		params.put("searchKeyword", searchKeyword);
		
		List<BoardVO> hireList = nm020835Service.getHireSearchList(params);
		model.addAttribute("boardList", hireList);
		
		return "ajax/nm020835Init";
	}
	
	@RequestMapping(value = "/nm020835Paging.do", method = RequestMethod.GET)
	public String ajaxPaging(Model model,  
							 @RequestParam(value="search_type", defaultValue="") String searchType,
				             @RequestParam(value="search_keyword", defaultValue="") String searchKeyword) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("searchType", searchType);
		params.put("searchKeyword", searchKeyword);
		
		int page = nm020835Service.getSearchListCount(params);
		page = page % 10 == 0 ? page / 10 : page / 10 + 1;
		model.addAttribute("page", page);
		
		return "ajax/pagination";
	}
}
