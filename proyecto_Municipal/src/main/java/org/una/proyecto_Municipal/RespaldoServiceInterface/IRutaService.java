package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.RutaDTO;

import java.util.List;
import java.util.Optional;

public interface IRutaService {

    public Optional<RutaDTO> findById(Long id);

    public Optional<List<RutaDTO>> findAll();

    public Optional<List<RutaDTO>> findByBienId(Long id);

    public Optional<List<RutaDTO>> findByEstado(Boolean estado);

    public void delete(Long id);

    public void deleteAll();

    public Optional<RutaDTO> create(RutaDTO rutaDTO);

    public Optional<RutaDTO> update(RutaDTO rutaDTO, Long id);
}
