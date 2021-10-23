package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.CategoriaxPropiedadDTO;

import java.util.List;
import java.util.Optional;

public interface ICategoriaxPropiedadService {

    public Optional<CategoriaxPropiedadDTO> findById(Long id);

    public Optional<List<CategoriaxPropiedadDTO>> findAll();

    public Optional<CategoriaxPropiedadDTO> create(CategoriaxPropiedadDTO categoriaxpropiedadDTO);

    public Optional<CategoriaxPropiedadDTO> update(CategoriaxPropiedadDTO categoriaxpropiedadDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

}
