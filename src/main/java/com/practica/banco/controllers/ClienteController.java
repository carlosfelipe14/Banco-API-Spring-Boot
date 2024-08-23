package com.practica.banco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.banco.dtos.ClienteDTO;
import com.practica.banco.services.ClienteService;

import jakarta.validation.Valid;

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
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO cliente) {
        return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
    }

    @GetMapping("/{cluuid}")
    public ClienteDTO getOne(@PathVariable("cluuid") String uuid) {
        return clienteService.getOne(uuid);
    }

    @PutMapping("/{cluuid}")
    public ClienteDTO update(@PathVariable("cluuid") String uuid, @RequestBody ClienteDTO clienteDTO) {
        return clienteService.update(uuid, clienteDTO);
    }

    @DeleteMapping("/{cluuid}")
    public ClienteDTO delete(@PathVariable("cluuid") String uuid) {
        return clienteService.delete(uuid);
    }
}
