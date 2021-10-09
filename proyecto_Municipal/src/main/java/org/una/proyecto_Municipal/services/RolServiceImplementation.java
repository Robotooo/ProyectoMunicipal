package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.CobroDTO;
import org.una.proyecto_Municipal.dto.RolDTO;
import org.una.proyecto_Municipal.entities.Cobro;
import org.una.proyecto_Municipal.entities.Rol;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.IRolRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImplementation implements IRolService{

    @Autowired
    private IRolRepository rolRepository;

    //findBy...
    @Override
    public Optional<RolDTO> findById(Long id) {
        Optional<Rol> rol = rolRepository.findById(id);
        if (rol.isEmpty()) throw new NotFoundInformationException();

        RolDTO rolDTO = MapperUtils.DtoFromEntity(rol.get(), RolDTO.class);
        return Optional.ofNullable(rolDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<RolDTO>> findAll() {
        List<RolDTO> rolDTOList = MapperUtils.DtoListFromEntityList(rolRepository.findAll(), RolDTO.class);
        return Optional.ofNullable(rolDTOList);
    }
/*
    @Override
    @Transactional(readOnly = true)
    public Optional<List<RolDTO>> findByNombreContainingAproximateIgnoreCase(String nombre) {
        List<Rol> rolList = rolRepository.findByNombreContainingIgnoreCase(nombre);
        List<RolDTO> rolDTOList = MapperUtils.DtoListFromEntityList(rolList, RolDTO.class);
        return Optional.ofNullable(rolDTOList);
    }
*/

    /*
    @Override
    public Optional<List<RolDTO>> findByFechaCreacionBetween(Date startDate, Date endDate) {
        List<Rol> rolList = rolRepository.findByFechacreacionBetween(startDate, endDate);

        List<RolDTO> rolDTOList = MapperUtils.DtoListFromEntityList(rolList, RolDTO.class);
        return Optional.ofNullable(rolDTOList);

    }

    */


    //detele...
    @Override
    @Transactional
    public void delete(Long id) {
        rolRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        rolRepository.deleteAll();
    }

    //get
    private RolDTO getSavedRolDTO(RolDTO rolDTO) {
        Rol rol = MapperUtils.EntityFromDto(rolDTO, Rol.class);
        Rol rolCreated = rolRepository.save(rol);
        return MapperUtils.DtoFromEntity(rolCreated, RolDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<RolDTO> create(RolDTO rolDTO) {
        return Optional.ofNullable(getSavedRolDTO(rolDTO));
    }

    @Override
    @Transactional
    public Optional<RolDTO> update(RolDTO rolDTO, Long id) {
        if (rolRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedRolDTO(rolDTO));

    }

}
