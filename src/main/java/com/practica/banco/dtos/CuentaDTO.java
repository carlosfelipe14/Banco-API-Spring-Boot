package com.practica.banco.dtos;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

public class CuentaDTO {
  
  private String uuid;
  @NotNull
  private TipoProducto tipoProducto;
  @NotNull
  @Pattern(regexp = "^[0-9]{10}$", message = "must be 10 dígits")
  private String numeroCuenta;
  @NotNull
  private Moneda moneda;
  @NotNull
  private Double monto;
  @NotNull
  @PastOrPresent
  private Date fechaApertura;
  @NotNull
  private SucursalBancaria sucursal;

  private ClienteDTO cliente;

  public CuentaDTO() { }

  public CuentaDTO(String uuid, TipoProducto tipoProducto, String numeroCuenta, Moneda moneda, Double monto,
      Date fechaApertura, SucursalBancaria sucursal) {
    this.uuid = uuid;
    this.tipoProducto = tipoProducto;
    this.numeroCuenta = numeroCuenta;
    this.moneda = moneda;
    this.monto = monto;
    this.fechaApertura = fechaApertura;
    this.sucursal = sucursal;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public TipoProducto getTipoProducto() {
    return tipoProducto;
  }

  public void setTipoProducto(TipoProducto tipoProducto) {
    this.tipoProducto = tipoProducto;
  }

  public String getNumeroCuenta() {
    return numeroCuenta;
  }

  public void setNumeroCuenta(String numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
  }

  public Moneda getMoneda() {
    return moneda;
  }

  public void setMoneda(Moneda moneda) {
    this.moneda = moneda;
  }

  public Double getMonto() {
    return monto;
  }

  public void setMonto(Double monto) {
    this.monto = monto;
  }

  public Date getFechaApertura() {
    return fechaApertura;
  }

  public void setFechaApertura(Date fechaApertura) {
    this.fechaApertura = fechaApertura;
  }

  public SucursalBancaria getSucursal() {
    return sucursal;
  }

  public void setSucursal(SucursalBancaria sucursal) {
    this.sucursal = sucursal;
  }

  public ClienteDTO getCliente() {
    return cliente;
  }

  public void setCliente(ClienteDTO cliente) {
    this.cliente = cliente;
  }
  
}
