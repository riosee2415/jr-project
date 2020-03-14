package com.patis.admin.AD0203;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.patis.middleware.I_MiddlewareService;
import com.patis.model.Accept_typeVO;
import com.patis.model.BoardVO;
import com.patis.model.CommentsVO;
import com.patis.model.CommonVO;
import com.patis.model.LoginLogVO;

/**
 * @author 4leaf.ysh
 * @SCREEN : 공지사항 게시판 관리자
 *
 */

@Controller
public class Ad0203Controller {

	@Resource(name = "middlewareService")
	private I_MiddlewareService middlewareService;
	
	@Resource(name = "ad0203Service")
	private I_Ad0203Service ad0203Service;
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE : Mar 8, 2020
	 * @RETURN : String
	 * @DESC : 공지사항 게시판 관리자
	 */
	@RequestMapping(value = "/admin.notice.do", method = RequestMethod.GET)
	public String sendScreen(@RequestParam("mc") String mc, @RequestParam("sc") String sc, HttpSession session,
			Model model) {

		boolean flag = false;
		int right = 0;

		if (session.getAttribute("loginRight") == null) {
			try {
				List<CommonVO> menuList = middlewareService.getMenu();
				model.addAttribute("menuList", menuList);
				List<CommonVO> subMenuList = middlewareService.getSubMenu();
				model.addAttribute("subMenuList", subMenuList);
				List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
				model.addAttribute("DetailMenuList", DetailMenuList);
			} catch (Exception e) {
				System.out.println(e);
			}

		} else {
			right = (int) session.getAttribute("loginRight");
		}

		if (right == 1 || right == 2) {
			middlewareService.printLog("관리자 또는 운영자 권한으로 로그인 되었습니다.");
			
			
			
			flag = true;

		}

		if (flag) {
			return "adminNotice";
		} else {
			return "main";

		}

	}
	
	
	@RequestMapping(value = "/ad0203Init.do", method = RequestMethod.GET)
	public String ajaxGetBoardData(Model model,
							@RequestParam("page")int page,
							@RequestParam(value="search_type", defaultValue="") String searchType,
			               @RequestParam(value="search_keyword", defaultValue="") String searchKeyword) {
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("paging", Integer.toString((page-1) * 10));
		params.put("searchType", searchType);
		params.put("searchKeyword", searchKeyword);
	
		List<BoardVO> boardList = ad0203Service.getSearch(params);
		model.addAttribute("boardList", boardList);
	
		
		return "ajax/adBoardInit";
	}
	
	@RequestMapping(value = "/ad0203Pagination.do", method = RequestMethod.GET)
	public String ajaxPagination(Model model,
								 @RequestParam(value="search_type", defaultValue="") String searchType,
					             @RequestParam(value="search_keyword", defaultValue="") String searchKeyword
							) {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("searchType", searchType);
		params.put("searchKeyword", searchKeyword);
		
		int page = ad0203Service.getListCount(params);
		page = page % 10 == 0 ? page / 10 : page / 10 + 1;
		model.addAttribute("page", page);
		
		return "ajax/adPagination";
	}
	
	@RequestMapping(value = "/ad0203Notice.do", method = RequestMethod.GET)
	@ResponseBody
	public int ajaxNotice(Model model,
							@RequestParam("status")int status,
							@RequestParam("no")int no) {
		
		int result = ad0203Service.chagneNoticeStatus(status, no);
		
		return result;
	}
	
	@RequestMapping(value = "/ad0203Delete.do", method = RequestMethod.GET)
	@ResponseBody
	public int ajaxDelete(Model model,
							@RequestParam("no")int no) {
		
		int result = ad0203Service.deleteOne(no);
		
		return result;
	}
	
	@RequestMapping(value = "/ad0203DeleteAll.do", method = RequestMethod.GET)
	@ResponseBody
	public int ajaxDeleteAll(Model model,
							@RequestParam(value = "noArr[]")List<String> noArr) {
		
		int result = 0;
		
		for(int i = 0; i < noArr.size(); i++) {
			result = ad0203Service.deleteOne(Integer.parseInt(noArr.get(i)));
		}
		
		return result;
	}
	
	
//	@RequestMapping(value = "/ad0203Search.do", method = RequestMethod.GET)
//	public String ajaxSearchData(Model model
//							, @RequestParam("serachVal")String serachVal
//							, @RequestParam("searchType")String searchType) {
//		
//		
//		List<BoardVO> boardList = ad0203Service.getSearch(serachVal, searchType);
//		model.addAttribute("boardList", boardList);
//		
//		return "ajax/ad0203Init";
//	}
	
	@RequestMapping(value = "/ad0203Comments.do", method = RequestMethod.GET)
	@ResponseBody
	public List<CommentsVO> getCommentById(@RequestParam("p_no")int p_no){
		
		List<CommentsVO> list = ad0203Service.getCommentsById(p_no);
		
		return list;
	}
	
	@RequestMapping(value = "/ad0203CommentDelete.do", method = RequestMethod.GET)
	@ResponseBody
	public int commentDelete(@RequestParam("co_no")int co_no){
		
		
		return ad0203Service.commentDelete(co_no);
	}
	
	
	@RequestMapping(value = "/ad0203GetRight.do", method = RequestMethod.GET)
	public String getRight(	@RequestParam("type")String type
							,Model model) {
		
		List<CommonVO> list = ad0203Service.getRight();
		model.addAttribute("RightList", list);
		
		return "ajax/adRightInit";
	}
	
	@RequestMapping(value = "/ad0203CurrentRight.do",  method = RequestMethod.GET)
	public String currentRight(Model model) {
		
		Accept_typeVO vo = ad0203Service.currentRight();
		model.addAttribute("current", vo);
		
		return "ajax/adCurrentRight";
	}
	
	@RequestMapping(value = "/ad0203UpdateRight.do",  method = RequestMethod.GET)
	public String UpdateRight(@RequestParam("type")String type,
			@RequestParam("read")String read,
			@RequestParam("write")String write,
			RedirectAttributes ra) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("type", type);
		params.put("read", read);
		params.put("write", write);
		
		int result = ad0203Service.UpdateRight(params);
		
		System.out.println(result);
		System.out.println(result);
		System.out.println(result);
		
		ra.addAttribute("type", type);
		return "redirect:ad0203GetRight.do";
	}

}
