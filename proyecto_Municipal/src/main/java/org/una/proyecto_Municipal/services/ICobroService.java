package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.CobroDTO;

import java.util.List;
import java.util.Optional;

public interface ICobroService {

    public Optional<CobroDTO> findById(long id);

    public Optional<List<CobroDTO>> findAll();

    public Optional<List<CobroDTO>> findByEstado(boolean estado);

//    public Optional<List<CobroDTO>> findByBienId(long id);

    public Optional<List<CobroDTO>> findByBienxColaboradorId(long id);

    public Optional<List<CobroDTO>> findByFacturaId(long id);

    public Optional<CobroDTO> create(CobroDTO cobroDTO);

    public Optional<CobroDTO> update(CobroDTO cobroDTO, long id);

    public void delete(long id);

    public void deleteAll();

    //TODO: Función para buscar cobro con número de cédula o número de activo

}
