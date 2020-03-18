package com.patis.admin.AD0302;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.patis.middleware.I_MiddlewareService;
import com.patis.model.CommonVO;
import com.patis.model.PopupVO;

@Controller
public class Ad0302Controller {
	

	@Resource(name = "middlewareService")
	private I_MiddlewareService middlewareService;
	
	@Resource(name = "ad0302Service")
	private I_Ad0302Service ad0302Service;
	
	
	@RequestMapping(value = "/popupManager.do", method = RequestMethod.GET)
	public String sendScreen( HttpSession session,
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
			right = Integer.parseInt((String) session.getAttribute("loginRight"));
		}

		if (right == 1 || right == 2) {
			middlewareService.printLog("관리자 권한으로 로그인 되었습니다.");
			
			
			
			flag = true;

		}

		if (flag) {
			return "popupManager";
		} else {
			return "main";

		}
		
	}
	
	@RequestMapping(value = "/getPopupList.do", method = RequestMethod.GET)
	public String getPopupList(Model model) {
			
		List<PopupVO> list = ad0302Service.getPopupList();
		
		model.addAttribute("list", list);
		
		return "ajax/popupList";
	}
	
	
	@RequestMapping(value = "/popupUpload.do", method = RequestMethod.POST)
	public String popupUpload(	Model model, 
								HttpSession httpSession, 
								MultipartHttpServletRequest mre, 
								HttpServletRequest req,
								@RequestParam("popup-width")String width,
								@RequestParam("popup-height")String height,
								@RequestParam("popup-desc")String desc,
								@RequestParam("popup-name")String name
								) {
		
		
		 MultipartFile mf = mre.getFile("popupFile");		
		 
		 String defaultPath = httpSession.getServletContext().getRealPath("/"); 
		 String path = defaultPath + File.separator + "upload" + File.separator + "popup" + File.separator  + ""; 
		
		
		 String originalName = mf.getOriginalFilename(); 
		String originalNameExtension = originalName.substring(originalName.lastIndexOf(".") + 1).toLowerCase();
		
		System.out.println(originalName);
		System.out.println(originalName);
		System.out.println(originalName);
		System.out.println(originalName);
		System.out.println(originalName);
		System.out.println(originalName);
		
		File file = new File(path); 
		if(!file.exists()) { 
			file.mkdirs(); 
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss"); 
		String today= formatter.format(new Date()); 
		String modifyName = today + "-" + UUID.randomUUID().toString().substring(20) + "." + originalNameExtension;
		 try {
			 mf.transferTo(new File(path + modifyName)); 
			 System.out.println("** upload 정보 **"); 
			 System.out.println("** path : " + path + " **"); 
			 System.out.println("** originalName : " + originalName + " **"); 
			 System.out.println("** modifyName : " + modifyName + " **"); 
		 } catch (Exception e) {
			 e.printStackTrace(); 
			 System.out.println("이미지 파일 업로드 실패 - singleUploadImageAjax"); 
		 }
		 
		 
		String uploadPath = "/upload/popup/";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("width", width);
		params.put("height", height);
		params.put("desc", desc);
		params.put("name", name);
		params.put("path", (uploadPath + modifyName));
		
		int result = ad0302Service.popupUpload(params);
		
		return "redirect:/popupManager.do";
	}
	
	@RequestMapping(value = "/useHandler.do", method = RequestMethod.GET)
	public String useHandler(	Model model,
								@RequestParam("value")String val,
								@RequestParam("name")String name) {
			
		Map<String, String> params = new HashMap<String, String>();
		params.put("val", val);
		params.put("name", name);
		
		int result = ad0302Service.modifyPopupUse(params);
		
		
		return "redirect:/popupManager.do";
	}
	
	
	
	
	
}
