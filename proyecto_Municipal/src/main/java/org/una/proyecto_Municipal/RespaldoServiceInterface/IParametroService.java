package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.ParametroDTO;
import org.una.proyecto_Municipal.dto.PropiedadDTO;

import java.util.List;
import java.util.Optional;

public interface IParametroService{

    public Optional<ParametroDTO> findById(Long id);

    public Optional<List<ParametroDTO>> findAll();

    public Optional<List<ParametroDTO>> findByNombre(String nombre);

    public Optional<List<ParametroDTO>> findByEstado(boolean estado);

    public void delete(Long id);

    public void deleteAll();

    public Optional<ParametroDTO> create(ParametroDTO parametroDTO);

    public Optional<ParametroDTO> update(ParametroDTO parametroDTO, Long id);
}