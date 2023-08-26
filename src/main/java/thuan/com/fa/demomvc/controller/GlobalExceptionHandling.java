package thuan.com.fa.demomvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandling {
	@ExceptionHandler(Exception.class)
	private String processGenericException(Model model, Exception ex) {
		model.addAttribute("exception", ex);
		return "error/generic_error";
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	private String processNotFounfException(Model model, Exception ex) {
		System.out.println("aaaa GlobalExceptionHandling");
		model.addAttribute("exception", ex);
		return "error/404";
	}

}
