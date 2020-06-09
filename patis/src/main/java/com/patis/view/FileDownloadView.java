package com.patis.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class FileDownloadView extends AbstractView {

	public FileDownloadView() {
		setContentType("apllication/download; charset=utf-8");
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		File downloadFile = (File) model.get("downloadFile"); 
		String fileName = (String) model.get("fileName");

		response.setContentType(getContentType()); 
		response.setContentLength((int)downloadFile.length()); 
		
		String browser = getBrowser(request);
		
		if(browser.equals("MSIE")) {
			fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Trident")) {
			fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Firefox")) {
			fileName = "\"" + new String(fileName.getBytes("UTF-8"), "8859_1") + "\"";
			fileName = URLDecoder.decode(fileName); 
		} else if (browser.equals("Opera")) {
			fileName = "\"" + new String(fileName.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Chrome")) {
			StringBuffer sb = new StringBuffer();
			
			for(int i=0; i<fileName.length(); i++) {
				char c = fileName.charAt(i);
				
				if(c > '~') {
					sb.append(URLEncoder.encode("" + c, "UTF-8"));
				} else {
					sb.append(c);
				}
			}
			
			fileName = sb.toString();
		} else if (browser.equals("Safari")) {
			fileName = "\"" + new String(fileName.getBytes("UTF-8"), "8859_1")+ "\"";
			fileName = URLDecoder.decode(fileName);
		} else {
			fileName = "\"" + new String(fileName.getBytes("UTF-8"), "8859_1")+ "\"";
		}
		
		response.setHeader("Content-Disposition", "attachment;fileName=\"" + fileName + "\";");
		response.setHeader("Content-Transter-Encoding", "binary");

		if("Opera".equals(browser)) {
			response.setContentType("application/octet-stream;charset=UTF-8");
		}
		
		OutputStream out = response.getOutputStream(); 
		FileInputStream fis = null; 
		
		try{
			fis = new FileInputStream(downloadFile);
			FileCopyUtils.copy(fis, out); 
		} finally{
			if(fis != null) fis.close();
		}
		out.flush(); 
	}
	
	private String getBrowser(HttpServletRequest request) {
        String header = request.getHeader("User-Agent");
        
	    if (header.indexOf("MSIE") > -1) {
	        return "MSIE";
	    } else if (header.indexOf("Trident") > -1) {   // IE11 
	        return "Trident";
	    } else if (header.indexOf("Chrome") > -1) {
	        return "Chrome";
	    } else if (header.indexOf("Opera") > -1) {
	        return "Opera";
	    } else if (header.indexOf("Safari") > -1) {
	        return "Safari";
	    } else {
	    	return "Firefox";
	    }
    }
}