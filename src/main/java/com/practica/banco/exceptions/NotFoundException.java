package com.practica.banco.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException(String resourceName, String uuid) {
        super(String.format("%s not found - UUID: %s", resourceName, uuid));
    }

}
