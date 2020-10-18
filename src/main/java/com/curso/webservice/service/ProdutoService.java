package com.curso.webservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.webservice.entidades.Produto;
import com.curso.webservice.retositories.ProdutoRepository;

@Service // registrando a classe de serviço no spring
public class ProdutoService {
	
	// Injetando uma dependecia da camada repositorio: para repassar a chamada da lista
	@Autowired
	private ProdutoRepository produtoRepository;
	
	// Esse metodo vai repassar a chamada para a camada de repositorio
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}
	
	// Tentando implementar um metodo para buscar um User por id: IMPLEMENTADO
	public Produto findById(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);		
		return produto.get();
	}
	
}
