package com.patis.daumEditor;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/daumEditor")
public class DaumEditorController {

	@RequestMapping(value = "/imagePopup.do", method = RequestMethod.GET)
	public String imagePopup() {
		System.out.println("hi");
		return "daum-editor/image";
	}

	@ResponseBody
	@RequestMapping(value="/singleUploadImageAjax.do", method=RequestMethod.POST)
	public Map<String, Object> singleUploadImageAjax(@RequestParam("Filedata") MultipartFile multipartFile,
										 			 HttpSession httpSession) {

		Map<String, Object> fileInfo = new HashMap<String, Object>();
		
		if(multipartFile != null && !(multipartFile.getOriginalFilename().equals(""))) { 
			String originalName = multipartFile.getOriginalFilename(); 
			String originalNameExtension = originalName.substring(originalName.lastIndexOf(".") + 1).toLowerCase();
			if(!((originalNameExtension.equals("jpg")) || (originalNameExtension.equals("gif")) ||
			    (originalNameExtension.equals("png")) || (originalNameExtension.equals("bmp")))) { 
				fileInfo.put("result", -1);
				return fileInfo; 
			}
			
			long filesize = multipartFile.getSize(); 
			long limitFileSize = 10*1024*1024; 
			if(limitFileSize < filesize){ 
				fileInfo.put("result", -2); 
				return fileInfo; 
			}

			String defaultPath = httpSession.getServletContext().getRealPath("/"); 
			String path = defaultPath + File.separator + "upload" + File.separator + "board" + File.separator + "images" + File.separator + ""; 
			File file = new File(path); 
			if(!file.exists()) { 
				file.mkdirs(); 
			}

			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss"); 
			String today= formatter.format(new Date()); 
			String modifyName = today + "-" + UUID.randomUUID().toString().substring(20) + "." + originalNameExtension; 
			 try {
				 multipartFile.transferTo(new File(path + modifyName)); 
				 System.out.println("** upload 정보 **"); 
				 System.out.println("** path : " + path + " **"); 
				 System.out.println("** originalName : " + originalName + " **"); 
				 System.out.println("** modifyName : " + modifyName + " **"); 
			 } catch (Exception e) {
				 e.printStackTrace(); 
				 System.out.println("이미지 파일 업로드 실패 - singleUploadImageAjax"); 
			 }
			 
			 String imageurl = httpSession.getServletContext().getContextPath() + "/upload/board/images/" + modifyName;
			 fileInfo.put("imageurl", imageurl); 
			 fileInfo.put("filename", modifyName); 
			 fileInfo.put("filesize", filesize);
		 	 fileInfo.put("imagealign", "C"); 
		 	 fileInfo.put("originalurl", imageurl);
		 	 fileInfo.put("thumburl", imageurl); 
		 	 fileInfo.put("result", 1);
	 	 } 
		 return fileInfo;
	}
	
	@RequestMapping(value = "/filePopup.do") 
	public String filePopup() { 
		return "daum-editor/file"; 
	}

	@ResponseBody
	@RequestMapping(value="/singleUploadFileAjax.do", method=RequestMethod.POST) 
	public Map<String, Object> singleUploadFileAjax(@RequestParam("Filedata") MultipartFile multipartFile, 
		 											HttpSession httpSession) { 
		Map<String, Object> fileInfo = new HashMap<String, Object>(); 
		
		if(multipartFile != null && !(multipartFile.getOriginalFilename().equals(""))) { 
			long filesize = multipartFile.getSize(); 
			long limitFileSize = 10*1024*1024; 
			if(limitFileSize < filesize){ 
				fileInfo.put("result", -1); 
				return fileInfo; 
			}
			
			String defaultPath = httpSession.getServletContext().getRealPath("/");
			String path = defaultPath + File.separator + "upload" + File.separator + "board" + File.separator + "files" + File.separator + ""; 
			File file = new File(path);
			
			if(!file.exists()) { 
				file.mkdirs(); 
			} 
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss"); 
			String today = formatter.format(new Date());
			String originalName = multipartFile.getOriginalFilename(); 
			String modifyName = today + "-" + originalName; 
			try { 
				multipartFile.transferTo(new File(path + modifyName)); 
				 System.out.println("** upload 정보 **"); 
				 System.out.println("** path : " + path + " **"); 
				 System.out.println("** originalName : " + originalName + " **");
				 System.out.println("** modifyName : " + modifyName + " **"); 
			 } catch (Exception e) { 
				 e.printStackTrace(); 
				 System.out.println("파일업로드 실패 - singleUploadFileAjax"); 
	 		 }
			
			 String fileMime = multipartFile.getContentType(); 
			 String attachurl = httpSession.getServletContext().getContextPath() + "/upload/board/files/" + modifyName;
			 fileInfo.put("attachurl", attachurl); 
			 fileInfo.put("filemime", fileMime);
			 fileInfo.put("filename", modifyName); 
			 fileInfo.put("filesize", filesize); 
			 fileInfo.put("result", 1); 
		}
		
		return fileInfo; 
	}
}