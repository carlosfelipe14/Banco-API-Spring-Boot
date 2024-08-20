package com.practica.banco.models;

import com.practica.banco.dtos.Genero;
import com.practica.banco.dtos.TipoDoc;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.UUID;

@Entity(name = "clientes")
public class Cliente {
    
    @Id
    @GeneratedValue
    private int id;
    @Column(updatable = false, nullable = false, unique = true, length = 36)
    private String uuid;
    @Column(length = 100)
    private String nombre;
    @Column(length = 50)
    private String primerApellido;
    @Column(length = 50)
    private String segundoApellido;
    @Enumerated(EnumType.STRING)
    private TipoDoc tipoDocumento;
    @Column(length = 30)
    private String numeroDocumento;
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Enumerated(EnumType.ORDINAL)
    private Genero genero;

    public Cliente() {}

    public Cliente(int id, String nombre, String primerApellido, String segundoApellido, TipoDoc tipoDocumento,
            String numeroDocumento, Date fechaNacimiento, Genero genero) {
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public TipoDoc getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDoc tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @PrePersist
    public void initializeUuid(){
        this.setUuid(UUID.randomUUID().toString());
    }

}
