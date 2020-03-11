package com.patis.common.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.patis.model.CommentsVO;
import com.sun.org.apache.bcel.internal.generic.CPInstruction;

@Controller
public class CommentController {

	@Resource(name="commentService")
	private I_CommentService commentService;
	
	
	@RequestMapping(value="/commentList.do", method=RequestMethod.GET)
	public String commentList(Model model,
							 @RequestParam("b_type")String b_type,
							 @RequestParam("p_no")int p_no) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("b_type", b_type);
		params.put("p_no", p_no);
		
		List<CommentsVO> commentList = commentService.getCommentList(params);
		model.addAttribute("commentList", commentList);
		
		return "ajax/comment";
	}
	
	@ResponseBody
	@RequestMapping(value="/commentWrite.do", method=RequestMethod.POST, produces="application/json")
	public Map<String, Object> commentWrite(Model model,
							 @RequestParam("b_type")String b_type,
							 @RequestParam("p_no")int p_no,
							 @RequestParam("desc")String desc,
							 @RequestParam("author")int author) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("b_type", b_type);
		params.put("p_no", p_no);
		params.put("desc", desc);
		params.put("author", author);
	
		CommentsVO comments = new CommentsVO();
		comments.setCO_BOARD_TYPE(b_type);
		comments.setCO_PARENT_NO(p_no);
		comments.setCO_DESCRIPTION(desc);
		comments.setCO_AUTHOR(Integer.toString(author));
		
		Map<String, Object> data = new HashMap<String, Object>();
		int result = 0;
		commentService.setComment(comments);
		result = 1;
		
		data.put("result", result);
		
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value="/commentModify.do", method=RequestMethod.POST, produces="application/json")
	public Map<String, Object> commentModify(Model model,
							   @RequestParam("co_no")int co_no,
							   @RequestParam("desc")String desc) throws Exception {
		CommentsVO comments = new CommentsVO();
		comments.setCO_NO(co_no);
		comments.setCO_DESCRIPTION(desc);
		
		Map<String, Object> data = new HashMap<String, Object>();
		int result = 0;
		commentService.modifyComment(comments);
		result = 1;
		
		data.put("result", result);
		
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value="/commentRemove.do", method=RequestMethod.POST, produces="application/json")
	public Map<String, Object> commentRemove(Model model,
							 @RequestParam("co_no")int co_no) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		int result = 0;
		commentService.removeComment(co_no);
		result = 1;
		
		data.put("result", result);
		
		return data;
	}
}