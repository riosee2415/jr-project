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

import com.patis.model.CommentsVO;

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
}
