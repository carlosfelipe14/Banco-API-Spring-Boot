package com.practica.banco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practica.banco.dtos.CuentaDTO;
import com.practica.banco.dtos.CuentaMapper;
import com.practica.banco.exceptions.NotFoundException;
import com.practica.banco.models.Cuenta;
import com.practica.banco.repositories.CuentaRepository;

@Component
public class CuentaService {

  @Autowired
  private CuentaRepository cuentaRepository;

  @Autowired
  private CuentaMapper cuentaMapper;

  public CuentaDTO getOne(String uuid) {
    Cuenta cuenta = cuentaRepository.findByUuid(uuid);

    if(cuenta == null)
      throw new NotFoundException("Cuenta", uuid);

    return cuentaMapper.toDTO(cuenta);
  }

}
