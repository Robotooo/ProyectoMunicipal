package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.BienDTO;

import java.util.List;
import java.util.Optional;

public interface IBienService {

    public Optional<BienDTO> findById(Long id, Long funId);

    public Optional<List<BienDTO>> findAll();

    public Optional<BienDTO> create(BienDTO bienDTO, Long funId);

    public Optional<BienDTO> update(BienDTO bienDTO, Long id, Long funId);

    public void delete(Long id, Long funId);

    public void deleteAll();

}
