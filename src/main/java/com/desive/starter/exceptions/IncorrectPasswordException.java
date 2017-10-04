package com.desive.starter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectPasswordException extends RuntimeException {

	public IncorrectPasswordException(final String username) {
		super("Incorrect password for username: " + username);
	}

}
