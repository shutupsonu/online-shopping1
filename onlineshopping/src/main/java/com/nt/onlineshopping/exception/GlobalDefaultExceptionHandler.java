package com.nt.onlineshopping.exception;

import java.awt.print.Printable;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() { 
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "This page is not constructed.!");
		
		mv.addObject("errorDescription", "The page you looking for not available now.. !");
		
		mv.addObject("title", "404 Error page");
		
		
		
		return mv;
		
	}
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() { 
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Product not Found.!");
		
		mv.addObject("errorDescription", "The Product you looking for not available now.. !");
		
		mv.addObject("title", "Product Unavilable");
		
		
		
		return mv;
		
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) { 
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Contact Your Administrator !");
		
		/*Only for application debbuging*/
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		
		
		mv.addObject("errorDescription", sw.toString());
		
		mv.addObject("title", "Product Unavilable");
		
		
		
		return mv;
		
	}

}
