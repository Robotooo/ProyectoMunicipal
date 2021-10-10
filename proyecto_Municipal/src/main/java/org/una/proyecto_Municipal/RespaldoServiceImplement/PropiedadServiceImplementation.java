package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.PropiedadDTO;
import org.una.proyecto_Municipal.entities.Propiedad;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.IPropiedadRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class PropiedadServiceImplementation implements IPropiedadService{

    @Autowired
    private IPropiedadRepository propiedadRepository;

    //findBy...
    @Override
    public Optional<PropiedadDTO> findById(Long id) {
        Optional<Propiedad> propiedad = propiedadRepository.findById(id);
        if (propiedad.isEmpty()) throw new NotFoundInformationException();

        PropiedadDTO usuarioDTO = MapperUtils.DtoFromEntity(propiedad.get(), PropiedadDTO.class);
        return Optional.ofNullable(usuarioDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<PropiedadDTO>> findAll() {
        List<PropiedadDTO> propiedadDTOList = MapperUtils.DtoListFromEntityList(propiedadRepository.findAll(), PropiedadDTO.class);
        return Optional.ofNullable(propiedadDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<PropiedadDTO>> findByEstado(Boolean estado) {
        List<Propiedad> propiedadList = propiedadRepository.findByEstado(estado);
        List<PropiedadDTO> propiedadDTOList = MapperUtils.DtoListFromEntityList(propiedadList, PropiedadDTO.class);
        return Optional.ofNullable(propiedadDTOList);
    }

    //detele...
    @Override
    @Transactional
    public void delete(Long id) {
        propiedadRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        propiedadRepository.deleteAll();
    }

    //get
    private PropiedadDTO getSavedPropiedadDTO(PropiedadDTO propiedadDTO) {
        Propiedad propiedad = MapperUtils.EntityFromDto(propiedadDTO, Propiedad.class);
        Propiedad propiedadCreated = propiedadRepository.save(propiedad);
        return MapperUtils.DtoFromEntity(propiedadCreated, PropiedadDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<PropiedadDTO> create(PropiedadDTO propiedadDTO) {
        return Optional.ofNullable(getSavedPropiedadDTO(propiedadDTO));
    }

    @Override
    @Transactional
    public Optional<PropiedadDTO> update(PropiedadDTO propiedadDTO, Long id) {
        if (propiedadRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedPropiedadDTO(propiedadDTO));

    }

}
