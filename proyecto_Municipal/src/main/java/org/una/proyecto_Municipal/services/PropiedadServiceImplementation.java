package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.ParametroDTO;
import org.una.proyecto_Municipal.dto.PropiedadDTO;
import org.una.proyecto_Municipal.entities.Propiedad;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.IPropiedadRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

public class PropiedadServiceImplementation implements IPropiedadService{

    @Autowired
    private IPropiedadRepository propiedadRepository;

    @Override
    public Optional<PropiedadDTO> findById(Long id) {

        Optional<Propiedad> propiedad = propiedadRepository.findById(id);
        if (propiedad.isEmpty()) throw new NotFoundInformationException();

        PropiedadDTO usuarioDTO = MapperUtils.DtoFromEntity(propiedad.get(), PropiedadDTO.class);
        return Optional.ofNullable(usuarioDTO);
    }

    @Override
    public Optional<List<PropiedadDTO>> findAll() {
        return Optional.empty();
    }

    @Override
    public Optional<List<PropiedadDTO>> findByNombre(String nombre) {
        return Optional.empty();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<PropiedadDTO>> findByEstado(boolean estado) {
        List<Propiedad> propiedadList = propiedadRepository.findByEstado(estado);
        List<PropiedadDTO> propiedadDTOList = MapperUtils.DtoListFromEntityList(propiedadList, PropiedadDTO.class);
        return Optional.ofNullable(propiedadDTOList);
    }

    @Override
    public Optional<PropiedadDTO> create(PropiedadDTO propiedadDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<PropiedadDTO> update(PropiedadDTO propiedadDTO, Long id) {
        return Optional.empty();
    }
}
