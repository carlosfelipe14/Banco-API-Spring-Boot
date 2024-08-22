package com.practica.banco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.banco.dtos.ClienteDTO;
import com.practica.banco.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping()
    public List<ClienteDTO> getAll() {
        return clienteService.getAll();
    }

    @PostMapping()
    public ClienteDTO create(@RequestBody ClienteDTO cliente) {
        return clienteService.save(cliente);
    }

    @GetMapping("/{cluuid}")
    public ClienteDTO getOne(@PathVariable("cluuid") String uuid) {
        return clienteService.getOne(uuid);
    }

    @PutMapping("/{cluuid}")
    public ClienteDTO update(@PathVariable("cluuid") String uuid, @RequestBody ClienteDTO clienteDTO) {
        return clienteService.update(uuid, clienteDTO);
    }
}
