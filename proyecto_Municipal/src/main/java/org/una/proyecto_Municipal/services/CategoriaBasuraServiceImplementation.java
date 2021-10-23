package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.CategoriaBasuraDTO;
import org.una.proyecto_Municipal.entities.CategoriaBasura;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.ICategoriaBasuraRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaBasuraServiceImplementation implements ICategoriaBasuraService{

    @Autowired
    private ICategoriaBasuraRepository categoriabasuraRepository;

    //findBy...
    @Override
    public Optional<CategoriaBasuraDTO> findById(Long id) {
        Optional<CategoriaBasura> categoriabasura = categoriabasuraRepository.findById(id);
        if (categoriabasura.isEmpty()) throw new NotFoundInformationException();

        CategoriaBasuraDTO categoriabasuraDTO = MapperUtils.DtoFromEntity(categoriabasura.get(), CategoriaBasuraDTO.class);
        return Optional.ofNullable(categoriabasuraDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CategoriaBasuraDTO>> findAll() {
        List<CategoriaBasuraDTO> categoriabasuraDTOList = MapperUtils.DtoListFromEntityList(categoriabasuraRepository.findAll(), CategoriaBasuraDTO.class);
        return Optional.ofNullable(categoriabasuraDTOList);
    }

    //get
    private CategoriaBasuraDTO getSavedCategoriaBasuraDTO(CategoriaBasuraDTO categoriaxpropiedadDTO) {
        CategoriaBasura categoriabasura = MapperUtils.EntityFromDto(categoriaxpropiedadDTO, CategoriaBasura.class);
        CategoriaBasura categoriabasuraCreated = categoriabasuraRepository.save(categoriabasura);
        return MapperUtils.DtoFromEntity(categoriabasuraCreated, CategoriaBasuraDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<CategoriaBasuraDTO> create(CategoriaBasuraDTO categoriaxpropiedadDTO) {
        return Optional.ofNullable(getSavedCategoriaBasuraDTO(categoriaxpropiedadDTO));
    }

    //@Override
    @Transactional
    public Optional<CategoriaBasuraDTO> update(CategoriaBasuraDTO categoriaxpropiedadDTO, Long id) {
        if (categoriabasuraRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedCategoriaBasuraDTO(categoriaxpropiedadDTO));

    }

    //detele...
    @Override
    @Transactional
    public void delete(Long id) {
        categoriabasuraRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        categoriabasuraRepository.deleteAll();
    }

}
