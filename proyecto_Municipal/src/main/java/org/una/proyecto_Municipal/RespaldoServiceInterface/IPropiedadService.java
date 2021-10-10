package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.PropiedadDTO;

import java.util.List;
import java.util.Optional;

public interface IPropiedadService {

    public Optional<PropiedadDTO> findById(Long id);

    public Optional<List<PropiedadDTO>> findAll();

    public Optional<List<PropiedadDTO>> findByEstado(Boolean estado);

    public void delete(Long id);

    public void deleteAll();

    public Optional<PropiedadDTO> create(PropiedadDTO propiedadDTO);

    public Optional<PropiedadDTO> update(PropiedadDTO propiedadDTO, Long id);
}