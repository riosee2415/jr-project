package com.patis.admin.AD01;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.net.URLCodec;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.patis.middleware.I_MiddlewareService;
import com.patis.model.EmpVO;
import com.patis.util.AES256Util;



/**
 * @author : 4LEAF.YSH
 * @SCREEN : 관리자페이지 메인 (admin.do)
 *
 */
@Controller
public class Ad010001Controller {
	
	
	@Resource(name = "ad010001Service")
	private I_Ad010001Service ad010001Service;
	
	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;

	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : Mar 4, 2020
	 * @RETURN : String
	 * @DESC   : 관리자 로그인 페이지로 이동 (로그인 권한 검증)
	 */
	@RequestMapping(value = "/admin.do", method = RequestMethod.GET)
	public String sendScreen(Model model, HttpSession session, @RequestParam(required = false)boolean loginFlag) throws Exception {
		
		boolean flag = false;
		int right = 0;
		
		if(loginFlag) {
			right = Integer.parseInt((String) session.getAttribute("loginRight"));
			
			if(right == 1 || right == 2 || right == 3) {
				middlewareService.printLog("관리자 또는 운영자 권한으로 로그인 되었습니다.");
				flag = true;
				
			} else {
				session.invalidate();
				model.addAttribute("errorCode", "1");
				
			}
		} else { 
			
		}
		

		if (flag) {
			return "admin";
		} else {
			return "/adminLogin";

		}

	}
	
	/**
	 * @AUTHOR : 4LEAF.YSH
	 * @DATE   : Mar 4, 2020
	 * @RETURN : String
	 * @DESC   : 관리자 로그인 시도 
	 */
	@RequestMapping(value = "/admin.do", method = RequestMethod.POST)
	public String adminLogin(Model model
							, @RequestParam("id")String id
							, @RequestParam("pass")String password
							, InetAddress ip
							, HttpSession session) throws Exception {
		
		int id_check_result = 0;
		int pass_check_result = 0;
		int log_save_result = 0;
		String ipAddress = "";
		boolean loginFlag = false;
		
		try {
			ip = InetAddress.getLocalHost(); 
			ipAddress = ip.getHostAddress(); 
		} catch(UnknownHostException e) {
			System.out.println(e);
		}
		
		Map<String, String> info = new HashMap<String, String>();
		info.put("input_id", id);
		info.put("input_password", password);
		info.put("input_ip", ipAddress);
		
		try {
			id_check_result = ad010001Service.adminLoginCheck(info);
		} catch(Error e) {
			middlewareService.printLog("로그인 시도 아이디 데이터베이스 검증 실패");
		}
		
		if(id_check_result == 1) {
			middlewareService.printLog("로그인 시도 아이디 : " + id);
			try  {
				pass_check_result = ad010001Service.adminLoginCheck2(info);
			} catch(Error e) {
				middlewareService.printLog("로그인 시도 비밀번호 데이터베이스 검증 실패");
			}
			
			if(id_check_result == 1 && pass_check_result == 1) {
				middlewareService.printLog(id + "로그인에 성공했습니다. [ " + ipAddress + " ] " );
				
				try {
					log_save_result = ad010001Service.saveLoginData(info);
					
					if(log_save_result == 1) {
						middlewareService.printLog(id + "로그인 기록 저장 성공 [ " + ipAddress + " ] " );
						
						//새션에 로그인 데이터 추가하기
						EmpVO vo  = ad010001Service.getEmpInfo(info);
						
						session.setMaxInactiveInterval(1800);
						session.setAttribute("loginNo", vo.getUSER_NO());
						session.setAttribute("loginId", vo.getUSER_ID());
						session.setAttribute("loginName", vo.getUSER_NAME());
						session.setAttribute("loginRight", vo.getUSER_RIGHT());
						loginFlag = true;
					} else {
						middlewareService.printLog(id + "로그인 기록 저장 실패 [ " + ipAddress + " ] " );
					}
				
				
				} catch(Error e) {
					middlewareService.printLog("로그인 기록 저장 중 에러발생");
				}
			} else {
				model.addAttribute("loginCodePass", 0);
			}
			
		} else {
			model.addAttribute("loginCode", 0);
		}

		return sendScreen(model, session, loginFlag);
	}

}
