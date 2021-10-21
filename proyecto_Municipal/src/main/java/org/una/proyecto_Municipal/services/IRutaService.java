package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.RolDTO;
import org.una.proyecto_Municipal.dto.RutaDTO;
import org.una.proyecto_Municipal.entities.Ruta;

import java.util.List;
import java.util.Optional;

public interface IRutaService {

    public Optional<RutaDTO> findById(long id);

    public Optional<List<RutaDTO>> findAll();

    public Optional<List<RutaDTO>> findByEstado(boolean estado);

    public Optional<List<RutaDTO>> findByBienId(long id);

    public Optional<RutaDTO> create(RutaDTO rutaDTO);

    public Optional<RutaDTO> update(RutaDTO rutaDTO, long id);

    public void delete(long id);

    public void deleteAll();

}
