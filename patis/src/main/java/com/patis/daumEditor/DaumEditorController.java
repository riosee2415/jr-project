package com.patis.daumEditor;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.patis.common.tempFile.I_TempFileService;
import com.patis.model.BoardFileVO;
import com.patis.model.BoardTempFileVO;

@Controller
@RequestMapping(value = "/daumEditor")
public class DaumEditorController {

	@Resource(name="tempFileService")
	private I_TempFileService tempFileService;
	
	@RequestMapping(value = "/imagePopup.do", method = RequestMethod.GET)
	public String imagePopup(Model model, 
							 @RequestParam("btype")String btype,
							 @RequestParam("file_key")String file_key) {
		model.addAttribute("btype", btype);
		model.addAttribute("file_key", file_key);
		
		return "daum-editor/image";
	}

	@ResponseBody
	@RequestMapping(value="/singleUploadImageAjax.do", method=RequestMethod.POST)
	public Map<String, Object> singleUploadImageAjax(@RequestParam("Filedata") MultipartFile multipartFile,
													 @RequestParam("btype") String btype,
													 @RequestParam("file_key") String file_key,
										 			 HttpSession httpSession) throws Exception {

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
			
			String uploadPath = "/upload/board/images/";
			
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
			 
			 BoardTempFileVO tempFileVO = new BoardTempFileVO();
			 tempFileVO.setTFILE_O_PATH(uploadPath + originalName);
			 tempFileVO.setTFILE_V_PATH(uploadPath + modifyName);
			 tempFileVO.setTFILE_KEY(file_key);
			 tempFileVO.setATTACH_YN(0);
			 tempFileService.setTempFile(tempFileVO);
			 
			 String imageurl = httpSession.getServletContext().getContextPath() + uploadPath + modifyName;
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
	public String filePopup(Model model, 
							@RequestParam("btype")String btype,
							@RequestParam("file_key")String file_key) {
		
		model.addAttribute("btype", btype);
		model.addAttribute("file_key", file_key);
		
		return "daum-editor/file";
	}

	@ResponseBody
	@RequestMapping(value="/singleUploadFileAjax.do", method=RequestMethod.POST) 
	public Map<String, Object> singleUploadFileAjax(@RequestParam("Filedata") MultipartFile multipartFile, 
													@RequestParam("btype") String btype,
													@RequestParam("file_key") String file_key,
		 											HttpSession httpSession) throws Exception { 
		Map<String, Object> fileInfo = new HashMap<String, Object>(); 
		
		if(multipartFile != null && !(multipartFile.getOriginalFilename().equals(""))) { 
			long filesize = multipartFile.getSize(); 
			long limitFileSize = 1000*1024*1024; 
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
			String originalNameExtension = originalName.substring(originalName.lastIndexOf(".") + 1).toLowerCase();
			
			String[] extArray = {"mp4", "mpg", "mpeg", "mpe", "mkv", "mov", "wmv", "asf", "asx", "flv", "rm", "ts", "tp", "dat", "3gp", "avi"};
			boolean isExist = false;
			for(String ext : extArray) {
				if(ext.equals(originalNameExtension)) {
					isExist = true;
					break;
				}
			}
			
			String modifyName = today + "-" + originalName; 
			
			String uploadPath = "/upload/board/files/";
			
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
			
			 BoardTempFileVO tempFileVO = new BoardTempFileVO();
			 tempFileVO.setTFILE_O_PATH(uploadPath + originalName);
			 tempFileVO.setTFILE_V_PATH(uploadPath + modifyName);
			 tempFileVO.setTFILE_KEY(file_key);
			 if(isExist)
				 tempFileVO.setATTACH_YN(0);
			 else
				 tempFileVO.setATTACH_YN(1);
			
			 tempFileService.setTempFile(tempFileVO);
			
			 String fileMime = multipartFile.getContentType();
			 String attachurl = httpSession.getServletContext().getContextPath() + uploadPath + modifyName;
			 fileInfo.put("attachurl", attachurl); 
			 fileInfo.put("filemime", fileMime);
			 fileInfo.put("filename", modifyName); 
			 fileInfo.put("filesize", filesize); 
			 fileInfo.put("result", 1);
		}
		
		return fileInfo; 
	}
}