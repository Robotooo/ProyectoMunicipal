package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.FacturaDTO;

import java.util.List;
import java.util.Optional;

public class FacturaServiceImplementation implements  IFacturaService{

    @Override
    public Optional<FacturaDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<FacturaDTO>> findByNombre(String nombre) {
        return Optional.empty();
    }
}
