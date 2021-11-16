package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.ParametroDTO;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface IParametroService{

    public Optional<ParametroDTO> findById(Long id);

    public Optional<List<ParametroDTO>> findAll();

    public Optional<List<ParametroDTO>> findByNombre(String nombre);

    public Optional<List<ParametroDTO>> findByValor(int valor);

    public Optional<ParametroDTO> create(ParametroDTO parametroDTO) throws ParseException;

    public Optional<ParametroDTO> update(ParametroDTO parametroDTO, Long id) throws ParseException;

    public void delete(Long id) throws ParseException;

    public void deleteAll() throws ParseException;

}
