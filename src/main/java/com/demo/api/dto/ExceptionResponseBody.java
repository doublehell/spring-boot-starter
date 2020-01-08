package com.demo.api.dto;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExceptionResponseBody {
	
	private String exceptionName;
	private String message;
	private String requestURL;
	private String stackTrace;
	
	
	public ExceptionResponseBody(HttpServletRequest req, Exception e) {
		setExceptionName(e.getClass().getSimpleName().toUpperCase());
		setMessage(e.getMessage());
		setRequestURL(req.getRequestURL().toString());
		setStackTrace(generateStackTrace(e));
		
	}

	private String generateStackTrace(Exception e) {
		StringWriter sw = null;
		PrintWriter pw = null;
		String msg = "can't generate the stacktrace.";
		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			msg = sw.toString();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				pw.close();
				sw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return msg;
	}

}
