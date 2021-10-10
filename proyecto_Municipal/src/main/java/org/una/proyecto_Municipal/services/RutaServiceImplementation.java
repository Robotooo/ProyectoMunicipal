package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.RutaDTO;
import org.una.proyecto_Municipal.entities.Ruta;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.IRutaRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

public class RutaServiceImplementation implements IRutaService{

    @Autowired
    private IRutaRepository rutaRepository;

    @Override
    public Optional<RutaDTO> findById(Long id) {
        Optional<Ruta> ruta = rutaRepository.findById(id);
        if (ruta.isEmpty()) throw new NotFoundInformationException();

        RutaDTO rutaDTO = MapperUtils.DtoFromEntity(ruta.get(), RutaDTO.class);
        return Optional.ofNullable(rutaDTO);
    }


//
//    @Override
//    @Transactional(readOnly = true)
//    public Optional<List<RutaDTO>> findAll() {
//        List<RutaDTO> rutaDTOList = MapperUtils.DtoListFromEntityList(rutaRepository.findAll(), RutaDTO.class);
//        return Optional.ofNullable(rutaDTOList);
//    }

    @Override
    public Optional<List<RutaDTO>> findByEstado(boolean estado) {
        List<Ruta> rutaList = rutaRepository.findByEstado(estado);
        List<RutaDTO> rutaDTOList = MapperUtils.DtoListFromEntityList(rutaList, RutaDTO.class);
        return Optional.ofNullable(rutaDTOList);
    }

    @Override
    public Optional<List<RutaDTO>> findByBienId(Long id) {
        return Optional.empty();
    }

//    @Override
//    public Optional<List<RutaDTO>> findByBienId(Long id) {
//        List<RutaDTO> rutaDTOList = MapperUtils.DtoListFromEntityList(rutaRepository.findByBienId(id), RutaDTO.class);
//        if (rutaDTOList.isEmpty()) throw new NotFoundInformationException();
//        return Optional.ofNullable(rutaDTOList);
//    }

//    @Override
//    @Transactional
//    public void delete(Long id) {
//        rutaRepository.deleteById(id);
//    }
//
//    @Override
//    @Transactional
//    public void deleteAll() {
//        rutaRepository.deleteAll();
//    }

    private RutaDTO getSavedRutaDTO(RutaDTO rutaDTO) {
        Ruta ruta = MapperUtils.EntityFromDto(rutaDTO, Ruta.class);
        Ruta rutaCreated = rutaRepository.save(ruta);
        return MapperUtils.DtoFromEntity(rutaCreated , RutaDTO.class);
    }

    @Override
    @Transactional
    public Optional<RutaDTO> create(RutaDTO rutaDTO) {
        return Optional.ofNullable(getSavedRutaDTO(rutaDTO));
    }

    @Override
    @Transactional
    public Optional<RutaDTO> update(RutaDTO rutaDTO, Long id) {
        if (rutaRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedRutaDTO(rutaDTO));

    }
}
