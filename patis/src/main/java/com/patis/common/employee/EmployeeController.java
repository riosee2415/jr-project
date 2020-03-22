package com.patis.common.employee;

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

import com.patis.middleware.I_MiddlewareService;
import com.patis.model.CommonVO;
import com.patis.model.EmpVO;

@Controller
public class EmployeeController {

	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;
	
	@Resource(name = "employeeService")
	private I_EmployeeService employeeService;
	
	@RequestMapping(value="/join-step-1.do", method=RequestMethod.GET)
	public String join(Model model) throws Exception {
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		return "join-step-1";
	}
	
	
	@RequestMapping(value="/join-step-2.do", method=RequestMethod.POST)
	public String joinStart(Model model) throws Exception {
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		return "join-step-2";
	}
	
	
	@RequestMapping(value="/join-step-3.do", method=RequestMethod.POST)
	public String agree(Model model) throws Exception {
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		return "join-step-3";
	}
	
	@RequestMapping(value="/phonePop.do", method=RequestMethod.GET)
	public String phonePop(Model model) throws Exception {
		
		
		return "phonePop";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login(Model model) throws Exception {
		
		
		return "login";
	}
	
	
	@RequestMapping(value="/idDupleCheckAjax.do", method=RequestMethod.POST)
	@ResponseBody
	public String idDupleCheckAjax(@RequestParam("joinId")String joinId ,Model model) throws Exception {
			
		int result = employeeService.dupleCheckId(joinId);
		
		return result + "";
	}
	
	@RequestMapping(value="/joinUs.do", method=RequestMethod.POST)
	public String joinUs(	@RequestParam("joinId")String joinId 
						,	@RequestParam("joinName")String joinName 
						,	@RequestParam("joinPassword")String joinPassword 
						,	@RequestParam("joinZonecode")String joinZonecode 
						,	@RequestParam("joinAddr1")String joinAddr1 
						,	@RequestParam("joinAddr2")String joinAddr2 
						,	@RequestParam("joinEmail")String joinEmail 
						,	@RequestParam("joinMobile")String joinMobile 
						,	@RequestParam("joinTel")String joinTel 
						,	Model model) throws Exception {
			
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("joinId", joinId);
		params.put("joinName", joinName);
		params.put("joinPassword", joinPassword);
		params.put("joinZonecode", joinZonecode);
		params.put("joinAddr1", joinAddr1);
		params.put("joinAddr2", joinAddr2);
		params.put("joinEmail", joinEmail);
		params.put("joinMobile", joinMobile);
		params.put("joinTel", joinTel);
		
		int result = employeeService.joinUs(params);
		
		return "redirect:/main.do";
	}
	
	
	@RequestMapping(value="/findId.do", method=RequestMethod.GET)
	public String findId(Model model) throws Exception {
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		return "findId";
	}
	
	@RequestMapping(value="/findPass.do", method=RequestMethod.GET)
	public String findPass(Model model) throws Exception {
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		return "findPass";
	}
	
	
	@RequestMapping(value="/mainLogin.do", method=RequestMethod.POST)
	public String mainLogin(@RequestParam("loginId")String loginId ,
							@RequestParam("loginPass")String loginPass ,
							Model model ,
							HttpSession session) throws Exception {
		
		
		// loginTry 가져와서 3보다 크면 에러 발생
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("input_id", loginId);
		params.put("input_password", loginPass);
		
		EmpVO vo = employeeService.mainLogin(params);
		
		if(vo == null) {
			System.out.println("아이디 또는 비밀번호가 맞지 않습니다.");
			model.addAttribute("loginMsg", "2");
			
			// 해당아이디 로그인트라이 1 증가
			
			return "redirect:/login.do";
			
		}
		
		
		if(vo.getUSER_LOGIN_TRY() > 3) {
			System.out.println("LOGIN 시도 3회 이상 실패");
			model.addAttribute("loginMsg", "1");
			return "redirect:/login.do";
		} else {
			// 로그인 성공
			System.out.println(params.get("input_id"));
			
			int loginTry = employeeService.LOGIN_TRY_TO_ZERO(params.get("input_id"));
			System.out.println(loginTry);
			System.out.println(loginTry);
			System.out.println(loginTry);
			
			
			if(loginTry == 1) {
				session.setMaxInactiveInterval(1800);
				session.setAttribute("loginNo", vo.getUSER_NO());
				session.setAttribute("loginId", vo.getUSER_ID());
				session.setAttribute("loginName", vo.getUSER_NAME());
				session.setAttribute("loginRight", vo.getUSER_RIGHT());
			} else {
				
				System.out.println("로그인 성공하였으나 LOGIN TRY 에러 발생");
				session.setMaxInactiveInterval(1800);
				session.setAttribute("loginNo", vo.getUSER_NO());
				session.setAttribute("loginId", vo.getUSER_ID());
				session.setAttribute("loginName", vo.getUSER_NAME());
				session.setAttribute("loginRight", vo.getUSER_RIGHT());
			}
		}
				
		
		return "redirect:/main.do";
	}
	
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logout(Model model, HttpSession session) throws Exception {
		
		session.invalidate();
		System.out.println("새샌 초기화 : 로그아웃");
		
		return "redirect:/main.do";
	}
	
	
	@RequestMapping(value="/myPage.do", method=RequestMethod.GET)
	public String myPage(Model model, HttpSession session) throws Exception {
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		EmpVO vo = employeeService.getUserInfoByMypage((String) session.getAttribute("loginId"));
		
		if(vo == null) {
			return "login";
		}
		
		
		model.addAttribute("user", vo);
		
		return "myPage";
	}
	
	
	
	@RequestMapping(value="/saveInfoInMypage.do", method=RequestMethod.GET)
	public String saveInfoInMypage(	  @RequestParam("id")		String id
									, @RequestParam("email")	String email
									, @RequestParam("tel")		String tel
									, @RequestParam("mobile")	String mobile
									, @RequestParam("zoneCode")	String zoneCode
									, @RequestParam("addr1")	String addr1
									, @RequestParam("addr2")	String addr2
									, Model model
									, HttpSession session) throws Exception {
		

		Map<String, String> params = new HashMap<String, String>();
		
		params.put("id", id);
		params.put("email", email);
		params.put("tel", tel);
		params.put("mobile", mobile);
		params.put("zoneCode", zoneCode);
		params.put("addr1", addr1);
		params.put("addr2", addr2);
		
		int result = employeeService.updateUserInfoMyPage(params);
		
		return "myPage";
	}
	
	@RequestMapping(value="/resultId.do", method=RequestMethod.POST)
	public String resultId(	  @RequestParam("find-name")	String findName
							, @RequestParam("find-reg")		String findReg
							, @RequestParam("find-mobile")	String findMobile
							, Model model, HttpSession session) throws Exception {
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("userName", findName);
		params.put("userReg", findReg);
		params.put("userMobile", findMobile);
		
		String findId = employeeService.findIdType1(params);
		model.addAttribute("findId", findId);
		
		return "resultId";
	}
	
	@RequestMapping(value="/resultPass.do", method=RequestMethod.GET)
	public String resultPass(Model model, HttpSession session) throws Exception {
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		return "resultPass";
	}
}
