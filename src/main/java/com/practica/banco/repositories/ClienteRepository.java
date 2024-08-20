package com.practica.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practica.banco.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT u FROM clientes u WHERE u.uuid = ?1")
    Cliente findByUuid(String uuid);
}