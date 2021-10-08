package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.una.proyecto_Municipal.dto.ParametroDTO;
import org.una.proyecto_Municipal.dto.PropiedadDTO;
import org.una.proyecto_Municipal.repositories.IPropiedadRepository;

import java.util.List;
import java.util.Optional;

public class PropiedadServiceImplementation implements IPropiedadService{

    @Autowired
    private IPropiedadRepository propiedadRepository;

    @Override
    public Optional<PropiedadDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<PropiedadDTO>> findByNombre(String nombre) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ParametroDTO>> findByEstado(boolean estado) {
        return Optional.empty();
    }
}
