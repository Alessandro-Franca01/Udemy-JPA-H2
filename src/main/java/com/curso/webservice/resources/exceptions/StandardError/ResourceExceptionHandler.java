package com.curso.webservice.resources.exceptions.StandardError;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.curso.webservice.service.exceptions.ResourceNotFoundException.ResourceNotFoundException;

// Essa classe vai interagir com a camada de controller 
@ControllerAdvice
public class ResourceExceptionHandler {
	
	// Esse metodo vai capturar esse tipo de exeção "ResourceNotFoundException" 
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> userIdNotFind(ResourceNotFoundException e, HttpServletRequest request){
		String erro = " Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError ste = new StandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		// Passando no corpo da reposta em exeção personalizado!
		return ResponseEntity.status(status).body(ste);
		
	}

}
