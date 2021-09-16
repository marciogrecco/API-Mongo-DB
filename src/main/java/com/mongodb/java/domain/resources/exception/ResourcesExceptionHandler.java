package com.mongodb.java.domain.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.mongodb.java.services.exeption.ObjectNotFoundException;

// classe trata possiveis erros nas requisições
@ControllerAdvice
public class ResourcesExceptionHandler {

	public ResponseEntity<StandardError> objctNotFoundException(ObjectNotFoundException e, HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Objeto não encontrado",
				e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(status).body(err);

	}
}
