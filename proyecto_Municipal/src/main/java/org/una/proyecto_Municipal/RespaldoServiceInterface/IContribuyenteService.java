package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.ContribuyenteDTO;

import java.util.List;
import java.util.Optional;

public interface IContribuyenteService {

    public Optional<ContribuyenteDTO> findById(Long id);

    public Optional<List<ContribuyenteDTO>> findAll();

    public Optional<List<ContribuyenteDTO>> findByNombreAproximateIgnoreCase(String nombre);

    public Optional<List<ContribuyenteDTO>> findByCedulaAproximate(String cedula);

    public Optional<List<ContribuyenteDTO>> findByEstado(boolean estado);

    public Optional<List<ContribuyenteDTO>> findByNombre(String nombre);

    public Optional<ContribuyenteDTO> findByTelefono(String telefono);

    public void delete(Long id);

    public void deleteAll();

    public Optional<ContribuyenteDTO> create(ContribuyenteDTO contribuyenteDTO);

    public Optional<ContribuyenteDTO> update(ContribuyenteDTO contribuyenteDTO, Long id);

}
