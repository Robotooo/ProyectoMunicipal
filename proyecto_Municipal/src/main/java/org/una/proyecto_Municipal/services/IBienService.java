package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.BienDTO;

import java.util.Optional;

public interface IBienService {

    public Optional<BienDTO> findById(Long id);

}
