package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.CategoriaxPropiedadDTO;
import org.una.proyecto_Municipal.entities.CategoriaxPropiedad;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.ICategoriaxPropiedadRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaxPropiedadServiceImplementation implements ICategoriaxPropiedadService{

    @Autowired
    private ICategoriaxPropiedadRepository categoriaxpropiedadRepository;

    //findBy...
    @Override
    public Optional<CategoriaxPropiedadDTO> findById(Long id) {
        Optional<CategoriaxPropiedad> categoriaxpropiedad = categoriaxpropiedadRepository.findById(id);
        if (categoriaxpropiedad.isEmpty()) throw new NotFoundInformationException();

        CategoriaxPropiedadDTO categoriaxpropiedadDTO = MapperUtils.DtoFromEntity(categoriaxpropiedad.get(), CategoriaxPropiedadDTO.class);
        return Optional.ofNullable(categoriaxpropiedadDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CategoriaxPropiedadDTO>> findAll() {
        List<CategoriaxPropiedadDTO> categoriaxpropiedadDTOList = MapperUtils.DtoListFromEntityList(categoriaxpropiedadRepository.findAll(), CategoriaxPropiedadDTO.class);
        return Optional.ofNullable(categoriaxpropiedadDTOList);
    }

    //get
    private CategoriaxPropiedadDTO getSavedCategoriaxPropiedadDTO(CategoriaxPropiedadDTO categoriaxpropiedadDTO) {
        CategoriaxPropiedad categoriaxpropiedad = MapperUtils.EntityFromDto(categoriaxpropiedadDTO, CategoriaxPropiedad.class);
        CategoriaxPropiedad categoriaxpropiedadCreated = categoriaxpropiedadRepository.save(categoriaxpropiedad);
        return MapperUtils.DtoFromEntity(categoriaxpropiedadCreated, CategoriaxPropiedadDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<CategoriaxPropiedadDTO> create(CategoriaxPropiedadDTO categoriaxpropiedadDTO) {
        return Optional.ofNullable(getSavedCategoriaxPropiedadDTO(categoriaxpropiedadDTO));
    }

    //@Override
    @Transactional
    public Optional<CategoriaxPropiedadDTO> update(CategoriaxPropiedadDTO categoriaxpropiedadDTO, Long id) {
        if (categoriaxpropiedadRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedCategoriaxPropiedadDTO(categoriaxpropiedadDTO));

    }

    //detele...
    @Override
    @Transactional
    public void delete(Long id) {
        categoriaxpropiedadRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        categoriaxpropiedadRepository.deleteAll();
    }

}
