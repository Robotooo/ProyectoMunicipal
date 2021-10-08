package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.ColaboradorDTO;

import java.util.List;
import java.util.Optional;

public interface IFuncionarioService {

    public Optional<ColaboradorDTO> findById(Long id);

    public Optional<List<ColaboradorDTO>> findByEstado(boolean estado);

    public Optional<List<ColaboradorDTO>> findByNombre(String nombre);
}
