package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.ColaboradorDTO;
import org.una.proyecto_Municipal.entities.Colaborador;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.IColaboradorRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorServiceImplementation implements IColaboradorService {

    @Autowired
    private IColaboradorRepository colaboradorRepository;


    @Override
    public Optional<ColaboradorDTO> findById(Long id) {
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if (colaborador.isEmpty()) throw new NotFoundInformationException();

        ColaboradorDTO colaboradorDTO = MapperUtils.DtoFromEntity(colaborador.get(), ColaboradorDTO.class);
        return Optional.ofNullable(colaboradorDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ColaboradorDTO>> findAll() {
        List<ColaboradorDTO> colaboradorDTOList = MapperUtils.DtoListFromEntityList(colaboradorRepository.findAll(), ColaboradorDTO.class);
        return Optional.ofNullable(colaboradorDTOList);
    }

    @Override
    public Optional<List<ColaboradorDTO>> findByEstado(Boolean estado) {
        List<Colaborador> colaboradorList = colaboradorRepository.findByEstado(estado);
        List<ColaboradorDTO> colaboradorDTOList = MapperUtils.DtoListFromEntityList(colaboradorList, ColaboradorDTO.class);
        return Optional.ofNullable(colaboradorDTOList);
    }

    @Override
    public Optional<List<ColaboradorDTO>> findByNombre(String nombre) {
        List<Colaborador> colaboradorList = colaboradorRepository.findByNombre(nombre);
        List<ColaboradorDTO> colaboradorDTOList = MapperUtils.DtoListFromEntityList(colaboradorList, ColaboradorDTO.class);
        return Optional.ofNullable(colaboradorDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ColaboradorDTO>> findByCedulaAproximate(String cedula) {
        List<Colaborador> colaboradorList = colaboradorRepository.findByCedulaContaining(cedula);
        List<ColaboradorDTO> colaboradorDTOList = MapperUtils.DtoListFromEntityList(colaboradorList, ColaboradorDTO.class);
        return Optional.ofNullable(colaboradorDTOList);
    }

    @Override
    public Optional<List<ColaboradorDTO>> findByTelefono(String telefono) {
        List<Colaborador> colaboradorList = colaboradorRepository.findByTelefono(telefono);
        List<ColaboradorDTO> colaboradorDTOList = MapperUtils.DtoListFromEntityList(colaboradorList, ColaboradorDTO.class);
        return Optional.ofNullable(colaboradorDTOList);
    }

    //get
    private ColaboradorDTO getSavedColaboradorDTO(ColaboradorDTO colaboradorDTO) {
        Colaborador colaborador = MapperUtils.EntityFromDto(colaboradorDTO, Colaborador.class);
        Colaborador colaboradorCreated = colaboradorRepository.save(colaborador);
        return MapperUtils.DtoFromEntity(colaboradorCreated, ColaboradorDTO.class);
    }

    //create & update
    @Override
    @Transactional
    public Optional<ColaboradorDTO> create(ColaboradorDTO colaboradorDTO) {
        return Optional.ofNullable(getSavedColaboradorDTO(colaboradorDTO));
    }

    @Override
    @Transactional
    public Optional<ColaboradorDTO> update(ColaboradorDTO colaboradorDTO, Long id) {
        if (colaboradorRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedColaboradorDTO(colaboradorDTO));

    }

    //detele...
    @Override
    @Transactional
    public void delete(Long id) {
        colaboradorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        colaboradorRepository.deleteAll();
    }

}
