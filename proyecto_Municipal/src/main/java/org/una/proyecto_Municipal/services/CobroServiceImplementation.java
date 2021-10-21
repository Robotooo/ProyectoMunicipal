package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.entities.Cobro;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.ICobroRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CobroServiceImplementation implements ICobroService{

    @Autowired
    private ICobroRepository cobroRepository;

    //findBy...
    @Override
    public Optional<CobroDTO> findById(Long id) {
        Optional<Cobro> cobro = cobroRepository.findById(id);
        if (cobro.isEmpty()) throw new NotFoundInformationException();

        CobroDTO cobroDTO = MapperUtils.DtoFromEntity(cobro.get(), CobroDTO.class);
        return Optional.ofNullable(cobroDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroDTO>> findAll() {
        List<CobroDTO> cobroDTOList = MapperUtils.DtoListFromEntityList(cobroRepository.findAll(), CobroDTO.class);
        return Optional.ofNullable(cobroDTOList);
    }

//    @Override
//    public Optional<List<CobroDTO>> findByBienId(Long id) {
//        List<CobroDTO> cobroDTOList = MapperUtils.DtoListFromEntityList(cobroRepository.findByBienId(id), CobroDTO.class);
//        if (cobroDTOList.isEmpty()) throw new NotFoundInformationException();
//        return Optional.ofNullable(cobroDTOList);
//    }

    @Override
    public Optional<List<CobroDTO>> findByBienxColaboradorId(Long id) {
        List<CobroDTO> cobroDTOList = MapperUtils.DtoListFromEntityList(cobroRepository.findByBienxColaboradorId(id), CobroDTO.class);
        if (cobroDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(cobroDTOList);
    }

    @Override
    public Optional<List<CobroDTO>> findByFacturaId(Long id) {
        List<CobroDTO> cobroDTOList = MapperUtils.DtoListFromEntityList(cobroRepository.findByFacturaId(id), CobroDTO.class);
        if (cobroDTOList.isEmpty()) throw new NotFoundInformationException();
        return Optional.ofNullable(cobroDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroDTO>> findByEstado(boolean estado) {
        List<Cobro> cobroList = cobroRepository.findByEstado(estado);
        List<CobroDTO> cobroDTOList = MapperUtils.DtoListFromEntityList(cobroList, CobroDTO.class);
        return Optional.ofNullable(cobroDTOList);
    }

    //get
    private CobroDTO getSavedCobroDTO(CobroDTO cobroDTO) {
        Cobro cobro = MapperUtils.EntityFromDto(cobroDTO, Cobro.class);
        Cobro cobroCreated = cobroRepository.save(cobro);
        return MapperUtils.DtoFromEntity(cobroCreated, CobroDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<CobroDTO> create(CobroDTO cobroDTO) {
        return Optional.ofNullable(getSavedCobroDTO(cobroDTO));
    }

    @Override
    @Transactional
    public Optional<CobroDTO> update(CobroDTO cobroDTO, Long id) {
        if (cobroRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedCobroDTO(cobroDTO));

    }

    //detele...
    @Override
    @Transactional
    public void delete(Long id) {
        cobroRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        cobroRepository.deleteAll();
    }

}
