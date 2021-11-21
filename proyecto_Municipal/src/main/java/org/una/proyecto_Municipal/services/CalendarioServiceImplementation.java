package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.CalendarioDTO;
import org.una.proyecto_Municipal.entities.Calendario;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.ICalendarioRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarioServiceImplementation implements ICalendarioService {

    @Autowired
    private ICalendarioRepository calendarioRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<CalendarioDTO> findById(Long id) {
        Optional<Calendario> calendar = calendarioRepository.findById(id);
        if (calendar.isEmpty()) throw new NotFoundInformationException();

        CalendarioDTO calendarioDTO = MapperUtils.DtoFromEntity(calendar.get(), CalendarioDTO.class);
        return Optional.ofNullable(calendarioDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CalendarioDTO>> findByTipoAndAnio(Integer tipo, Integer anio) {
        List<Calendario> calendarioList = calendarioRepository.findByTipoAndAnio(tipo, anio);
        List<CalendarioDTO> calendarioDTOList = MapperUtils.DtoListFromEntityList(calendarioList, CalendarioDTO.class);
        return Optional.ofNullable(calendarioDTOList);
    }

    private CalendarioDTO getSavedCalendarDTO(CalendarioDTO calendarioDTO) {
        Calendario calendar = MapperUtils.EntityFromDto(calendarioDTO, Calendario.class);
        Calendario calendarCreated = calendarioRepository.save(calendar);
        return MapperUtils.DtoFromEntity(calendarCreated, CalendarioDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<CalendarioDTO> create(CalendarioDTO calendarioDTO) {
        return Optional.ofNullable(getSavedCalendarDTO(calendarioDTO));
    }

    @Override
    @Transactional
    public Optional<CalendarioDTO> update(CalendarioDTO calendarioDTO, Long id) {
        if (calendarioRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedCalendarDTO(calendarioDTO));

    }

    //detele...
    @Override
    @Transactional
    public void delete(Long id) {
        calendarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        calendarioRepository.deleteAll();
    }

}
