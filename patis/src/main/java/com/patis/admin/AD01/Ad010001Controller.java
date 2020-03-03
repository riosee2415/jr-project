package com.patis.admin.AD01;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.patis.model.CommonVO;

/**
 * @author : 4LEAF.YSH
 * @SCREEN : 관리자페이지 메인 (admin.do)
 *
 */
@Controller
public class Ad010001Controller {
	
	@RequestMapping(value="/admin.do", method=RequestMethod.GET)
	public String sendScreen(Model model) throws Exception{
		

		return "admin";
	}

}
