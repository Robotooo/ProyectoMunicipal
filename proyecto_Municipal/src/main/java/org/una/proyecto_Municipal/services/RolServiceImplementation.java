package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.una.proyecto_Municipal.dto.RolDTO;
import org.una.proyecto_Municipal.entities.Rol;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.IRolRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class RolServiceImplementation implements IRolService{


    @Autowired
    private IRolRepository rolRepository;

    @Override
    public Optional<RolDTO> findById(Long id) {
        Optional<Rol> rol = rolRepository.findById(id);
        if (rol.isEmpty()) throw new NotFoundInformationException();

        RolDTO rolDTO = MapperUtils.DtoFromEntity(rol.get(), RolDTO.class);
        return Optional.ofNullable(rolDTO);
    }
/*
    @Override
    public Optional<List<RolDTO>> findByEstado(boolean estado) {
        List<Rol> RolList = rolRepository.findByEstado(estado);
        List<RolDTO> RolDTOList = MapperUtils.DtoListFromEntityList(RolList, RolTO.class);
        return Optional.ofNullable(RolDTOList);
    }

    @Override
    public Optional<List<RolDTO>> findByFechaCreacionBetween(Date startDate, Date endDate) {
        List<Rol> rolList = rolRepository.findByFechaCreacionBetween(startDate, endDate);

        List<RolDTO> rolDTOList = MapperUtils.DtoListFromEntityList(rolList, RolDTO.class);
        return Optional.ofNullable(rolDTOList);
        return Optional.empty();
    }

    @Override
    public Optional<RolDTO> create(RolDTO rolDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<RolDTO> update(RolDTO rolDTO, Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteAll() {

    }*/
}
