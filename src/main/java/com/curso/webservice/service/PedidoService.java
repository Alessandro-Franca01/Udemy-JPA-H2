package com.curso.webservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.webservice.entidades.Pedido;
import com.curso.webservice.retositories.PedidoRepository;


@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
		
	public List<Pedido> findAll(){
		return pedidoRepository.findAll();
	}
	
	// Tentando implementar um metodo para buscar um User por id: IMPLEMENTADO
	public Pedido findById(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);		
		return pedido.get();
	}
	
	// Criar o metodo para salvar pedido:
	
	
}
