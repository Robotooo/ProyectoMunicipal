package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.RolDTO;
import org.una.proyecto_Municipal.dto.RutaDTO;
import org.una.proyecto_Municipal.entities.Ruta;

import java.util.Optional;

public interface IRutaService {

    public Optional<RutaDTO> findById(Long id);

    public Optional<RutaDTO> findByEstado(boolean estado);
}
