package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.ColaboradorDTO;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface IColaboradorService {

    public Optional<ColaboradorDTO> findById(Long id) throws ParseException;

    public Optional<List<ColaboradorDTO>> findAll() throws ParseException;

    public Optional<List<ColaboradorDTO>> findByEstado(boolean estado) throws ParseException;

    public Optional<List<ColaboradorDTO>> findByNombre(String nombre);

    public Optional<List<ColaboradorDTO>> findByCedulaAproximate(String cedula,Long funId);

    public Optional<List<ColaboradorDTO>> findByTelefono(String telefono);

    public Optional<ColaboradorDTO> create(ColaboradorDTO colaboradorDTO) throws ParseException;

    public Optional<ColaboradorDTO> update(ColaboradorDTO colaboradorDTO, Long id) throws ParseException;

    public void delete(Long id) throws ParseException;

    public void deleteAll() throws ParseException;

    Optional<List<ColaboradorDTO>> findByBienId(Long bienId);
}
