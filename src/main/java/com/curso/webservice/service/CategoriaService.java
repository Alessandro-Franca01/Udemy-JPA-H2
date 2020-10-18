package com.curso.webservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.webservice.entidades.Categoria;
import com.curso.webservice.retositories.CategoriaRepository;

@Service // registrando a classe de serviço no spring
public class CategoriaService {
	
	// Injetando uma dependecia da camada repositorio: para repassar a chamada da lista
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	// Esse metodo vai repassar a chamada para a camada de repositorio
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	// Tentando implementar um metodo para buscar um User por id: IMPLEMENTADO
	public Categoria findById(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);		
		return categoria.get();
	}
	
}
