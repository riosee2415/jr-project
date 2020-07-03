package com.patis.common.employee;

import java.net.InetAddress;
import java.net.UnknownHostException;
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

import com.patis.admin.AD01.I_Ad010001Service;
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
	public String joinStart(Model model,
							HttpSession session,
							@RequestParam("AUTH_NAME") String AUTH_NAME,
							@RequestParam("AUTH_BIRTHDAY") String AUTH_BIRTHDAY,
							@RequestParam("AUTH_GENDER") String AUTH_GENDER,
							@RequestParam("AUTH_TELNO") String AUTH_TELNO) throws Exception {
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		session.setAttribute("AUTH_NAME", AUTH_NAME);
		session.setAttribute("AUTH_BIRTHDAY", AUTH_BIRTHDAY);
		session.setAttribute("AUTH_GENDER", AUTH_GENDER);
		session.setAttribute("AUTH_TELNO", AUTH_TELNO);
		
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
	
	@RequestMapping(value="/phonePop2.do", method=RequestMethod.POST)
	public String phonePop2(Model model,
							 @RequestParam("CP_CD")String CP_CD
							,@RequestParam("SITE_NAME")String SITE_NAME) throws Exception {
		
		model.addAttribute("CP_CD", CP_CD);
		model.addAttribute("SITE_NAME", SITE_NAME);
		
		return "phonePop2";
	}
	
	@RequestMapping(value="/phonePop3.do")
	public String phonePop3(Model model,
							@RequestParam("mdl_tkn")String mdl_tkn) throws Exception {
		
		
		model.addAttribute("mdl_tkn", mdl_tkn);
		
		return "phonePop3";
	}
	
	@RequestMapping(value="/phonePop4.do")
	public String phonePop4(Model model
							) throws Exception {
		
		return "phonePop4";
	}
	
	
	
	
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login(Model model) throws Exception {

		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		
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
						,	@RequestParam("joinRegno1")String joinRegno1 
						,	@RequestParam("joinGender")String joinGender 
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
		params.put("joinRegno1", joinRegno1);
		params.put("joinGender", joinGender);
		
		int result = employeeService.joinUs(params);
		
		return "redirect:/main.do";
	}
	
	
	@RequestMapping(value="/findId.do", method=RequestMethod.GET)
	public String findId(@RequestParam(value = "errorCode", defaultValue = "0")String errorCode , Model model) throws Exception {
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		model.addAttribute("errorCode", errorCode);
		
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
	
	@RequestMapping(value="findPass.do", method=RequestMethod.POST)
	public String findPwProcess(  Model model
								, RedirectAttributes rttr
								, @RequestParam("id") String userId
								, @RequestParam("birth") String userReg
								, @RequestParam("email") String userEmail) throws Exception {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", userId);
		params.put("userReg", userReg);
		params.put("userEmail", userEmail);
		
		String empId = employeeService.findPwType1(params);
		
		String url = "";
		if(empId == null) {
			model.addAttribute("errorCode", "1");
			url = "findPass";
		} else {
			url = "redirect:/confirmPass.do";
			
			rttr.addAttribute("id", empId);
		}
		return url;
	}
	
	
	@RequestMapping(value="/mainLogin.do", method=RequestMethod.POST)
	public String mainLogin(@RequestParam("loginId")String loginId ,
							@RequestParam("loginPass")String loginPass ,
							InetAddress ip ,
							Model model ,
							HttpSession session) throws Exception {
		
		String ipAddress = "";
		int id_check_result = 0;
		
		try {
			ip = InetAddress.getLocalHost(); 
			ipAddress = ip.getHostAddress();
		} catch(UnknownHostException e) {
			System.out.println(e);
		}
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("input_id", loginId);
		params.put("input_password", loginPass);
		
		EmpVO vo = employeeService.mainLogin(params);
	
		if(vo == null) {
			try {
				int loginCnt = employeeService.getOnlyLogTryById(loginId);
				
				loginCnt++;
				Map<String, Object> params2 = new HashMap<String, Object>();
				params2.put("input_id", loginId);
				params2.put("addTry", loginCnt);
				
				int updateResult = employeeService.addLoginTry(params2);
			}catch(Error e) {
				System.out.println(e);
				
			}
			
			System.out.println("아이디 또는 비밀번호가 맞지 않습니다.");
			model.addAttribute("loginMsg", "2");
			
			
			return "redirect:/login.do";
			
		}
		
		
		if(vo.getUSER_LOGIN_TRY() > 3) {
			System.out.println("LOGIN 시도 3회 이상 실패");
			model.addAttribute("loginMsg", "1");
			return "redirect:/login.do";
		} else {
			// 로그인 성공
			
			int loginTry = employeeService.LOGIN_TRY_TO_ZERO(params.get("input_id"));
			
			if(loginTry == 1) {
				
				Map<String, String> info = new HashMap<String, String>();
				info.put("input_id", loginId);
				info.put("input_ip", ipAddress);
				
				try {
					id_check_result = employeeService.addLoginLog(info);
				} catch(Error e) {
					middlewareService.printLog("로그인 시도 아이디 데이터베이스 검증 실패");
				}
				
				
				session.setMaxInactiveInterval(1800);
				session.setAttribute("loginNo", vo.getUSER_NO());
				session.setAttribute("loginId", vo.getUSER_ID());
				session.setAttribute("loginName", vo.getUSER_NAME());
				session.setAttribute("loginRight", vo.getUSER_RIGHT());
			} else {
				Map<String, String> info = new HashMap<String, String>();
				info.put("input_id", loginId);
				info.put("input_ip", ipAddress);
				
				try {
					id_check_result = employeeService.addLoginLog(info);
				} catch(Error e) {
					middlewareService.printLog("로그인 시도 아이디 데이터베이스 검증 실패");
				}
				
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
							, Model model
							, HttpSession session
							, RedirectAttributes ra) throws Exception {
		
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
		
		if(findId == null) {
			ra.addAttribute("errorCode", "1");
			return "redirect:/findId.do";
		}
		
		int len = findId.length();
		len = len - 3;
		
		findId = findId.substring(0, len);
		findId += "***";
		
		model.addAttribute("findId", findId);
		return "resultId";
	}
	
	@RequestMapping(value="/resultId2.do", method=RequestMethod.POST)
	public String resultId2(  @RequestParam("find2-name")	String findName
							, @RequestParam("find2-email")	String findEmail
							, Model model
							, HttpSession session
							, RedirectAttributes ra) throws Exception {
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("userName", findName);
		params.put("userEmail", findEmail);
		
		String findId = employeeService.findIdType2(params);
		
		if(findId == null) {
			ra.addAttribute("errorCode", "1");
			return "redirect:/findId.do";
		}
		
		int len = findId.length();
		len = len - 3;
		
		findId = findId.substring(0, len);
		findId += "***";
		
		model.addAttribute("findId", findId);
		return "resultId";
	}
	
	
	
	@RequestMapping(value="/resultPass.do", method=RequestMethod.GET)
	public String resultPass(   Model model
						      , HttpSession session
						      , @RequestParam("id") String userId) throws Exception {
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		model.addAttribute("userId", userId);
		
		return "resultPass";
	}
	
	@RequestMapping(value="resultPass.do", method=RequestMethod.POST)
	public String resultPwProcess(   Model model
								   , RedirectAttributes rttr
								   , @RequestParam("userId") String userId
								   , @RequestParam("userPw") String userPw) throws Exception {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", userId);
		params.put("userPw", userPw);
		
		employeeService.modifyUserPassword(params);
		
		rttr.addFlashAttribute("msg", "비밀번호 변경이 완료되었습니다.");
		
		return "redirect:/login.do";
	}
	
	@RequestMapping(value="/confirmPass.do", method=RequestMethod.GET)
	public String confirmPass(   Model model
							   , HttpSession session
							   , @RequestParam("id") String userId) throws Exception {
		
		List<CommonVO> menuList = middlewareService.getMenu();
		model.addAttribute("menuList", menuList);
		List<CommonVO> subMenuList = middlewareService.getSubMenu();
		model.addAttribute("subMenuList", subMenuList);
		List<CommonVO> DetailMenuList = middlewareService.getDetailMenu();
		model.addAttribute("DetailMenuList", DetailMenuList);
		
		model.addAttribute("userId", userId);
		
		return "confirmPass";
	}
	
	@RequestMapping(value="confirmPass.do", method=RequestMethod.POST)
	public String confirmPwProcess(   Model model
									, RedirectAttributes rttr
									, @RequestParam("userId") String userId
									, @RequestParam("emailKey") String emailKey) throws Exception {
		EmpVO empVO = employeeService.getUserInfo(userId);
		
		String url = "";
		if(empVO.getUSER_EMAIL_KEY().equals(emailKey)) {
			url = "redirect:/resultPass.do";
			
			rttr.addAttribute("id", userId);
		} else {
			url = "confirmPass";
			
			model.addAttribute("errorCode", "1");
			model.addAttribute("userId", userId);
		}
		
		return url;
	}
}
