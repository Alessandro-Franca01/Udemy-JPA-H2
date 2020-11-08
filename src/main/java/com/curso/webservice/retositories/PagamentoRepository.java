package com.curso.webservice.retositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.webservice.entidades.Pagamento;

// Nao precisa implementar essa interface pq o JPA já implementa automaticamente
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
 