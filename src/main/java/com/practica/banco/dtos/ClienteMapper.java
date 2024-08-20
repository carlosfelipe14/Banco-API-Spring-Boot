package com.practica.banco.dtos;

import org.springframework.stereotype.Component;

import com.practica.banco.models.Cliente;

@Component
public class ClienteMapper {

    public ClienteDTO toDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getUuid(), 
                            cliente.getNombre(), 
                            cliente.getPrimerApellido(), 
                            cliente.getSegundoApellido(), 
                            cliente.getTipoDocumento(), 
                            cliente.getNumeroDocumento(), 
                            cliente.getFechaNacimiento(), 
                            cliente.getGenero());
    }

    public Cliente toModel(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setUuid(dto.getUuid());
        cliente.setNombre(dto.getNombre());
        cliente.setPrimerApellido(dto.getPrimerApellido());
        cliente.setSegundoApellido(dto.getSegundoApellido());
        cliente.setTipoDocumento(dto.getTipoDocumento());
        cliente.setNumeroDocumento(dto.getNumeroDocumento());
        cliente.setFechaNacimiento(dto.getFechaNacimiento());
        cliente.setGenero(dto.getGenero());
        return cliente;
    }
}
