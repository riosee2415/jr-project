package com.patis.common.error;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler({Exception.class, NoHandlerFoundException.class, ResourceNotFoundException.class})
	public String exception(Exception e) {
		return "redirect:/500err.do";
	}
	  	 		
	@RequestMapping(value = "/404err.do", method = RequestMethod.GET)
	public String err404() {
		
		return "404err";
	}
	
	@RequestMapping(value = "/500err.do", method = RequestMethod.GET)
	public String err500() {
		
		return "500err";
	}
}