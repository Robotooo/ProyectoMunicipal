package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.CategoriaBasuraDTO;

import java.util.List;
import java.util.Optional;

public interface ICategoriaBasuraService {

    public Optional<CategoriaBasuraDTO> findById(Long id);

    public Optional<List<CategoriaBasuraDTO>> findAll();

    public Optional<CategoriaBasuraDTO> create(CategoriaBasuraDTO categoriabasuraDTO);

    public Optional<CategoriaBasuraDTO> update(CategoriaBasuraDTO categoriabasuraDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

}
