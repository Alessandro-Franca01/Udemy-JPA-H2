package com.curso.webservice.retositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.webservice.entidades.Pedido;

// Nao precisa implementar essa interface pq o JPA já implementa automaticamente
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
