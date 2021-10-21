package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.LicenciaDTO;

import java.util.List;
import java.util.Optional;

public interface ILicenciaService {

    public Optional<LicenciaDTO> findById(long id);

    public Optional<List<LicenciaDTO>> findAll();

    public Optional<List<LicenciaDTO>> findByNombre(String nombre);

    public Optional<LicenciaDTO> findByTelefono(String telefono);

    public Optional<LicenciaDTO> findByEmail(String email);

    Optional<List<LicenciaDTO>> findByDistrito(String distrito);

    public Optional<List<LicenciaDTO>> findByEstado(boolean estado);

    Optional<List<LicenciaDTO>> findByBienId(long id);

    public void delete(long id);

    public void deleteAll();

    public Optional<LicenciaDTO> create(LicenciaDTO LicenciaDTO);

    public Optional<LicenciaDTO> update(LicenciaDTO LicenciaDTO, long id);
}
