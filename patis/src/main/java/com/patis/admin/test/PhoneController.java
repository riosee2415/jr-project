package com.patis.admin.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PhoneController {

	@RequestMapping(value = "/phone1.do", method = RequestMethod.GET)
	public String phoneTest1() {
		
		return "phone1";
	}
	
	@RequestMapping(value = "/phone2.do", method = RequestMethod.GET)
	public String phoneTest2() {
		
		return "phone2";
	}
	
	
	@RequestMapping(value = "/phone3.do", method = RequestMethod.GET)
	public String phoneTest3() {
		
		return "phone3";
	}
	
	
	@RequestMapping(value = "/phone4.do", method = RequestMethod.GET)
	public String phoneTest4() {
		
		return "phone4";
	}
	
	
}
