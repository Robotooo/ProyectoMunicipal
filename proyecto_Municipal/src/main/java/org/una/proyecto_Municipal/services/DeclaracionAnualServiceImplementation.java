package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.DeclaracionAnualDTO;
import org.una.proyecto_Municipal.entities.DeclaracionAnual;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.IDeclaracionAnualRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class DeclaracionAnualServiceImplementation implements IDeclaracionAnualService{

    @Autowired
    private IDeclaracionAnualRepository declaracionanualRepository;

    @Override
    public Optional<DeclaracionAnualDTO> findById(Long id) {
        Optional<DeclaracionAnual> declaracionanual = declaracionanualRepository.findById(id);
        if (declaracionanual.isEmpty()) throw new NotFoundInformationException();

        DeclaracionAnualDTO declaracionanualDTO = MapperUtils.DtoFromEntity(declaracionanual.get(), DeclaracionAnualDTO.class);
        return Optional.ofNullable(declaracionanualDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<DeclaracionAnualDTO>> findAll() {
        List<DeclaracionAnualDTO> declaracionanualDTOList = MapperUtils.DtoListFromEntityList(declaracionanualRepository.findAll(), DeclaracionAnualDTO.class);
        return Optional.ofNullable(declaracionanualDTOList);
    }

    //get
    private DeclaracionAnualDTO getSavedDeclaracionAnualDTO(DeclaracionAnualDTO declaracionanualDTO) {
        DeclaracionAnual declaracionanual = MapperUtils.EntityFromDto(declaracionanualDTO, DeclaracionAnual.class);
        DeclaracionAnual declaracionanualCreated = declaracionanualRepository.save(declaracionanual);
        return MapperUtils.DtoFromEntity(declaracionanualCreated, DeclaracionAnualDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<DeclaracionAnualDTO> create(DeclaracionAnualDTO declaracionanualDTO) {
        return Optional.ofNullable(getSavedDeclaracionAnualDTO(declaracionanualDTO));
    }

    //@Override
    @Transactional
    public Optional<DeclaracionAnualDTO> update(DeclaracionAnualDTO declaracionanualDTO, Long id) {
        if (declaracionanualRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedDeclaracionAnualDTO(declaracionanualDTO));

    }

    //detele...
    @Override
    @Transactional
    public void delete(Long id) {
        declaracionanualRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        declaracionanualRepository.deleteAll();
    }

}
