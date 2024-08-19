package com.practica.banco.services;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ClienteService {

    public List<String> getAll() {
        return Collections.singletonList("Cliente 1");
    }
}
