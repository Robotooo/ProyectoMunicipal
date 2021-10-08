package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.CobroDTO;

import java.util.Optional;

public interface ICobroService {

    public Optional<CobroDTO> findById(Long id);

    //TODO: Función para buscar cobro con número de cédula o número de activo

}
