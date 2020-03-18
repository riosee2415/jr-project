package com.patis.NM02.NM020834;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.patis.common.file.I_FileService;
import com.patis.common.tempFile.I_TempFileService;
import com.patis.middleware.I_MiddlewareService;
import com.patis.model.Accept_typeVO;
import com.patis.model.BoardFileVO;
import com.patis.model.BoardTempFileVO;
import com.patis.model.BoardVO;
import com.patis.model.CommonVO;
import com.patis.util.MenuUtil;

/**
 * @author : 4LEAF.NJM
 * @SCREEN : 도시재생교육 -> 도시재생학교(archive)
 *
 */
@Controller
public class Nm020834Controller {
	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;

	@Resource(name="nm020834Service")
	private I_Nm020834Service nm020834Service;
	
	@Resource(name="fileService")
	private I_FileService fileService;
	
	@Resource(name="tempFileService")
	private I_TempFileService tempFileService;
	
	@RequestMapping(value="/archive.do", method=RequestMethod.GET)
	public String sendScreen(Model model,
							 @RequestParam(value="tab", defaultValue="1", required=false)Integer tab,
							 @RequestParam(value="s_type", defaultValue="")String searchType,
						 	 @RequestParam(value="s_keyword", defaultValue="")String searchKeyword) throws Exception{

		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		String b_type_1 = nm020834Service.getYardOfficeBoardType();
		String b_type_2 = nm020834Service.getYardSupportBoardType();
		
		model.addAttribute("b_type_1", b_type_1);
		model.addAttribute("b_type_2", b_type_2);
		
		Accept_typeVO AcceptRight_1 = middlewareService.getAcceptRight(b_type_1);
		Accept_typeVO AcceptRight_2 = middlewareService.getAcceptRight(b_type_2);
		
		model.addAttribute("AcceptRight_1", AcceptRight_1);
		model.addAttribute("AcceptRight_2", AcceptRight_2);
		
		model.addAttribute("tab", tab);
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchKeyword", searchKeyword);
		
		return "archive";
	}
	
	@RequestMapping(value="/archive.detail.do", method=RequestMethod.GET)
	public String sendDetailScreen(Model model, 
								   HttpSession session,
								   @RequestParam(value="parent")String parent,
								   @RequestParam(value="code")String code,
								   @RequestParam(value="tab", defaultValue="1", required=false)Integer tab,
								   @RequestParam(value="b_no")int b_no,
			 					   @RequestParam(value="rownum")int rownum,
			 					   @RequestParam(value="s_type", defaultValue="")String searchType,
			 					   @RequestParam(value="s_keyword", defaultValue="")String searchKeyword,
			 					   RedirectAttributes rttr) throws Exception {

		String btype = null;
		
		switch(tab) {
		case 1:
			btype = nm020834Service.getYardOfficeBoardType();
			break;
		case 2:
			btype = nm020834Service.getYardSupportBoardType();
			break;
		}
		
		Accept_typeVO AcceptRight = middlewareService.getAcceptRight(btype);
		model.addAttribute("AcceptRight", AcceptRight);
		
		if(session.getAttribute("loginRight") != null) {
			if(Integer.parseInt(session.getAttribute("loginRight").toString()) > Integer.parseInt(AcceptRight.getVIEW_RIGHT())) {
				rttr.addAttribute("parent", parent);
				rttr.addAttribute("code", code);
				rttr.addAttribute("tab", tab);
				rttr.addAttribute("s_type", searchType);
				rttr.addAttribute("s_keyword", searchKeyword);
				rttr.addFlashAttribute("msg", "사용자님은 해당 글을 볼 수 있는 권한이 없습니다.");
				return "redirect:/archive.do";
			}
		}
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("BOARD_TYPE", btype);
		params.put("BOARD_NO", b_no);
		
		List<BoardFileVO> fileList = fileService.getAttachFileList(params);
		model.addAttribute("fileList", fileList);
		
		params = new HashMap<String, Object>();
		params.put("rownum", rownum);
		params.put("searchType", searchType);
		params.put("searchKeyword", searchKeyword);
		
		BoardVO data = null;
		BoardVO prevData = null;
		BoardVO nextData = null;
		
		switch(tab) {
		case 1:
			data = nm020834Service.getYardOffice(b_no);
			prevData = nm020834Service.getPrevYardOffice(params);
			nextData = nm020834Service.getNextYardOffice(params);
			break;
		case 2:
			data = nm020834Service.getYardSupport(b_no);
			prevData = nm020834Service.getPrevYardSupport(params);
			nextData = nm020834Service.getNextYardSupport(params);
			break;
		}
		model.addAttribute("data", data);
		model.addAttribute("prevData", prevData);
		model.addAttribute("nextData", nextData);
		
		model.addAttribute("tab", tab);
		model.addAttribute("tabName", MenuUtil.getBoardName(btype));
		model.addAttribute("rownum", rownum);
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchKeyword", searchKeyword);
		
		return "archive.detail";
	}
	
