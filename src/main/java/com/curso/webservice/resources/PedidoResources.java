package com.curso.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.webservice.entidades.Pedido;
import com.curso.webservice.service.PedidoService;


@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResources {
	
	@Autowired
	private PedidoService pedidoService;
	
	
	// Esse metodo vai responder uma requisão GET enviando o usuario
	@GetMapping
	public ResponseEntity<List<Pedido>> fnidAll(){		
		List<Pedido> listPedidos =  pedidoService.findAll();
		return ResponseEntity.ok().body(listPedidos);
	}
	
	// Metodo de busca por Id:
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id){
		Pedido user = pedidoService.findById(id);		
		return ResponseEntity.ok(user); 
	}

}
