package com.practica.banco.repositories;

import com.practica.banco.models.Cuenta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

}
