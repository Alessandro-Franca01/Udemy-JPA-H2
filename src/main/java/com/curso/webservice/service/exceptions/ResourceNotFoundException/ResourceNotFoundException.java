package com.curso.webservice.service.exceptions.ResourceNotFoundException;

public abstract class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Long id) {
		super("Id do usuario não encontrado: Id = "+id);
	}		

}
