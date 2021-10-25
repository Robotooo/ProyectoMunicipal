package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.LicenciaDTO;

import java.util.List;
import java.util.Optional;

public interface ILicenciaService {

    public Optional<LicenciaDTO> findById(Long id);

    public Optional<List<LicenciaDTO>> findAll();

    public Optional<List<LicenciaDTO>> findByNombre(String nombre);

    public Optional<LicenciaDTO> findByTelefono(String telefono);

    public Optional<LicenciaDTO> findByEmail(String email);

    Optional<List<LicenciaDTO>> findByDistrito(String distrito);

    public Optional<List<LicenciaDTO>> findByEstado(boolean estado);

    Optional<List<LicenciaDTO>> findByBienId(Long id);

    public Optional<List<LicenciaDTO>> findPendienteTotalLicencias(String cedula);

    public void delete(Long id);

    public void deleteAll();

    public Optional<LicenciaDTO> create(LicenciaDTO LicenciaDTO);

    public Optional<LicenciaDTO> update(LicenciaDTO LicenciaDTO, Long id);
}
