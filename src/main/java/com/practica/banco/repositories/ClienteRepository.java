package com.practica.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.banco.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    
}