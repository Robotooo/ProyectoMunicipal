package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.dto.ParametroDTO;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface IParametroService{

    public Optional<ParametroDTO> findById(Long id);

    public Optional<List<ParametroDTO>> findAll( Long funId);

    public Optional<List<ParametroDTO>> findByNombre(String nombre, Long funId);

    public Optional<List<ParametroDTO>> findByValor(int valor, Long funId);

    public Optional<ParametroDTO> create(ParametroDTO parametroDTO, Long funId) throws ParseException;

    public Optional<ParametroDTO> update(ParametroDTO parametroDTO, Long id, Long funId) throws ParseException;

    public void delete(Long id, Long funId) throws ParseException;

    public void deleteAll() throws ParseException;

    Optional<List<ParametroDTO>> findByEstado(boolean estado, Long funId);
}
