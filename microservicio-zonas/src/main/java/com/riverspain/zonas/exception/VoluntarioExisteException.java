package com.riverspain.zonas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class VoluntarioExisteException extends RuntimeException {

	public VoluntarioExisteException(String mensaje) {
		super(mensaje);
	}
}
