package com.curso.webservice.retositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.webservice.entidades.Users;

// Nao precisa implementar essa interface pq o JPA já implementa automaticamente
public interface UserRepository extends JpaRepository<Users, Long> {

}
