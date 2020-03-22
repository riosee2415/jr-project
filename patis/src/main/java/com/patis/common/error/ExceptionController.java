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
		return "500err";
	}
	  	 		
}