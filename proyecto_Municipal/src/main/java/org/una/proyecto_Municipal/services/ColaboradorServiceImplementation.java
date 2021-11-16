package org.una.proyecto_Municipal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.proyecto_Municipal.dto.ColaboradorDTO;
import org.una.proyecto_Municipal.entities.Colaborador;
import org.una.proyecto_Municipal.exceptions.NotFoundInformationException;
import org.una.proyecto_Municipal.repositories.IColaboradorRepository;
import org.una.proyecto_Municipal.utils.MapperUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorServiceImplementation implements IColaboradorService {

    @Autowired
    private IColaboradorRepository colaboradorRepository;
    Date date = new SimpleDateFormat("yyyy-mm-dd").parse("2021-11-16");

    public ColaboradorServiceImplementation() throws ParseException {
    }


    @Override
    public Optional<ColaboradorDTO> findById(Long id) throws ParseException {
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if (colaborador.isEmpty()) throw new NotFoundInformationException();
        colaboradorRepository.saveTransaction("buscar por id","Colaborador","2",date);

        ColaboradorDTO colaboradorDTO = MapperUtils.DtoFromEntity(colaborador.get(), ColaboradorDTO.class);
        return Optional.ofNullable(colaboradorDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ColaboradorDTO>> findAll() throws ParseException {
        List<ColaboradorDTO> colaboradorDTOList = MapperUtils.DtoListFromEntityList(colaboradorRepository.findAll(), ColaboradorDTO.class);
        colaboradorRepository.saveTransaction("buscar todos","Colaborador","2",date);

        return Optional.ofNullable(colaboradorDTOList);
    }

    @Override
    public Optional<List<ColaboradorDTO>> findByEstado(boolean estado) throws ParseException {

        List<Colaborador> colaboradorList = colaboradorRepository.findByEstado(estado);
        List<ColaboradorDTO> colaboradorDTOList = MapperUtils.DtoListFromEntityList(colaboradorList, ColaboradorDTO.class);
        colaboradorRepository.saveTransaction("buscarPorEstado","Colaborador","2",date);

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
        colaboradorRepository.saveTransaction("buscar por cedula","Colaborador","2",date);
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
    public Optional<ColaboradorDTO> create(ColaboradorDTO colaboradorDTO) throws ParseException {
        colaboradorRepository.saveTransaction("creacion","Colaborador","2",date);
        return Optional.ofNullable(getSavedColaboradorDTO(colaboradorDTO));
    }

    @Override
    @Transactional
    public Optional<ColaboradorDTO> update(ColaboradorDTO colaboradorDTO, Long id) throws ParseException {
        if (colaboradorRepository.findById(id).isEmpty()) throw new NotFoundInformationException();
        colaboradorRepository.saveTransaction("actualizar","Colaborador","2",date);

        return Optional.ofNullable(getSavedColaboradorDTO(colaboradorDTO));

    }

    //detele...
    @Override
    @Transactional
    public void delete(Long id) throws ParseException {
        colaboradorRepository.saveTransaction("eliminar","Colaborador","2",date);
        colaboradorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() throws ParseException {
        colaboradorRepository.saveTransaction("eliminar todos","Colaborador","2",date);
        colaboradorRepository.deleteAll();
    }

}
