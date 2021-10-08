package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.ColaboradorDTO;
import org.una.proyecto_Municipal.repositories.IFuncionarioRepository;

import java.util.List;
import java.util.Optional;

public class FuncionarioServiceImplementation implements IFuncionarioService {
    @Override
    public Optional<ColaboradorDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ColaboradorDTO>> findByEstado(boolean estado) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ColaboradorDTO>> findByNombre(String nombre) {
        return Optional.empty();
    }
}
