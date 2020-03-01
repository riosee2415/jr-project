package com.patis.main;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.patis.middleware.MiddlewareServiceImpl;
import com.patis.model.CommonVO;

@Controller
public class MainController {
	
	@Resource(name="middlewareService")
	private MiddlewareServiceImpl middlewareService;
	
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public String main() throws Exception {
		List<CommonVO> commonList = middlewareService.selectCommonList();
		return "main";
	}
	
}
