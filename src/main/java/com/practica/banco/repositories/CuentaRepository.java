package com.practica.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practica.banco.models.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    @Query("SELECT c FROM cuentas c WHERE c.uuid = ?1")
    Cuenta findByUuid(String uuid);

}
