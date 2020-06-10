package com.patis.NM02.NM020524;

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
 * @SCREEN : 주민 참여 ->  마을 커뮤니티(community)
 *
 */
@Controller
public class Nm020524Controller {
	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;

	@Resource(name="nm020524Service")
	private I_Nm020524Service nm020524Service;
	
	@Resource(name="fileService")
	private I_FileService fileService;
	
	@Resource(name="tempFileService")
	private I_TempFileService tempFileService;
	
	@RequestMapping(value="/community.do", method=RequestMethod.GET)
	public String sendScreen(Model model,
							 @RequestParam(value="s_type", defaultValue="")String searchType,
						 	 @RequestParam(value="s_keyword", defaultValue="")String searchKeyword) throws Exception{
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		String b_type = nm020524Service.getBoardType();
		model.addAttribute("b_type", b_type);
		
		Accept_typeVO AcceptRight = middlewareService.getAcceptRight(b_type);
		model.addAttribute("AcceptRight", AcceptRight);
		
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchKeyword", searchKeyword);
		
		return "community";
	}
	
	@RequestMapping(value="/community.detail.do", method=RequestMethod.GET)
	public String sendDetailScreen(Model model, 
								   HttpSession session,
								   @RequestParam(value="parent")String parent,
								   @RequestParam(value="code")String code,
			 					   @RequestParam(value="b_no")int b_no,
			 					   @RequestParam(value="rownum")int rownum,
			 					   @RequestParam(value="s_type", defaultValue="")String searchType,
			 					   @RequestParam(value="s_keyword", defaultValue="")String searchKeyword,
			 					   RedirectAttributes rttr) throws Exception {
		
		String btype = nm020524Service.getBoardType();
		
		Accept_typeVO AcceptRight = middlewareService.getAcceptRight(btype);
		model.addAttribute("AcceptRight", AcceptRight);
		
		if(session.getAttribute("loginRight") != null) {
			if(Integer.parseInt(session.getAttribute("loginRight").toString()) > Integer.parseInt(AcceptRight.getVIEW_RIGHT())) {
				rttr.addAttribute("parent", parent);
				rttr.addAttribute("code", code);
				rttr.addAttribute("s_type", searchType);
				rttr.addAttribute("s_keyword", searchKeyword);
				rttr.addFlashAttribute("msg", "사용자님은 해당 글을 볼 수 있는 권한이 없습니다.");
				return "redirect:/community.do";
			}
		}
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		BoardVO data = nm020524Service.getCommunity(b_no);
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
		
		BoardVO prevData = nm020524Service.getPrevCommunity(params);
		BoardVO nextData = nm020524Service.getNextCommunity(params);
		
		model.addAttribute("prevData", prevData);
		model.addAttribute("nextData", nextData);
		
		model.addAttribute("rownum", rownum);
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchKeyword", searchKeyword);
		
		return "community.detail";
	}
	
	@ResponseBody
	@RequestMapping(value = "/community.hitUp.do", method = RequestMethod.POST, produces="application/json")
	public Map<String, Object> ajaxHitUp(Model model,
						 @RequestParam("b_no")int b_no) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		int result = nm020524Service.modifyHitUp(b_no);
		data.put("result", result);
		
