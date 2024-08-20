package com.practica.banco.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practica.banco.dtos.ClienteDTO;
import com.practica.banco.dtos.ClienteMapper;
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
}
