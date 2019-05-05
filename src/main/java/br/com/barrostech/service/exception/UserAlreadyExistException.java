package br.com.barrostech.service.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistException extends BusinessException {
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistException(HttpStatus status) {
		super(status.BAD_REQUEST);
	}

}
