package br.com.barrostech.service.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private HttpStatus status;

	public BusinessException(HttpStatus status) {
		super();
		this.status = status;
	}
	
	
}
