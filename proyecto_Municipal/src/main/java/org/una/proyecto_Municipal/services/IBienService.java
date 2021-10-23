package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.BienDTO;

import java.util.List;
import java.util.Optional;

public interface IBienService {

    public Optional<BienDTO> findById(Long id);

    public Optional<List<BienDTO>> findAll();

    public Optional<BienDTO> create(BienDTO bienDTO);

    public Optional<BienDTO> update(BienDTO bienDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

}
