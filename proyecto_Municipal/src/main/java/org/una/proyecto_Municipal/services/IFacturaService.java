package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.FacturaDTO;

import java.util.List;
import java.util.Optional;

public interface IFacturaService {

    public Optional<FacturaDTO> findById(long id);

    public Optional<List<FacturaDTO>> findByNombre(String nombre);

    public Optional<List<FacturaDTO>> findByCajeroId(long id);

    public Optional<FacturaDTO> create(FacturaDTO facturaDTO);

    public Optional<FacturaDTO> update(FacturaDTO facturaDTO, long id);

    public void delete(long id);

    public void deleteAll();

}
