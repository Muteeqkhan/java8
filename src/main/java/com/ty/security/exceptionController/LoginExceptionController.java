package com.ty.security.exceptionController;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.security.exceptions.LoginFailException;

@RestControllerAdvice
public class LoginExceptionController {

	
	@ExceptionHandler(LoginFailException.class)
	public String AuthenticationException(LoginFailException l,HttpServletRequest request) {
		return l.getMessage();
	}
}
