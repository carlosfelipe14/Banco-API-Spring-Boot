package com.practica.banco.services;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.practica.banco.dtos.ClienteDTO;
import com.practica.banco.dtos.Genero;
import com.practica.banco.dtos.TipoDoc;

@Component
public class ClienteService {

    public List<ClienteDTO> getAll() {
        return Collections.singletonList(new ClienteDTO(UUID.randomUUID().toString(), 
                    "Luis", "Perez", null, 
                    TipoDoc.CI, "6543210", 
                    new GregorianCalendar(1995, Calendar.NOVEMBER, 5).getTime(), 
                    Genero.HOMBRE));
    }
}
