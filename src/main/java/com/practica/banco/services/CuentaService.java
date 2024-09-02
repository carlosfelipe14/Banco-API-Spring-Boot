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

  public CuentaDTO update(String uuid, CuentaDTO cuentaDTO) {
    Cuenta cuenta = cuentaRepository.findByUuid(uuid);

    if(cuenta == null)
      throw new NotFoundException("Cuenta", uuid);

    cuenta.setMonto(cuentaDTO.getMonto());
    cuenta.setMoneda(cuentaDTO.getMoneda());
    cuenta.setSucursal(cuentaDTO.getSucursal());

    return cuentaMapper.toDTO(cuentaRepository.save(cuenta));
  }

  public CuentaDTO delete(String uuid) {
    Cuenta cuenta = cuentaRepository.findByUuid(uuid);

    if(cuenta == null)
      throw new NotFoundException("Cuenta", uuid);

    cuentaRepository.delete(cuenta);

    return cuentaMapper.toDTO(cuenta);
  }

}
