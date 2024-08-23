package com.practica.banco.dtos;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClienteDTO {

    private String uuid;
    @NotNull
    @Size(min = 2, max = 100)
    private String nombre;
    @NotNull
    @Size(min = 2, max = 50)
    private String primerApellido;
    @Size(min = 2, max = 50)
    private String segundoApellido;
    @NotNull
    private TipoDoc tipoDocumento;
    @Pattern(regexp = "^[0-9]+(\\-[0-9]+)*$", message = "Quantity must be a numeric value")
    private String numeroDocumento;
    @Past
    private Date fechaNacimiento;
    @NotNull
    private Genero genero;

    public ClienteDTO() {}

    public ClienteDTO(String uuid, String nombre, String primerApellido, String segundoApellido, TipoDoc tipoDocumento,
            String numeroDocumento, Date fechaNacimiento, Genero genero) {
        this.uuid = uuid;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    
}
