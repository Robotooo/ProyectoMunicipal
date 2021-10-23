package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.DeclaracionAnualDTO;

import java.util.List;
import java.util.Optional;

public interface IDeclaracionAnualService {

    public Optional<DeclaracionAnualDTO> findById(Long id);

    public Optional<List<DeclaracionAnualDTO>> findAll();

    public Optional<DeclaracionAnualDTO> create(DeclaracionAnualDTO declaracionanualDTO);

    public Optional<DeclaracionAnualDTO> update(DeclaracionAnualDTO declaracionanualDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

}
