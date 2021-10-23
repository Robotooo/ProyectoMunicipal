package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.DiaSemanaDTO;

import java.util.List;
import java.util.Optional;

public interface IDiaSemanaService {

    public Optional<DiaSemanaDTO> findById(Long id);

    public Optional<List<DiaSemanaDTO>> findAll();

    public Optional<DiaSemanaDTO> create(DiaSemanaDTO diasemanaDTO);

    public Optional<DiaSemanaDTO> update(DiaSemanaDTO diasemanaDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

}
