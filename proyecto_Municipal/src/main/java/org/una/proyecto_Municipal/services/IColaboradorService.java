package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.ColaboradorDTO;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface IColaboradorService {

    public Optional<ColaboradorDTO> findById(Long id, Long funId) throws ParseException;

    public Optional<List<ColaboradorDTO>> findAll(Long funId) throws ParseException;

    public Optional<List<ColaboradorDTO>> findByEstado(boolean estado,Long funId) throws ParseException;

    public Optional<List<ColaboradorDTO>> findByNombre(String nombre,Long funId);

    public Optional<List<ColaboradorDTO>> findByCedulaAproximate(String cedula,Long funId);

    public Optional<List<ColaboradorDTO>> findByTelefono(String telefono,Long funId);

    public Optional<ColaboradorDTO> create(ColaboradorDTO colaboradorDTO,Long funId) throws ParseException;

    public Optional<ColaboradorDTO> update(ColaboradorDTO colaboradorDTO, Long id,Long funId) throws ParseException;

    public void delete(Long id,Long funId) throws ParseException;

    public void deleteAll(Long funId) throws ParseException;

    Optional<List<ColaboradorDTO>> findByBienId(Long bienId,Long funId);
}
