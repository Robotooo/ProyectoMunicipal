package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.CobroDTO;

import java.util.List;
import java.util.Optional;

public interface ICobroService {

    public Optional<CobroDTO> findById(Long id);

    public Optional<List<CobroDTO>> findByEstado(boolean estado);

    public Optional<List<CobroDTO>> findByBienId(Long id);

    //public Optional<List<CobroDTO>> findByColaboradorId(Long id);

    //public Optional<List<CobroDTO>> findByFacturaId(Long id);

    public Optional<CobroDTO> create(CobroDTO cobroDTO);

    public Optional<CobroDTO> update(CobroDTO cobroDTO, Long id);


    //TODO: Función para buscar cobro con número de cédula o número de activo

}
