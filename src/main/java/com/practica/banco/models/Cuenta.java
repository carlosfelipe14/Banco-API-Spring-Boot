package com.practica.banco.models;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.practica.banco.dtos.Moneda;
import com.practica.banco.dtos.SucursalBancaria;
import com.practica.banco.dtos.TipoProducto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity(name = "cuentas")
@EntityListeners(AuditingEntityListener.class)
public class Cuenta {

  @Id
  @GeneratedValue
  private int id;
  @Column(updatable = false, nullable = false, unique = true, length = 36)
  private String uuid;
  @Enumerated(EnumType.STRING)
  @Column(updatable = false, nullable = false)
  private TipoProducto tipoProducto;
  @Column(length = 10, updatable = false, nullable = false, unique = true)
  private String numeroCuenta;
  @Enumerated(EnumType.STRING)
  private Moneda moneda;
  @Column(columnDefinition = "DECIMAL(10,2) NOT NULL DEFAULT 0.0")
  private Double monto;
  @Temporal(TemporalType.DATE)
  @Column(updatable = false, nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
  private Date fechaApertura;
  @Enumerated(EnumType.STRING)
  private SucursalBancaria sucursal;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Cliente cliente;

  @CreatedDate
  @Column(updatable = false, columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP")
  private Date createdDate;
  @LastModifiedDate
  @Column(updatable = true, columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP")
  private Date modifiedDate;

  public Cuenta() {
  }

  public Cuenta(int id, String uuid, TipoProducto tipoProducto, String numeroCuenta, Moneda moneda, Double monto,
      Date fechaApertura, SucursalBancaria sucursal, Cliente cliente) {
    this.id = id;
    this.uuid = uuid;
    this.tipoProducto = tipoProducto;
    this.numeroCuenta = numeroCuenta;
    this.moneda = moneda;
    this.monto = monto;
    this.fechaApertura = fechaApertura;
    this.sucursal = sucursal;
    this.cliente = cliente;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  @PrePersist
  public void initializedUuid() {
    this.uuid = java.util.UUID.randomUUID().toString();
  }
}
