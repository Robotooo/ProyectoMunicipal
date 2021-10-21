package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.FuncionarioDTO;
import org.una.proyecto_Municipal.dto.PropiedadDTO;

import java.util.List;
import java.util.Optional;

public interface IPropiedadService {

    public Optional<PropiedadDTO> findById(long id);

    public Optional<List<PropiedadDTO>> findAll();

//    public Optional<List<PropiedadDTO>> findByNombre(String nombre);

    public Optional<List<PropiedadDTO>> findByEstado(boolean estado);

    public Optional<PropiedadDTO> create(PropiedadDTO propiedadDTO);

    public Optional<PropiedadDTO> update(PropiedadDTO propiedadDTO, long id);

    public void delete(long id);

    public void deleteAll();

}