	@ResponseBody
	@RequestMapping(value = "/yard_office.hitUp.do", method = RequestMethod.POST, produces="application/json")
	public Map<String, Object> ajaxYardOfficeHitUp(Model model,
			@RequestParam("b_no")int b_no) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		int result = nm020834Service.modifyYardOfficeHitUp(b_no);
		data.put("result", result);
		
		return data;
	}
	@ResponseBody
	@RequestMapping(value = "/yard_support.hitUp.do", method = RequestMethod.POST, produces="application/json")
	public Map<String, Object> ajaxYardSupportHitUp(Model model,
			@RequestParam("b_no")int b_no) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		int result = nm020834Service.modifyYardSupportHitUp(b_no);
		data.put("result", result);
		
		return data;
	}
	
	@RequestMapping(value="/archive.write.do", method=RequestMethod.GET)
	public String archiveWrite(Model model,
								 HttpSession session,
								 RedirectAttributes rttr,
								 @RequestParam(value="parent")String parent,
							     @RequestParam(value="code")String code,
							     @RequestParam(value="tab")Integer tab,
								 @RequestParam(value="mode", defaultValue="WRITE")String mode,
								 @RequestParam(value="b_no", required=false)Integer b_no,
								 @RequestParam(value="rownum", required=false)Integer rownum,
								 @RequestParam(value="s_type", defaultValue="")String searchType,
		 					     @RequestParam(value="s_keyword", defaultValue="")String searchKeyword) throws Exception{
		
		String b_type = null;
		
		switch(tab) {
		case 1:
			b_type = nm020834Service.getYardOfficeBoardType();
			break;
		case 2:
			b_type = nm020834Service.getYardSupportBoardType();
			break;
		}
		
		Accept_typeVO AcceptRight = middlewareService.getAcceptRight(b_type);
		model.addAttribute("AcceptRight", AcceptRight);
		
		if(session.getAttribute("loginRight") != null) {
			if(Integer.parseInt(session.getAttribute("loginRight").toString()) > Integer.parseInt(AcceptRight.getWRITE_RIGHT())) {
				rttr.addAttribute("parent", parent);
				rttr.addAttribute("code", code);
				rttr.addAttribute("tab", tab);
				rttr.addAttribute("s_type", searchType);
				rttr.addAttribute("s_keyword", searchKeyword);
				rttr.addFlashAttribute("msg", "사용자님은 해당 게시판에 작성할 수 있는 권한이 없습니다.");
				return "redirect:/archive.do";
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
			BoardVO data = null;
			
			switch(tab) {
			case 1:
				data = nm020834Service.getYardOffice(b_no);
				break;
			case 2:
				data = nm020834Service.getYardSupport(b_no);
				break;
			}
			model.addAttribute("data", data);
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("BOARD_TYPE", b_type);
			params.put("BOARD_NO", b_no);
			
			List<BoardFileVO> fileList = fileService.getAttachFileList(params);
			model.addAttribute("fileList", fileList);
		} 
		model.addAttribute("tab", tab);
		model.addAttribute("tabName", MenuUtil.getBoardName(b_type));
		model.addAttribute("mode", mode);
		model.addAttribute("b_type", b_type);
		model.addAttribute("rownum", rownum);
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchKeyword", searchKeyword);
		
		return "archive.write";
	}
	
	@RequestMapping(value="/archive.write.do", method=RequestMethod.POST)
	public String archiveWriteProcess(@RequestParam(value="parent")String parent,
				 						@RequestParam(value="code")String code,
				 						@RequestParam(value="tab")Integer tab,
										@RequestParam(value="mode")String mode,
										@RequestParam(value="b_type")String b_type,
										@RequestParam(value="rownum", required=false)Integer rownum,
										@RequestParam(value="b_no", required=false)Integer b_no,
										@RequestParam(value="b_title")String b_title,
										@RequestParam(value="b_description")String b_description,
										@RequestParam(value="b_author")String b_author,
										@RequestParam(value="b_author_none", required=false)String b_author_none,
										@RequestParam(value="file_key")String file_key,
										@RequestParam(value="remove_file")String removeFile,
										@RequestParam(value="s_type", defaultValue="")String searchType,
				 					    @RequestParam(value="s_keyword", defaultValue="")String searchKeyword,
				 					    @RequestParam("thumbnail_file") MultipartFile multipartFile,
				 					    HttpSession httpSession,
										RedirectAttributes rttr) throws Exception{
		String url = "";
		int boardNo = 0;
	
		String[] tags = b_description.split("<p>");
		b_description = "";
		
		for(String tag : tags) {
			if(tag.contains("</p>")) {
				b_description += "<p>" + tag.substring(0, tag.indexOf("</p>")) + "</p>";
			} 
		}
		
		BoardVO boardVO = new BoardVO();
		boardVO.setB_TYPE(b_type);
		boardVO.setB_TITLE(b_title);
		boardVO.setB_DESCRIPTION(b_description);
		boardVO.setB_AUTHOR(b_author);
		boardVO.setB_AUTHOR_NONE(b_author_none);
		
		if(multipartFile != null && !(multipartFile.getOriginalFilename().equals(""))) { 
			String originalName = multipartFile.getOriginalFilename(); 
			String originalNameExtension = originalName.substring(originalName.lastIndexOf(".") + 1).toLowerCase();
			
			String defaultPath = httpSession.getServletContext().getRealPath("/"); 
			String path = defaultPath + File.separator + "upload" + File.separator + "board" + File.separator + "thumbnails" + File.separator + ""; 
			File file = new File(path); 
			if(!file.exists()) { 
				file.mkdirs(); 
			}
			
			String uploadPath = "/upload/board/thumbnails/";
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss"); 
			String today= formatter.format(new Date()); 
			String modifyName = today + "-" + UUID.randomUUID().toString().substring(20) + "." + originalNameExtension; 
			 try {
				 multipartFile.transferTo(new File(path + modifyName)); 
				 boardVO.setB_THUMB_PATH(uploadPath + modifyName);
				 System.out.println("** upload 정보 **"); 
				 System.out.println("** path : " + path + " **"); 
				 System.out.println("** originalName : " + originalName + " **"); 
				 System.out.println("** modifyName : " + modifyName + " **"); 
			 } catch (Exception e) {
				 e.printStackTrace(); 
				 System.out.println("이미지 파일 업로드 실패"); 
			 }
		} else if (mode.equals("MODIFY")){
			BoardVO temp = null;
			switch(tab) {
			case 1:
				temp = nm020834Service.getYardOffice(b_no);
				break;
			case 2:
				temp = nm020834Service.getYardSupport(b_no);
				break;
			}
			boardVO.setB_THUMB_PATH(temp.getB_THUMB_PATH());
		}
		
		if(mode.equals("WRITE")) {
			switch(tab) {
			case 1:
				nm020834Service.setYardOffice(boardVO);
				break;
			case 2:
				nm020834Service.setYardSupport(boardVO);
				break;
			}
			boardNo = boardVO.getB_NO();
			
			rttr.addAttribute("tab", tab);
			rttr.addFlashAttribute("msg", "게시글이 등록되었습니다.");
			url = "redirect:/archive.do";
		} else {
			boardNo = b_no;
			boardVO.setB_NO(b_no);
			
			switch(tab) {
			case 1:
				nm020834Service.modifyYardOffice(boardVO);
				break;
			case 2:
				nm020834Service.modifyYardSupport(boardVO);
				break;
			}
			if(!removeFile.equals("")) {
				String[] removeFiles = removeFile.split(",");
				for(String fileNo : removeFiles) {
					fileService.removeFile(Integer.parseInt(fileNo));
				}
			}
			rttr.addAttribute("tab", tab);
			rttr.addAttribute("b_no", b_no);
			rttr.addAttribute("rownum", rownum);
			rttr.addAttribute("s_type", searchType);
			rttr.addAttribute("s_keyword", searchKeyword);
			rttr.addFlashAttribute("msg", "게시글이 변경되었습니다.");
			url = "redirect:/archive.detail.do";
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
	
	@RequestMapping(value="/archive.remove.do", method=RequestMethod.POST)
	public String archiveRemoveProcess(@RequestParam(value="parent")String parent,
										 @RequestParam(value="code")String code,
										 @RequestParam(value="tab")Integer tab,
										 @RequestParam(value="b_no")Integer b_no,
										 @RequestParam(value="s_type", defaultValue="")String searchType,
										 @RequestParam(value="s_keyword", defaultValue="")String searchKeyword,
										 RedirectAttributes rttr) throws Exception {
		
		switch(tab) {
		case 1:
			nm020834Service.removeYardOffice(b_no);
			break;
		case 2:
			nm020834Service.removeYardSupport(b_no);
			break;
		}
		rttr.addFlashAttribute("msg", "게시글이 삭제 처리 되었습니다.");
		
		rttr.addAttribute("parent", parent);
		rttr.addAttribute("code", code);
		rttr.addAttribute("tab", tab);
		rttr.addAttribute("s_type", searchType);
		rttr.addAttribute("s_keyword", searchKeyword);
		
		return "redirect:/archive.do";
	}
	
	@RequestMapping(value = "/nm020834Init.do", method = RequestMethod.GET)
	public String ajaxInit(Model model,
						   @RequestParam("tab") int tab,
			               @RequestParam("paging") int paging,
			               @RequestParam(value="search_type", defaultValue="") String searchType,
			               @RequestParam(value="search_keyword", defaultValue="") String searchKeyword) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("paging", Integer.toString((paging-1) * 10));
		params.put("searchType", searchType);
		params.put("searchKeyword", searchKeyword);
		
		List<BoardVO> boardList = null;
		
		switch(tab) {
		case 1:
			boardList = nm020834Service.getYardOfficeSearchList(params);
			break;
		case 2:
			boardList = nm020834Service.getYardSupportSearchList(params);
			break;
		}
		model.addAttribute("boardList", boardList);
		
		return "ajax/nm020834Init";
	}
	
	@RequestMapping(value = "/nm020834Paging.do", method = RequestMethod.GET)
	public String ajaxPaging(Model model,
							 @RequestParam("tab") int tab,
							 @RequestParam(value="search_type", defaultValue="") String searchType,
				             @RequestParam(value="search_keyword", defaultValue="") String searchKeyword) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("searchType", searchType);
		params.put("searchKeyword", searchKeyword);
		
		int page = 0;
		
		switch(tab) {
		case 1:
			page = nm020834Service.getYardOfficeSearchListCount(params);
			break;
		case 2:
			page = nm020834Service.getYardSupportSearchListCount(params);
			break;
		}
		page = page % 10 == 0 ? page / 10 : page / 10 + 1;
		model.addAttribute("page", page);
		
		return "ajax/pagination";
	}
}
