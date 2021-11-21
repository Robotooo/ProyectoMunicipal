package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.CalendarioDTO;

import java.util.List;
import java.util.Optional;

public interface ICalendarioService {

    public Optional<CalendarioDTO> findById(Long id);

    public Optional<List<CalendarioDTO>> findByTipoAndAnio(Integer tipo, Integer anio);

    public Optional<CalendarioDTO> create(CalendarioDTO calendarioDTO);

    public Optional<CalendarioDTO> update(CalendarioDTO calendarioDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

}
