package com.patis.common.file;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FileController implements ApplicationContextAware {

	private WebApplicationContext context = null; 
	
	@RequestMapping(value="/fileDownload.do", method=RequestMethod.POST)
	public ModelAndView fileDownload(HttpServletRequest req, HttpServletResponse res, ModelAndView mav) throws Exception {
		String filePath = req.getParameter("filePath");
		String fileName = req.getParameter("fileName");
		File downloadFile = getFile(filePath);
	
		if(downloadFile == null) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("downloadFile", downloadFile);
		params.put("fileName", fileName);
		
		return new ModelAndView("fileDownload", params);
	}
	
	private File getFile(String filePath) {
		String baseDir = context.getServletContext().getRealPath(filePath);
		return new File(baseDir);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.context = (WebApplicationContext) applicationContext;
	}
	
}
