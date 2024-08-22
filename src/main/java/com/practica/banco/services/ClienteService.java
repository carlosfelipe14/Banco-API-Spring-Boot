package com.practica.banco.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.practica.banco.dtos.ClienteDTO;
import com.practica.banco.dtos.ClienteMapper;
import com.practica.banco.exceptions.NotFoundException;
import com.practica.banco.models.Cliente;
import com.practica.banco.repositories.ClienteRepository;

@Component
public class ClienteService {

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> getAll() {
        return clienteRepository.findAll()
                                .stream()
                                .map(cliente -> clienteMapper.toDTO(cliente))
                                .collect(Collectors.toList());
    }

    public ClienteDTO save(ClienteDTO clienteDto) {
        Cliente cliente = clienteMapper.toModel(clienteDto);
        return clienteMapper.toDTO(clienteRepository.save(cliente));
    }

    public ClienteDTO getOne(String uuid) {
        Cliente cliente = clienteRepository.findByUuid(uuid);

        if(cliente == null)
            throw new NotFoundException("Cliente", uuid);

        return clienteMapper.toDTO(cliente);
    }

    public ClienteDTO update(String uuid, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findByUuid(uuid);

        if(cliente == null)
            throw new NotFoundException("Cliente", uuid);

        cliente.setNombre(clienteDTO.getNombre());
        cliente.setPrimerApellido(clienteDTO.getPrimerApellido());
        cliente.setSegundoApellido(clienteDTO.getSegundoApellido());
        cliente.setTipoDocumento(clienteDTO.getTipoDocumento());
        cliente.setNumeroDocumento(clienteDTO.getNumeroDocumento());
        cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
        cliente.setGenero(clienteDTO.getGenero());

        clienteRepository.save(cliente);
        return clienteMapper.toDTO(cliente);
    }

    public ClienteDTO delete(String uuid) {
        Cliente cliente = clienteRepository.findByUuid(uuid);

        if(cliente == null)
            throw new NotFoundException("Cliente", uuid);

        clienteRepository.delete(cliente);
        return clienteMapper.toDTO(cliente);
    }

}
