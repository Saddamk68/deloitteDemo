package com.deloitte.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DBAccessException extends Exception {

	private static final long serialVersionUID = -4833981420161220301L;

	public DBAccessException(String message) {
		super(message);
	}

}
