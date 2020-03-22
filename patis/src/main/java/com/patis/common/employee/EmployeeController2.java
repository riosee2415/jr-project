package com.patis.common.employee;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.patis.middleware.I_MiddlewareService;

@Controller
public class EmployeeController2 {

	@Resource(name="middlewareService")
	private I_MiddlewareService middlewareService;
	
	@Resource(name = "employeeService")
	private I_EmployeeService employeeService;
	
	@RequestMapping(value="findPass.do", method=RequestMethod.POST)
	public String findPwProcess(  Model model
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
			
			employeeService.modifyEmailKey(empId);
			model.addAttribute("userId", empId);
		}
		return url;
	}
}
