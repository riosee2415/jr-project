package com.patis.admin.AD0215;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.patis.middleware.I_MiddlewareService;
import com.patis.model.BoardVO;
import com.patis.model.CommonVO;
import com.patis.model.LoginLogVO;

/**
 * @author 4leaf.ysh
 * @SCREEN : 로그인기록 관리 페이지(loginInfo.do)
 *
 */

@Controller
public class Ad0215Controller {

	@Resource(name = "middlewareService")
	private I_MiddlewareService middlewareService;
	
	@Resource(name = "ad0215Service")
	private I_Ad0215Service ad0215Service;
	
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE : Mar 8, 2020
	 * @RETURN : String
	 * @DESC : 공모사업신청 관리자 페이지로 이동
	 */
	@RequestMapping(value = "/admin.collusion.do", method = RequestMethod.GET)
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
			
			
			
			int page = ad0215Service.getListCount();
			page = page / 10;
			model.addAttribute("page", page+1);
			
			flag = true;

		}

		if (flag) {
			return "adminCollusion";
		} else {
			return "main";

		}

	}
	
	
	@RequestMapping(value = "/ad0215Init.do", method = RequestMethod.GET)
	public String ajaxGetBoardData(Model model,
							@RequestParam("page")int page) {
		
		
		List<BoardVO> boardList = ad0215Service.getBoardData((page-1)*10);
		model.addAttribute("boardList", boardList);
	
		
		return "ajax/ad0215Init";
	}
	
	@RequestMapping(value = "/ad0215Notice.do", method = RequestMethod.GET)
	@ResponseBody
	public int ajaxNotice(Model model,
							@RequestParam("status")int status,
							@RequestParam("no")int no) {
		
		int result = ad0215Service.chagneNoticeStatus(status, no);
		
		return result;
	}
	

}
