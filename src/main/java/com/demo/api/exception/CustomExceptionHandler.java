package com.demo.api.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.demo.api.dto.ExceptionResponseBody;

import ch.qos.logback.classic.Logger;

@ControllerAdvice
public class CustomExceptionHandler {

	@ResponseBody
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ExceptionResponseBody handleNotFoundRecordException(HttpServletRequest req, NotFoundRecordException e) {
		return new ExceptionResponseBody(req, e);
	}
	
	@ResponseBody
	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponseBody handleRuntimeException(HttpServletRequest req, RuntimeException e) {
		e.printStackTrace();
		return new ExceptionResponseBody(req, e);
	}
}
