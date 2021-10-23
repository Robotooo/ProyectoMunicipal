package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.DiaSemanaDTO;
import org.una.proyecto_Municipal.entities.DiaSemana;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.IDiaSemanaRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class DiaSemanaServiceImplementation implements IDiaSemanaService{

    @Autowired
    private IDiaSemanaRepository diasemanaRepository;

    //findBy...
    @Override
    public Optional<DiaSemanaDTO> findById(Long id) {
        Optional<DiaSemana> diasemana = diasemanaRepository.findById(id);
        if (diasemana.isEmpty()) throw new NotFoundInformationException();

        DiaSemanaDTO diasemanaDTO = MapperUtils.DtoFromEntity(diasemana.get(), DiaSemanaDTO.class);
        return Optional.ofNullable(diasemanaDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<DiaSemanaDTO>> findAll() {
        List<DiaSemanaDTO> diasemanaDTOList = MapperUtils.DtoListFromEntityList(diasemanaRepository.findAll(), DiaSemanaDTO.class);
        return Optional.ofNullable(diasemanaDTOList);
    }

    //get
    private DiaSemanaDTO getSavedDiaSemanaDTO(DiaSemanaDTO diasemanaDTO) {
        DiaSemana diasemana = MapperUtils.EntityFromDto(diasemanaDTO, DiaSemana.class);
        DiaSemana diasemanaCreated = diasemanaRepository.save(diasemana);
        return MapperUtils.DtoFromEntity(diasemanaCreated, DiaSemanaDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<DiaSemanaDTO> create(DiaSemanaDTO diasemanaDTO) {
        return Optional.ofNullable(getSavedDiaSemanaDTO(diasemanaDTO));
    }

    //@Override
    @Transactional
    public Optional<DiaSemanaDTO> update(DiaSemanaDTO diasemanaDTO, Long id) {
        if (diasemanaRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedDiaSemanaDTO(diasemanaDTO));

    }

    //detele...
    @Override
    @Transactional
    public void delete(Long id) {
        diasemanaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        diasemanaRepository.deleteAll();
    }

}