		return data;
	}
	
	@RequestMapping(value="/community.write.do", method=RequestMethod.GET)
	public String communityWrite(Model model,
								 HttpSession session,
								 RedirectAttributes rttr,
								 @RequestParam(value="parent")String parent,
							     @RequestParam(value="code")String code,
								 @RequestParam(value="mode", defaultValue="WRITE")String mode,
								 @RequestParam(value="b_no", required=false)Integer b_no,
								 @RequestParam(value="rownum", required=false)Integer rownum,
								 @RequestParam(value="s_type", defaultValue="")String searchType,
		 					     @RequestParam(value="s_keyword", defaultValue="")String searchKeyword) throws Exception{
		
		String b_type = nm020524Service.getBoardType();
		
		Accept_typeVO AcceptRight = middlewareService.getAcceptRight(b_type);
		model.addAttribute("AcceptRight", AcceptRight);
		
		if(session.getAttribute("loginRight") != null) {
			if(Integer.parseInt(session.getAttribute("loginRight").toString()) > Integer.parseInt(AcceptRight.getWRITE_RIGHT())) {
				rttr.addAttribute("parent", parent);
				rttr.addAttribute("code", code);
				rttr.addAttribute("s_type", searchType);
				rttr.addAttribute("s_keyword", searchKeyword);
				rttr.addFlashAttribute("msg", "사용자님은 해당 게시판에 작성할 수 있는 권한이 없습니다.");
				return "redirect:/community.do";
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
			BoardVO data = nm020524Service.getCommunity(b_no);
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
		
		return "community.write";
	}
	
	@RequestMapping(value="/community.write.do", method=RequestMethod.POST)
	public String communityWriteProcess(@RequestParam(value="parent")String parent,
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
	
		int idx = b_description.indexOf(",");
		if(idx == 0)
			b_description = b_description.substring(1, b_description.length());
		
		BoardVO boardVO = new BoardVO();
		boardVO.setB_TYPE(b_type);
		boardVO.setB_TITLE(b_title);
		boardVO.setB_DESCRIPTION(b_description);
		boardVO.setB_AUTHOR(b_author);
		boardVO.setB_AUTHOR_NONE(b_author_none);
		
		if(mode.equals("WRITE")) {
			nm020524Service.setCommunity(boardVO);
			boardNo = boardVO.getB_NO();
			
			rttr.addFlashAttribute("msg", "게시글이 등록되었습니다.");
			url = "redirect:/community.do";
		} else {
			boardNo = b_no;
			boardVO.setB_NO(b_no);
			nm020524Service.modifyCommunity(boardVO);
			
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
			url = "redirect:/community.detail.do";
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
	
	@RequestMapping(value="/community.remove.do", method=RequestMethod.POST)
	public String communityRemoveProcess(@RequestParam(value="parent")String parent,
										 @RequestParam(value="code")String code,
										 @RequestParam(value="b_no")Integer b_no,
										 @RequestParam(value="s_type", defaultValue="")String searchType,
										 @RequestParam(value="s_keyword", defaultValue="")String searchKeyword,
										 RedirectAttributes rttr) throws Exception {
		
		nm020524Service.removeCommunity(b_no);
		
		rttr.addFlashAttribute("msg", "게시글이 삭제 처리 되었습니다.");
		
		rttr.addAttribute("parent", parent);
		rttr.addAttribute("code", code);
		rttr.addAttribute("s_type", searchType);
		rttr.addAttribute("s_keyword", searchKeyword);
		
		return "redirect:/community.do";
	}
	
	@RequestMapping(value="/community.reply.do", method=RequestMethod.GET)
	public String communityReply(Model model, 
								   HttpSession session,
								   @RequestParam(value="parent")String parent,
								   @RequestParam(value="code")String code,
			 					   @RequestParam(value="b_no")int b_no,
			 					   @RequestParam(value="s_type", defaultValue="")String searchType,
			 					   @RequestParam(value="s_keyword", defaultValue="")String searchKeyword,
			 					   RedirectAttributes rttr) throws Exception {
		
		String btype = nm020524Service.getBoardType();
		
		Accept_typeVO AcceptRight = middlewareService.getAcceptRight(btype);
		model.addAttribute("AcceptRight", AcceptRight);
		
		if(session.getAttribute("loginRight") != null) {
			if(Integer.parseInt(session.getAttribute("loginRight").toString()) > Integer.parseInt(AcceptRight.getVIEW_RIGHT())) {
				rttr.addAttribute("parent", parent);
				rttr.addAttribute("code", code);
				rttr.addAttribute("s_type", searchType);
				rttr.addAttribute("s_keyword", searchKeyword);
				rttr.addFlashAttribute("msg", "사용자님은 해당 답변을 볼 수 있는 권한이 없습니다.");
				return "redirect:/community.do";
			}
		}
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		BoardVO data = nm020524Service.getCommunity(b_no);
		model.addAttribute("data", data);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("BOARD_TYPE", btype);
		params.put("BOARD_NO", b_no);
		
		List<BoardFileVO> fileList = fileService.getAttachFileList(params);
		model.addAttribute("fileList", fileList);
		
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchKeyword", searchKeyword);
		
		return "community.reply";
	}
	
	@ResponseBody
	@RequestMapping(value = "/community.replyHitUp.do", method = RequestMethod.POST, produces="application/json")
	public Map<String, Object> ajaxReplyHitUp(Model model,
						 @RequestParam("b_no")int b_no) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		int result = nm020524Service.modifyReplyHitUp(b_no);
		data.put("result", result);
		
		return data;
	}
	
	@RequestMapping(value="/community.reply.write.do", method=RequestMethod.POST)
	public String communityReplyWriteProcess(@RequestParam(value="parent")String parent,
				 						@RequestParam(value="code")String code,
										@RequestParam(value="mode")String mode,
										@RequestParam(value="b_no", required=false)Integer b_no,
										@RequestParam(value="b_reply")String b_reply,
										@RequestParam(value="b_reply_state")String b_reply_state,
										@RequestParam(value="b_reply_author")String b_reply_author,
										@RequestParam(value="s_type", defaultValue="", required=false)String searchType,
				 					    @RequestParam(value="s_keyword", defaultValue="", required=false)String searchKeyword,
										RedirectAttributes rttr) throws Exception{
		String url = "";

		BoardVO boardVO = new BoardVO();
		boardVO.setB_NO(b_no);
		boardVO.setB_REPLY(b_reply);
		boardVO.setB_REPLY_STATE(b_reply_state);
		boardVO.setB_REPLY_AUTHOR(b_reply_author);
		System.out.println(boardVO);
		if(mode.equals("WRITE")) {
			nm020524Service.setCommunityReply(boardVO);
			
			rttr.addAttribute("s_type", searchType);
			rttr.addAttribute("s_keyword", searchKeyword);
			rttr.addFlashAttribute("msg", "답변이 등록되었습니다.");
			url = "redirect:/community.do";
		} else {
			nm020524Service.modifyCommunityReply(boardVO);
			
			rttr.addAttribute("s_type", searchType);
			rttr.addAttribute("s_keyword", searchKeyword);
			rttr.addFlashAttribute("msg", "게시글이 변경되었습니다.");
			url = "redirect:/community.do";
		}
		rttr.addAttribute("parent", parent);
		rttr.addAttribute("code", code);
		
		return url;
	}
	
	@RequestMapping(value="/community.reply.remove.do", method=RequestMethod.POST)
	public String communityReplyRemoveProcess(@RequestParam(value="parent")String parent,
										 @RequestParam(value="code")String code,
										 @RequestParam(value="b_no")Integer b_no,
										 @RequestParam(value="s_type", defaultValue="")String searchType,
										 @RequestParam(value="s_keyword", defaultValue="")String searchKeyword,
										 RedirectAttributes rttr) throws Exception {
		
		nm020524Service.removeCommunityReply(b_no);
		
		rttr.addFlashAttribute("msg", "답변 글이 삭제 처리 되었습니다.");
		
		rttr.addAttribute("parent", parent);
		rttr.addAttribute("code", code);
		rttr.addAttribute("s_type", searchType);
		rttr.addAttribute("s_keyword", searchKeyword);
		
		return "redirect:/community.do";
	}
	
	@RequestMapping(value = "/nm020524Init.do", method = RequestMethod.GET)
	public String ajaxInit(Model model,
			               @RequestParam("paging") int paging,
			               @RequestParam(value="search_type", defaultValue="") String searchType,
			               @RequestParam(value="search_keyword", defaultValue="") String searchKeyword) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("paging", Integer.toString((paging-1) * 10));
		params.put("searchType", searchType);
		params.put("searchKeyword", searchKeyword);
		
		List<BoardVO> communityList = nm020524Service.getCommunitySearchList(params);
		model.addAttribute("boardList", communityList);
		
		return "ajax/nm020524Init";
	}
	
	@RequestMapping(value = "/nm020524Paging.do", method = RequestMethod.GET)
	public String ajaxPaging(Model model,  
							 @RequestParam(value="search_type", defaultValue="") String searchType,
				             @RequestParam(value="search_keyword", defaultValue="") String searchKeyword) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("searchType", searchType);
		params.put("searchKeyword", searchKeyword);
		
		int page = nm020524Service.getSearchListCount(params);
		page = page % 10 == 0 ? page / 10 : page / 10 + 1;
		model.addAttribute("page", page);
		
		return "ajax/pagination";
	}
}
