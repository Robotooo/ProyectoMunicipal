package org.una.proyecto_Municipal.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.ParametroDTO;
import org.una.proyecto_Municipal.dto.SolicitudDTO;
import org.una.proyecto_Municipal.entities.Parametro;
import org.una.proyecto_Municipal.entities.Solicitud;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.IParametroRepository;
import org.una.proyecto_Municipal.repositories.ISolicitudRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudServiceImplementation implements ISolicitudService{

    @Autowired
    private ISolicitudRepository solicitudRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<SolicitudDTO>> findAll(Long funId) {
        solicitudRepository.registrarTransaccion("buscar todos", "Solicitud",funId,null);
        List<SolicitudDTO> parametroDTOList = MapperUtils.DtoListFromEntityList(solicitudRepository.findAll(), SolicitudDTO.class);
        return Optional.ofNullable(parametroDTOList);
    }

    @Override
    public Optional<List<SolicitudDTO>> findByRegistroId(Long registroId, Long funId) {
        solicitudRepository.registrarTransaccion("buscar por id del registro", "Solicitud",funId,String.valueOf(registroId));
        List<SolicitudDTO> parametroDTOList = MapperUtils.DtoListFromEntityList(solicitudRepository.findByRegistroId(registroId), SolicitudDTO.class);
        return Optional.ofNullable(parametroDTOList);
    }

    private SolicitudDTO getSavedParametroDTO(SolicitudDTO solicitudDto) {
        Solicitud parametro = MapperUtils.EntityFromDto(solicitudDto, Solicitud.class);
        Solicitud parametroCreated = solicitudRepository.save(parametro);
        return MapperUtils.DtoFromEntity(parametroCreated, SolicitudDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<SolicitudDTO> create(SolicitudDTO solicitudDto, Long funId) throws ParseException {
        solicitudRepository.registrarTransaccion("crear", "Solicitud",funId,null);
        return Optional.ofNullable(getSavedParametroDTO(solicitudDto));
    }

    @Override
    @Transactional
    public Optional<SolicitudDTO> update(SolicitudDTO solicitudDto, Long id, Long funId) throws ParseException {
        if (solicitudRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        solicitudRepository.registrarTransaccion("actualizar", "Solicitud",funId,String.valueOf(id));

        return Optional.ofNullable(getSavedParametroDTO(solicitudDto));

    }
}