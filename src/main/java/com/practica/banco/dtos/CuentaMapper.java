package com.practica.banco.dtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practica.banco.models.Cliente;
import com.practica.banco.models.Cuenta;

@Component
public class CuentaMapper {

  @Autowired
  private ClienteMapper clienteMapper;

  public CuentaDTO toDTO(Cuenta cuenta, boolean withClienteModel) {
    CuentaDTO cuentaDTO = new CuentaDTO(
        cuenta.getUuid(),
        cuenta.getTipoProducto(),
        cuenta.getNumeroCuenta(),
        cuenta.getMoneda(),
        cuenta.getMonto(),
        cuenta.getFechaApertura(),
        cuenta.getSucursal());

    if (withClienteModel)
      cuentaDTO.setCliente(clienteMapper.toDTO(cuenta.getCliente()));
  
      return cuentaDTO;
  }

  public Cuenta toModel(CuentaDTO cuentaDTO, Cliente cliente) {
    Cuenta cuenta = new Cuenta();
    cuenta.setUuid(cuentaDTO.getUuid());
    cuenta.setTipoProducto(cuentaDTO.getTipoProducto());
    cuenta.setNumeroCuenta(cuentaDTO.getNumeroCuenta());
    cuenta.setMoneda(cuentaDTO.getMoneda());
    cuenta.setMonto(cuentaDTO.getMonto());
    cuenta.setFechaApertura(cuentaDTO.getFechaApertura());
    cuenta.setSucursal(cuentaDTO.getSucursal());

    cuenta.setCliente(cliente);
    return cuenta;
  }

}
