package com.eventoapp.repository;

import com.eventoapp.models.Evento;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author CarlosMacaneta
 */
public interface EventoRepository extends CrudRepository<Evento, String>{
    //buscando um evento especifico no banco de dados
    Evento findbyId(long codigo);
}
