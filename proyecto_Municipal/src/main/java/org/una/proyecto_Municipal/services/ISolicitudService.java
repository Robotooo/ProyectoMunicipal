package org.una.proyecto_Municipal.services;

import org.una.proyecto_Municipal.dto.ParametroDTO;
import org.una.proyecto_Municipal.dto.SolicitudDTO;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface ISolicitudService {

    public Optional<List<SolicitudDTO>> findAll(Long funId);

    public Optional<List<SolicitudDTO>> findByRegistroId(Long registroId, Long funId);

    public Optional<SolicitudDTO> create(SolicitudDTO solicitudDto, Long funId) throws ParseException;

    public Optional<SolicitudDTO> update(SolicitudDTO solicitudDto, Long id, Long funId) throws ParseException;

}
