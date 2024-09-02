package com.practica.banco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.banco.dtos.CuentaDTO;
import com.practica.banco.services.CuentaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

  @Autowired
  private CuentaService cuentaService;

  @GetMapping("/{cuuid}")
  public CuentaDTO getOne(@PathVariable("cuuid") String uuid) {
    return cuentaService.getOne(uuid);
  }

  @PutMapping("/{cuuid}")
  public CuentaDTO update(@PathVariable("cuuid") String uuid, @Valid @RequestBody CuentaDTO cuentaDTO) {
    return cuentaService.update(uuid, cuentaDTO);
  }

  @DeleteMapping("/{cuuid}")
  public CuentaDTO delete(@PathVariable("cuuid") String uuid) {
    return cuentaService.delete(uuid);
  }

}
