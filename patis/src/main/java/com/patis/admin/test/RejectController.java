package com.patis.admin.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RejectController {

	@RequestMapping(value = "/reject.do", method = RequestMethod.GET)
	public String phoneTest1() {
		
		return "rejectedRight";
	}
}
