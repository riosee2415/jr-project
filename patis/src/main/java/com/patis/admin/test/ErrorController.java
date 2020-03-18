package com.patis.admin.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {

	
	@RequestMapping(value = "/404err.do", method = RequestMethod.GET)
	public String err404Test() {
		
		return "404err";
	}
	
	@RequestMapping(value = "/500err.do", method = RequestMethod.GET)
	public String err500Test() {
		
		return "500err";
	}
}
