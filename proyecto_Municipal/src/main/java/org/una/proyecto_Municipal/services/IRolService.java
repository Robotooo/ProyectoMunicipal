package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.dto.PropiedadDTO;
import org.una.proyecto_Municipal.dto.RolDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IRolService {

    public Optional<RolDTO> findById(Long id);

    public Optional<List<RolDTO>> findAll();

    public Optional<List<RolDTO>> findByNombre(String nombre);

    //public Optional<List<RolDTO>> findByFechaCreacionBetween(Date startDate, Date endDate);

    public void delete(Long id);

    public void deleteAll();

    public Optional<RolDTO> create(RolDTO rolDTO);

    public Optional<RolDTO> update(RolDTO rolDTO, Long id);

}
